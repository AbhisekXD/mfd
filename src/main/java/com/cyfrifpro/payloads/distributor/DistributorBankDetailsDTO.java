package com.cyfrifpro.payloads.distributor;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DistributorBankDetailsDTO {

	// DistributorBankDetails fields
	@JsonProperty("bank_name")
    private String bankName;
	
	@JsonProperty("branch_name")
    private String branch;
	
	@JsonProperty("bank_address")
    private String branchAddress;
	
	@JsonProperty("account_type")
    private String accountType;
	
	@JsonProperty("bank_ac_no")
    private String accountNumber;
	
	@JsonProperty("ifscCode")
    private String ifscCode;
	
	@JsonProperty("micrCode")
    private String micrCode;
	
	@JsonProperty("city")
    private String city;
	
	@JsonProperty("state")
    private String state;
	
	@JsonProperty("pincode")
    private String pinCode;
}
