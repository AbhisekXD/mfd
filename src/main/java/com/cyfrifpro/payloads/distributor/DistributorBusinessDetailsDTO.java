package com.cyfrifpro.payloads.distributor;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DistributorBusinessDetailsDTO {

	@JsonProperty("investorsServiced")
	private Integer totalInvestorsServiced;

	@JsonProperty("employees")
	private Integer numberOfEmployees;

	@JsonProperty("operateFromOffice")
	private Boolean operateFromOffice;

	@JsonProperty("officeArea")
	private Double officeArea;

	@JsonProperty("branches")
	private Integer numberOfBranches;

	@JsonProperty("subBrokers")
	private Integer numberOfSubBrokers;

	@JsonProperty("experienceYears")
	private Integer experienceInYears;

	@JsonProperty("branchesSpread")
	private String spreadAcross;

	@JsonProperty("fundHousesEmpanelled")
	private Integer numberOfFundHouses;

	@JsonProperty("equityAUM")
	private Double equityAum;

	@JsonProperty("debtAUM")
	private Double debtAum;

	@JsonProperty("totalAUM")
	private Double totalAum;

	@JsonProperty("alternativeInvestment")
	private Boolean interestedInAlternativeProducts;

	@JsonProperty("currentAUM")
	private Double currentAum;

}
