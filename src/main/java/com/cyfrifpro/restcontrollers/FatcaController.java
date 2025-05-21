package com.cyfrifpro.restcontrollers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cyfrifpro.model.FATCA.Fatca;
import com.cyfrifpro.payloads.FatcaDTO;
import com.cyfrifpro.payloads.GetPasswordDTO;
import com.cyfrifpro.services.FatcaService;

@RestController
@RequestMapping("/fatca")
public class FatcaController {
	
	@Autowired
	private FatcaService fatcaService;
    
    @PostMapping("/getPassword")
    public String getPassword(@RequestBody GetPasswordDTO getPasswordDTO) {
        return fatcaService.getPassword(getPasswordDTO);
    }

    @PostMapping("/createFatca")
    public ResponseEntity<String> createFatca(@RequestBody FatcaDTO fatcaDTO) {
        // Call the service to create Fatca and process the SOAP response
        String response = fatcaService.createFatca(fatcaDTO);

        // Check the response to determine success
        if (response.contains("100|RECORD INSERTED SUCCESSFULLY")) {
            // Save the Fatca entity to the database if the response is successful
            fatcaService.saveFatca(fatcaDTO);  // Save Fatca to DB

            // Return a successful response
            return new ResponseEntity<>("Fatca record inserted successfully.", HttpStatus.CREATED);
        } else {
            // Handle failure case (return failure response)
            return new ResponseEntity<>("Failed to insert Fatca record. Response: " + response, HttpStatus.BAD_REQUEST);
        }
    }

    // Endpoint to update an existing Fatca entity (Complete Update - PUT)
    @PutMapping("/put/{id}")
    public ResponseEntity<Fatca> updateFatcaComplete(@PathVariable Long id, @RequestBody FatcaDTO fatcaDTO) {
        // Update the existing Fatca entity completely and return the updated entity
        Fatca updatedFatca = fatcaService.updateFatcaComplete(id, fatcaDTO);
        return new ResponseEntity<>(updatedFatca, HttpStatus.OK);
    }
    
    // Endpoint to update an existing Fatca entity (Partial Update - PATCH)
    @PatchMapping("/patch/{id}")
    public ResponseEntity<Fatca> patchFatca(@PathVariable Long id, @RequestBody FatcaDTO fatcaDTO) {
        // Update the existing Fatca entity partially and return the updated entity
        Fatca updatedFatca = fatcaService.updateFatcaPartial(id, fatcaDTO); // Can handle partial updates in service
        return new ResponseEntity<>(updatedFatca, HttpStatus.OK);
    }
}
