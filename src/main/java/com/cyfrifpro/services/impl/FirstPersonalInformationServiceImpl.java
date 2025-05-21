package com.cyfrifpro.services.impl;

import com.cyfrifpro.mapper.FirstPersonalInformationMapper;
import com.cyfrifpro.model.UCC.FirstPersonalInformation;
import com.cyfrifpro.payloads.FirstPersonalInformationDTO;
import com.cyfrifpro.repositories.FirstPersonalInformationRepo;
import com.cyfrifpro.services.FirstPersonalInformationService;
import com.cyfrifpro.util.ParamStringBuilder;

import jakarta.persistence.EntityNotFoundException;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FirstPersonalInformationServiceImpl implements FirstPersonalInformationService {

	@Autowired
	private FirstPersonalInformationRepo firstPersonalInformationRepo;
	
	@Autowired
	private FirstPersonalInformationMapper firstPersonalInformationMapper;


    public FirstPersonalInformation saveFirstPersonalInformation(FirstPersonalInformationDTO firstPersonalInformationDTO) {
    	System.out.println(firstPersonalInformationDTO);  // Print out the DTO object to see if fields are populated

        // Convert DTO to new entity (PUT logic)
        FirstPersonalInformation FirstPersonalInformation = firstPersonalInformationMapper.mapToEntity(firstPersonalInformationDTO, null, false);
        System.out.println(FirstPersonalInformation);
        return firstPersonalInformationRepo.save(FirstPersonalInformation);
    }


    public FirstPersonalInformation updateFirstPersonalInformationComplete(Long id, FirstPersonalInformationDTO firstPersonalInformationDTO) {
        // Find existing entity by ID
        FirstPersonalInformation existingFirstPersonalInformation = firstPersonalInformationRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("FirstPersonalInformation not found with id: " + id));

        // Update the entity with new data (PUT logic)
        FirstPersonalInformation updatedEntity = firstPersonalInformationMapper.mapToEntity(firstPersonalInformationDTO, existingFirstPersonalInformation, false);

        // Save and return the updated entity
        return firstPersonalInformationRepo.save(updatedEntity);
    }

 
    public FirstPersonalInformation updateFirstPersonalInformationPartial(Long id, FirstPersonalInformationDTO firstPersonalInformationDTO) {
        // Find existing entity by ID
        FirstPersonalInformation existingFirstPersonalInformation = firstPersonalInformationRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("FirstPersonalInformation not found with id: " + id));

        // Partially update the entity with new data (PATCH logic)
        FirstPersonalInformation updatedFirstPersonalInformation = firstPersonalInformationMapper.mapToEntity(firstPersonalInformationDTO, existingFirstPersonalInformation, true);

        // Save and return the updated entity
        return firstPersonalInformationRepo.save(updatedFirstPersonalInformation);
    }
    
 // Save method (for "NEW" registration type)
    public boolean savePersonalInformationIfValid(FirstPersonalInformationDTO firstPersonalInformationDTO) {
        try {
            // Convert DTO to Entity
            FirstPersonalInformation firstPersonalInformation = firstPersonalInformationMapper.mapToEntity(
                    firstPersonalInformationDTO, null, false);

            // Save the entity to the database
            firstPersonalInformationRepo.save(firstPersonalInformation);
            return true; // Indicate success
        } catch (Exception e) {
            // Log and return failure
            e.printStackTrace();
            return false;
        }
    }

    // Update method (for "MOD" registration type)
    public boolean updatePersonalInformationByClientCodeUcc(String clientCodeUcc, FirstPersonalInformationDTO firstPersonalInformationDTO) {
        try {
            // Find existing entity by ClientCodeUcc
            FirstPersonalInformation existingEntity = firstPersonalInformationRepo.findByClientCodeUcc(clientCodeUcc)
                    .orElseThrow(() -> new EntityNotFoundException("FirstPersonalInformation not found with ClientCodeUcc: " + clientCodeUcc));

            // Update existing entity with new data
            FirstPersonalInformation updatedEntity = firstPersonalInformationMapper.mapToEntity(
                    firstPersonalInformationDTO, existingEntity, false);

            // Save updated entity to the database
            firstPersonalInformationRepo.save(updatedEntity);
            return true; // Indicate success
        } catch (Exception e) {
            // Log and return failure
            e.printStackTrace();
            return false;
        }
    }
    
	public String generateParamString(FirstPersonalInformationDTO firstPersonalInformationDTO) {
	    // Define excluded fields
	    Set<String> excludedFields = new HashSet<>();
	    excludedFields.add("id");
	    excludedFields.add("userId");
	    excludedFields.add("memberCode");
	    excludedFields.add("password");
	    excludedFields.add("regnType");
	    excludedFields.add("createdAt");
	    excludedFields.add("payloadfiller1");
	    excludedFields.add("payloadfiller2");

	    // If excludedFields is empty or null, it will include all fields
	    if (excludedFields.isEmpty()) {
	        excludedFields = null;  // Pass null to include all fields without exclusion
	    }

	    // Generate param string using ParamStringBuilder
	    return ParamStringBuilder.buildParamString(firstPersonalInformationDTO, excludedFields);
	}

	public List<FirstPersonalInformation> getAllData() {
        return firstPersonalInformationRepo.findAll();
    }
	
	// Method to find by ID
    public Optional<FirstPersonalInformation> getById(Long id) {
        return firstPersonalInformationRepo.findById(id);
    }


	@Override
	public Optional<FirstPersonalInformation> getByClientCodeUcc(String clientCodeUcc) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}
	
	@Override
    public List<FirstPersonalInformation> getAllUsers() {
        return firstPersonalInformationRepo.findAll();
    }

}

