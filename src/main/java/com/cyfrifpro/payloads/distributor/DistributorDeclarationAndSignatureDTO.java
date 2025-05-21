package com.cyfrifpro.payloads.distributor;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class DistributorDeclarationAndSignatureDTO {
	
	// DistributorDeclarationAndSignature fields
	
	@JsonProperty("validUpTo")
    private Date declarationValidUpto;
	
	@JsonProperty("place")
    private String declarationPlace;
	
	@JsonProperty("signature")
    private String declarationSignature;
    
}
