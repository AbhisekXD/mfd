package com.cyfrifpro.mapper;

import com.cyfrifpro.model.distributor.DistributorDetails;
import com.cyfrifpro.payloads.distributor.DistributorDetailsDTO;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DistributorDetailsMapper {

    @Autowired
    private ModelMapper modelMapper;

    public DistributorDetails toEntity(DistributorDetailsDTO dto) {
        return modelMapper.map(dto, DistributorDetails.class);
    }

    public DistributorDetailsDTO toDTO(DistributorDetails entity) {
        return modelMapper.map(entity, DistributorDetailsDTO.class);
    }
}
