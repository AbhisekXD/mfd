package com.cyfrifpro.payloads.distributor;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DistributorNominationDetailsDTO {

	// DistributorNominationDetails fields
	
	@JsonProperty("nomineeName")
    private String nomineeName;
	
	@JsonProperty("relation")
    private String nomineeRelationship;
	
	@JsonProperty("guardiaName")
    private String guardianName;
	
	@JsonProperty("nominee_address")
    private String nomineeAddress;
    
    @JsonProperty("nominee_dob")
    private Date nomineeDob;
    
}
