package com.cyfrifpro.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cyfrifpro.model.UCC.FirstPersonalInformation;

@Repository
public interface FirstPersonalInformationRepo extends JpaRepository<FirstPersonalInformation, Long> {
	
    Optional<FirstPersonalInformation> findById(Long id);
    
    Optional<FirstPersonalInformation> findByClientCodeUcc(String clientCodeUcc);
    
}

