package com.cyfrifpro.services;

import java.util.List;

import com.cyfrifpro.model.distributor.DistributorDetails;
import com.cyfrifpro.payloads.distributor.DistributorDetailsDTO;

public interface DistributorDetailsService {

	 public DistributorDetailsDTO saveDistributorDetails(DistributorDetailsDTO dto);

	 public List<DistributorDetails> getDistributorDetails();

	 DistributorDetailsDTO getDistributorDetails(Long id);
	 
	 DistributorDetailsDTO getDistributorDetails(String Email);
	 
}

