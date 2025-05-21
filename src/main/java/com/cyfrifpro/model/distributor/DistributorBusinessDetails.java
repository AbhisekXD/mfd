package com.cyfrifpro.model.distributor;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="distributor_business_details")

public class DistributorBusinessDetails {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer totalInvestorsServiced;
    private Integer numberOfEmployees;
    private Boolean operateFromOffice;
    private Double officeArea;	
    private Integer numberOfBranches;
    private Integer numberOfSubBrokers;
    private Integer experienceInYears;
    private String spreadAcross;
    private Integer numberOfFundHouses;
    private Double equityAum;
    private Double debtAum;
    private Double totalAum; 
    private Boolean interestedInAlternativeProducts;
    private Double currentAum;

    
}
