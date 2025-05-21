package com.cyfrifpro.services;

import com.cyfrifpro.model.FATCA.Fatca;
import com.cyfrifpro.payloads.FatcaDTO;
import com.cyfrifpro.payloads.GetPasswordDTO;

public interface FatcaService {

    String getPassword(GetPasswordDTO getPasswordDTO);

    String createFatca(FatcaDTO fatcaDTO);
    
    public String generateParamString(FatcaDTO dto);

    public Fatca saveFatca(FatcaDTO fatcaDTO);
	
    public Fatca updateFatcaComplete(Long id, FatcaDTO fatcaDTO);
    
    public Fatca updateFatcaPartial(Long id, FatcaDTO fatcaDTO);
}
