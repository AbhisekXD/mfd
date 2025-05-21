package com.cyfrifpro.restcontrollers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cyfrifpro.model.MutualFundEntity;
import com.cyfrifpro.payloads.MutualFundDetailsBySchemeNameResponse;
import com.cyfrifpro.payloads.apimf.MutualFundDetailsResponse;
import com.cyfrifpro.services.impl.MutualFundService;

@RestController
@RequestMapping("/mutual-funds")
public class MutualFundController {
	
    private static final Logger log = LoggerFactory.getLogger(MutualFundController.class);

    private final MutualFundService mutualFundService;

    public MutualFundController(MutualFundService mutualFundService) {
        this.mutualFundService = mutualFundService;
    }
    
    /**
     * Endpoint to manually trigger mutual fund update.
     */
    @GetMapping("/update")
    public CompletableFuture<ResponseEntity<Map<String, Object>>> updateMutualFunds() {
        return mutualFundService.getAllMutualFundsAsync()
            .<ResponseEntity<Map<String, Object>>>thenApply(result -> {
                log.info("Controller: Mutual fund update completed.");
                return ResponseEntity.ok(
                    createResponse(true, "Mutual fund data updated successfully.", null)
                );
            })
            .exceptionally(ex -> {
                log.error("Error during mutual fund update: {}", ex.getMessage(), ex);
                return ResponseEntity.internalServerError().body(
                    createResponse(false, "An unexpected error occurred: " + ex.getMessage(), ex.getMessage())
                );
            });
    }

    // Helper method to create a response map.
    private Map<String, Object> createResponse(boolean success, String message, Object errors) {
        Map<String, Object> response = new HashMap<>();
        response.put("success", success);
        response.put("message", message != null ? message : "No message provided.");
        response.put("errors", errors);
        return response;
    }

    /**
     * Endpoint to fetch all mutual fund entities from the database.
     * This endpoint is asynchronous for fast, non-blocking execution.
     */
    @GetMapping("/db")
    public CompletableFuture<ResponseEntity<List<MutualFundEntity>>> getAllMutualFundsFromDb() {
        return mutualFundService.getAllMutualFundsFromDb()
            .thenApply(ResponseEntity::ok)
            .exceptionally(ex -> {
                log.error("Error fetching data from DB: {}", ex.getMessage(), ex);
                return ResponseEntity.internalServerError().build();
            });
    }

    /**
     * Endpoint to fetch details for a specific mutual fund by scheme code.
     */
    
    @GetMapping("/schemeCode/{schemeCode}")
    public CompletableFuture<ResponseEntity<MutualFundDetailsResponse>> getMutualFundDetailsbySchemeCode(@PathVariable String schemeCode) {
        return mutualFundService.getMutualFundDetailsAsync(schemeCode)
                .thenApply(ResponseEntity::ok)
                .exceptionally(ex -> {
                    log.error("Error fetching fund details for schemeCode {}: {}", schemeCode, ex.getMessage(), ex);
                    return ResponseEntity.internalServerError().build();
                });
    }
    
    @GetMapping("/schemeName")
    public CompletableFuture<ResponseEntity<List<MutualFundDetailsBySchemeNameResponse>>> getMutualFundDetailsBySchemeName(
            @RequestParam("q") String schemeName) {
        return mutualFundService.getMutualFundBySchemeName(schemeName)
                .thenApply(response -> ResponseEntity.ok(response))
                .exceptionally(ex -> {
                    log.error("Error fetching fund details for schemeName {}: {}", schemeName, ex.getMessage(), ex);
                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
                });
    }
    
    @GetMapping("/{schemeCode}/latest")
    public CompletableFuture<ResponseEntity<MutualFundDetailsResponse>> getMutualFundDetailsLatest(@PathVariable String schemeCode) {
        return mutualFundService.getMutualFundDetailslatestAsync(schemeCode)
                .thenApply(ResponseEntity::ok)
                .exceptionally(ex -> {
                    log.error("Error fetching fund details for schemeCode {}: {}", schemeCode, ex.getMessage(), ex);
                    return ResponseEntity.internalServerError().build();
                });
    }
}
