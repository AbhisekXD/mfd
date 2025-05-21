package com.cyfrifpro.restcontrollers.NSE;

import com.cyfrifpro.model.NSE.NSEClientInformation;
import com.cyfrifpro.util.NseCommonAuthService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/nse")
public class NSEClientController {

    private static final Logger logger = LoggerFactory.getLogger(NSEClientController.class);
    private final NseCommonAuthService commonAuthService;

    public NSEClientController(NseCommonAuthService commonAuthService) {
        this.commonAuthService = commonAuthService;
    }

    @PostMapping("/send")
    public ResponseEntity<String> sendClientData(@RequestBody NSEClientInformation clientInformation) {
        try {
            logger.info("Sending data to NSE API: {}", clientInformation);
            String response = commonAuthService.callApi(
                    "https://www.nseinvest.com/nsemfdesk/api/v2/registration/CLIENTCOMMON", 
                    clientInformation);
            logger.info("Response from NSE API: {}", response);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            logger.error("Error occurred while sending data: {}", e.getMessage());
            return ResponseEntity.status(500).body("Error occurred: " + e.getMessage());
        }
    }
}