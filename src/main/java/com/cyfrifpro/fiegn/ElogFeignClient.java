package com.cyfrifpro.fiegn;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cyfrifpro.payloads.ElogRequestDTO;
import com.cyfrifpro.payloads.ElogResponseDTO;

@FeignClient(name = "elogClient", url = "${elog.api.url}")
public interface ElogFeignClient {
	@PostMapping(consumes = "application/json", produces = "application/json")
    ElogResponseDTO sendElogRequest(@RequestBody ElogRequestDTO requestDTO);
}