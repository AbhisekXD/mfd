package com.cyfrifpro.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cyfrifpro.payloads.distributor.DistributorDetailsDTO;
import com.cyfrifpro.services.DistributorDetailsService;

@RestController
@RequestMapping("/api/distributors")
public class DistributorController {
	
    @Autowired
    private DistributorDetailsService distributorDetailsService;

    @PostMapping({"/create"})
    public ResponseEntity<Object> createDistributor(@RequestBody DistributorDetailsDTO dto) {
        return ResponseEntity.ok(distributorDetailsService.saveDistributorDetails(dto));
    }

    @GetMapping({"/getAll"})
    public ResponseEntity<Object> getDistributors() {
        return ResponseEntity.ok(distributorDetailsService.getDistributorDetails());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Object> getDistributor(@PathVariable Long id) {
        return ResponseEntity.ok(distributorDetailsService.getDistributorDetails(id));
    }
    
    @GetMapping("/email/{email}")
    public ResponseEntity<Object> getDistributor(@PathVariable String email) {
        return ResponseEntity.ok(distributorDetailsService.getDistributorDetails(email));
    }
}
