package com.cyfrifpro.restcontrollers.NSE;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cyfrifpro.services.NSE.NseApiService;

@RestController
@RequestMapping("/api/nse")
public class NseApiController {

    private final NseApiService nseApiService;

    public NseApiController(NseApiService nseApiService) {
        this.nseApiService = nseApiService;
    }

    @GetMapping("/connect")
    public ResponseEntity<String> connectToNse() {
        return nseApiService.connectToNseApi();
    }
}
