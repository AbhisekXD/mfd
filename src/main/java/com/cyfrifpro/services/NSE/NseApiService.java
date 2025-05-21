package com.cyfrifpro.services.NSE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Service
public class NseApiService {

	@Autowired
    private RestTemplate restTemplate;

    @Value("${nse.api.secret}")
    private String apiSecret;

    @Value("${nse.api.memberLicenseKey}")
    private String memberLicenseKey;

    @Value("${nse.api.uatUrl}")
    private String uatUrl;

    public NseApiService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResponseEntity<String> connectToNseApi() {
        // API URL
        String apiUrl = uatUrl + "/nsemfdesk/api/v2/registration/CLIENTCOMMON"; // Replace "your-endpoint" with the desired endpoint

        // Request headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("User-Agent", "PostmanRuntime/7.43.0");
        headers.set("Host", "uat-ipo.nseindia.com");
        headers.set("Connection", "keep-alive");
        headers.set("Accept-Encoding", "gzip, deflate, br");
        headers.set("Accept-Language", "en-US");
        headers.set("Accept", "*/*");
        headers.set("API-Secret", apiSecret);
        headers.set("API-Member-License-Key", memberLicenseKey);

        // Request entity
        HttpEntity<String> entity = new HttpEntity<>(null, headers);

        // Send request
        return restTemplate.exchange(apiUrl, HttpMethod.GET, entity, String.class);
    }
}
