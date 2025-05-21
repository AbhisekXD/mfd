package com.cyfrifpro.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.cyfrifpro.model.UCC.FirstPersonalInformation;
import com.cyfrifpro.payloads.FirstPersonalInformationDTO;
import org.springframework.web.bind.annotation.RequestBody;
import com.cyfrifpro.services.FirstPersonalInformationService;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api/firstPersonalInformation")
public class FirstPersonalInformationController {

    private static final Logger log = LoggerFactory.getLogger(FirstPersonalInformationController.class);

    @Autowired
    private FirstPersonalInformationService firstPersonalInformationService;

    /**
     * Endpoint to save a new FirstPersonalInformation entity.
     * 
     * @param firstPersonalInformationDTO the DTO containing the data
     * @return ResponseEntity with the saved entity
     */
    @PostMapping
    public ResponseEntity<FirstPersonalInformation> saveFirstPersonalInformation(
            @RequestBody FirstPersonalInformationDTO firstPersonalInformationDTO) {
        System.out.println("Payload received: " + firstPersonalInformationDTO);
        FirstPersonalInformation savedEntity = firstPersonalInformationService.saveFirstPersonalInformation(firstPersonalInformationDTO);
        return new ResponseEntity<>(savedEntity, HttpStatus.CREATED);
    }


    /**
     * Endpoint to update an existing FirstPersonalInformation entity completely.
     * 
     * @param id the ID of the entity to update
     * @param firstPersonalInformationDTO the DTO containing the new data
     * @return ResponseEntity with the updated entity
     */
    @PutMapping("/{id}")
    public ResponseEntity<FirstPersonalInformation> updateFirstPersonalInformationComplete(@PathVariable Long id,
            @RequestBody FirstPersonalInformationDTO firstPersonalInformationDTO) {
        log.debug("Received DTO for complete update with ID {}: {}", id, firstPersonalInformationDTO);
        FirstPersonalInformation updatedEntity = firstPersonalInformationService
                .updateFirstPersonalInformationComplete(id, firstPersonalInformationDTO);
        return new ResponseEntity<>(updatedEntity, HttpStatus.OK);
    }

    /**
     * Endpoint to partially update an existing FirstPersonalInformation entity.
     * 
     * @param id the ID of the entity to update
     * @param firstPersonalInformationDTO the DTO containing the partial data
     * @return ResponseEntity with the updated entity
     */
    @PatchMapping("/{id}")
    public ResponseEntity<FirstPersonalInformation> updateFirstPersonalInformationPartial(@PathVariable Long id,
            @RequestBody FirstPersonalInformationDTO firstPersonalInformationDTO) {
        log.debug("Received DTO for partial update with ID {}: {}", id, firstPersonalInformationDTO);
        FirstPersonalInformation updatedEntity = firstPersonalInformationService
                .updateFirstPersonalInformationPartial(id, firstPersonalInformationDTO);
        return new ResponseEntity<>(updatedEntity, HttpStatus.OK);
    }
    
    // Endpoint to get all users
    @GetMapping("/getAll")
    public ResponseEntity<List<FirstPersonalInformation>> getAllUsers() {
        List<FirstPersonalInformation> users = firstPersonalInformationService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    /**
     * Health check endpoint for testing the controller.
     * 
     * @return ResponseEntity with a success message
     */
    @GetMapping("/health")
    public ResponseEntity<String> healthCheck() {
        log.info("Health check endpoint accessed.");
        return new ResponseEntity<>("FirstPersonalInformationController is up and running!", HttpStatus.OK);
    }
}
