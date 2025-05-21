package com.cyfrifpro.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cyfrifpro.mapper.DistributorDetailsMapper;
import com.cyfrifpro.model.distributor.DistributorDetails;
import com.cyfrifpro.payloads.distributor.DistributorDetailsDTO;
import com.cyfrifpro.repositories.DistributorDetailsRepo;
import com.cyfrifpro.services.DistributorDetailsService;


@Service
public class DistributorDetailsServiceImpl implements DistributorDetailsService {
	
    @Autowired
    private DistributorDetailsRepo distributorDetailsRepo;

    @Autowired
    private DistributorDetailsMapper mapper;

    @Override
    public DistributorDetailsDTO getDistributorDetails(Long id) {
        Optional<DistributorDetails> entity = distributorDetailsRepo.findById(id);
        return entity.map(mapper::toDTO).orElse(null);
    }
    
    @Override
    public DistributorDetailsDTO getDistributorDetails(String email) {
        Optional<DistributorDetails> entity = distributorDetailsRepo.findByEmail(email);
        return entity.map(mapper::toDTO).orElse(null);
    }

    @Override
    public DistributorDetailsDTO saveDistributorDetails(DistributorDetailsDTO dto) {
        DistributorDetails entity = mapper.toEntity(dto);
        DistributorDetails savedEntity = distributorDetailsRepo.save(entity);
        return mapper.toDTO(savedEntity);
    }

	@Override
	public List<DistributorDetails> getDistributorDetails() {
		return distributorDetailsRepo.findAll();
	}
}
