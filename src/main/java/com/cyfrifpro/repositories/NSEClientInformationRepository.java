package com.cyfrifpro.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.cyfrifpro.model.NSE.NSEClientInformation;

public interface NSEClientInformationRepository extends JpaRepository<NSEClientInformation, String> {
    // Custom queries can go here
}
