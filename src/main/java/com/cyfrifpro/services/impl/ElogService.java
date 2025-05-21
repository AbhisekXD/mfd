package com.cyfrifpro.services.impl;

import com.cyfrifpro.fiegn.ElogFeignClient;
import com.cyfrifpro.payloads.ElogRequestDTO;
import com.cyfrifpro.payloads.ElogResponseDTO;

import org.springframework.stereotype.Service;

@Service
public class ElogService {

    private final ElogFeignClient elogFeignClient;

    public ElogService(ElogFeignClient elogFeignClient) {
        this.elogFeignClient = elogFeignClient;
    }

    public ElogResponseDTO sendElogRequest(ElogRequestDTO requestDTO) {
        return elogFeignClient.sendElogRequest(requestDTO);
    }
}