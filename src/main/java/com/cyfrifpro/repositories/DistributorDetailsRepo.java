package com.cyfrifpro.repositories;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cyfrifpro.model.distributor.DistributorDetails;

@Repository
public interface DistributorDetailsRepo extends JpaRepository<DistributorDetails, Long> {
	Optional<DistributorDetails> findByEmail(String email);
}
