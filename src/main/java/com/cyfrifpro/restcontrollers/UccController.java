package com.cyfrifpro.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cyfrifpro.payloads.ApiResponse;
import com.cyfrifpro.payloads.FirstPersonalInformationDTO;
import com.cyfrifpro.payloads.ResponseParameter;
import com.cyfrifpro.services.FirstPersonalInformationService;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.validation.Valid;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;

@RestController
@RequestMapping("/ucc")
@EnableAsync
public class UccController {

    private static final Logger logger = LoggerFactory.getLogger(UccController.class);

    private final String externalApiUrl = "https://bsestarmfdemo.bseindia.com/BSEMFWEBAPI/UCCAPI/UCCRegistration";

    @Autowired
    private WebClient.Builder webClientBuilder;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private FirstPersonalInformationService firstPersonalInformationService;

    @Async
    @PostMapping("/client_register")
    public CompletableFuture<ResponseEntity<ApiResponse>> registerUcc(@Valid @RequestBody FirstPersonalInformationDTO firstPersonalInformationDTO) {
    	
        //logger.debug("Received DTO: {}", firstPersonalInformationDTO);

        return CompletableFuture.supplyAsync(() -> {
            try {
                // Step 1: Generate the parameter string
                String param = firstPersonalInformationService.generateParamString(firstPersonalInformationDTO);
                logger.debug("Generated Param: {}", param);
                System.err.println(param);

                // Step 2: Construct the payload
                Map<String, Object> requestMap = new LinkedHashMap<>();
                requestMap.put("UserId", firstPersonalInformationDTO.getUserId());
                requestMap.put("MemberCode", firstPersonalInformationDTO.getMemberCode());
                requestMap.put("Password", firstPersonalInformationDTO.getPassword());
                requestMap.put("RegnType", firstPersonalInformationDTO.getRegnType());
                requestMap.put("Param", param);
                requestMap.put("Filler1", firstPersonalInformationDTO.getPayloadfiller1());
                requestMap.put("Filler2", firstPersonalInformationDTO.getPayloadfiller2());

                String requestBody = objectMapper.writeValueAsString(requestMap);
                //logger.debug("Constructed Payload: {}", requestBody);

                // Step 3: Send the API request using WebClient
                WebClient webClient = webClientBuilder.baseUrl(externalApiUrl).build();
                String responseBody = webClient.post()
                        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                        .bodyValue(requestBody)
                        .retrieve()
                        .bodyToMono(String.class)
                        .block();

                logger.debug("API Response: {}", responseBody);
                System.err.println(responseBody);

                // Step 4: Parse the response
                ResponseParameter responseParameter = objectMapper.readValue(responseBody, ResponseParameter.class);
                logger.debug("Parsed Response: {}", responseParameter);

                // Step 5: Handle response status
                if ("0".equals(responseParameter.getStatus())) {
                    logger.debug("Response indicates success. Processing database operation.");

                    boolean isSaved;
                    if ("MOD".equalsIgnoreCase(firstPersonalInformationDTO.getRegnType())) {
                        isSaved = firstPersonalInformationService.updatePersonalInformationByClientCodeUcc(
                                firstPersonalInformationDTO.getClientCodeUcc(),
                                firstPersonalInformationDTO
                        );
                    } else {
                        isSaved = firstPersonalInformationService.savePersonalInformationIfValid(firstPersonalInformationDTO);
                    }
                    				
                    ApiResponse apiResponse = isSaved
                            ? new ApiResponse(true, "UCC Registration Successful and Data Saved/Updated")
                            : new ApiResponse(false, "UCC Registration Successful, but failed to save/update data");

                    return ResponseEntity.status(isSaved ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR).body(apiResponse);
                } else {
                    logger.error("API failed: {}", responseParameter.getRemarks());
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                            .body(new ApiResponse(false, "API failed with remarks: " + responseParameter.getRemarks()));
                }
            } catch (Exception e) {
                logger.error("Error during UCC registration: ", e);
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body(new ApiResponse(false, "An error occurred: " + e.getMessage()));
            }
        });
    }
}
