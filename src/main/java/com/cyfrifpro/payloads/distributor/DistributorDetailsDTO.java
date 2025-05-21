package com.cyfrifpro.payloads.distributor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DistributorDetailsDTO {

    // DistributorDetails fields
	
	@JsonProperty("full_name")
    private String individualName;
	
	@JsonProperty("organisation_name: ")
    private String organizationName;
	
	@JsonProperty("nism_no")
    private String amfiNismCertificationNumber;
	
	@JsonProperty("valid_upto")
    private Date certificationValidityDate;
	
	@JsonProperty("pan")
    private String pan;
	
	@JsonProperty("dob")
    private Date dateOfBirthOrIncorporation;
	
	@JsonProperty("designation")
    private String contactPersonAndDesignation;
	
	@JsonProperty("email")
    private String email;
	
	@JsonProperty("website")
    private String website;
	
	@JsonProperty("status")
    private String status;
	
	@JsonProperty("phone")
    private String landlineNumber;
	
	@JsonProperty("mobile_no")
    private String mobileNumber;
	
	@JsonProperty("categories")
    private String catagory;
	
	@JsonProperty("passportPhoto")
    private String passportPhoto;

    
    private DistributorBankDetailsDTO bankDetails;
    private DistributorBusinessDetailsDTO businessDetails;
    private DistributorNominationDetailsDTO nominationDetails;
    private DistributorDocumentChecklistDTO documentChecklist;
    private DistributorDeclarationAndSignatureDTO declarationAndSignature;
    
}
