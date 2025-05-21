package com.cyfrifpro.restcontrollers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cyfrifpro.payloads.ElogRequestDTO;
import com.cyfrifpro.payloads.ElogResponseDTO;
import com.cyfrifpro.services.impl.ElogService;

@RestController
@RequestMapping("/api/elog")
public class ElogController {

    private final ElogService elogService;

    public ElogController(ElogService elogService) {
        this.elogService = elogService;
    }

    @PostMapping("/register")
    public ResponseEntity<ElogResponseDTO> registerElog(@RequestBody ElogRequestDTO requestDTO) {
        ElogResponseDTO response = elogService.sendElogRequest(requestDTO);
        return ResponseEntity.ok(response);
    }
}