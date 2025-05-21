package com.cyfrifpro.util;

import java.util.Base64;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;

@Service
public class NseCommonAuthService {

    private static final Logger logger = LoggerFactory.getLogger(NseCommonAuthService.class);

    private static final String API_SECRET = "2B194F218906A33FE06317C211AC05CA";
    private static final String LICENSE_KEY = "2B194F218906A33FE06317C211AC05CA";
    private static final String USER_ID = "ADMIN";
    private static final String MEMBER_ID = "07920";

    private final WebClient webClient;

    // The SslContextProvider is injected to set up SSL for WebClient
    public NseCommonAuthService(SslContextProvider sslContextProvider) throws Exception {
        var sslContext = sslContextProvider.createSslContext();
        HttpClient httpClient = HttpClient.create().secure(spec -> spec.sslContext(sslContext));
        this.webClient = WebClient.builder()
                .baseUrl("https://www.nseinvest.com")
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .build();
    }

    public String callApi(String apiUrl, Object payload) {
        try {
            // Generate encrypted password using your utility
            String encryptedPassword = NSEEncryptionUtil.generateEncryptedPassword(API_SECRET, LICENSE_KEY);

            // Construct the Basic Authorization header
            String authorizationHeader = "BASIC " + Base64.getEncoder().encodeToString((USER_ID + ":" + encryptedPassword).getBytes());
            logger.debug("Generated Authorization Header: {}", authorizationHeader);

            // Perform the POST request and block for the response
            return webClient.post()
                    .uri(apiUrl)
                    .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                    .header("memberId", MEMBER_ID)
                    .header(HttpHeaders.AUTHORIZATION, authorizationHeader)
                    .bodyValue(payload)
                    .retrieve()
                    .onStatus(
                        status -> !status.is2xxSuccessful(),
                        response -> response.bodyToMono(String.class)
                                .flatMap(body -> {
                                    logger.error("API Error: Status {} - Body: {}", response.statusCode(), body);
                                    return Mono.error(new RuntimeException("API error: " + body));
                                })
                    )
                    .bodyToMono(String.class)
                    .doOnError(e -> logger.error("Error occurred while calling API: {}", e.getMessage()))
                    .block();
        } catch (Exception e) {
            logger.error("Unexpected error occurred while calling API: {}", e.getMessage());
            return "Error: " + e.getMessage();
        }
    }
}