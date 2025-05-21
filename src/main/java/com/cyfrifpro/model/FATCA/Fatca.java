package com.cyfrifpro.model.FATCA;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "Fatca")
public class Fatca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;  // Primary key

    @Column(name = "PAN_RP")
    private String panRp;  // PAN of the Reporting Person (Mandatory)

    @Column(name = "PEKRN")
    private String pekrn;  // PAN Exempt KYC Ref No. of the Investor/Guardian

    @Column(name = "INV_NAME")
    private String invName;  // Name of the Investor / Guardian

    @Column(name = "DOB")
    private String dob;  // Date of Birth

    @Column(name = "FR_NAME")
    private String frName;  // Father's Name (if PAN not provided)

    @Column(name = "SP_NAME")
    private String spName;  // Spouse Name (if PAN not provided)

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tax_status_id", referencedColumnName = "ID")
    private SecondTaxInfo taxInfo;  // Tax-related information

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "wealth_info_id", referencedColumnName = "ID")
    private ThirdWealthInfo wealthInfo;  // Wealth-related information
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "political_exposed_id", referencedColumnName = "ID")
    private FourthPoliticalExposed pepFlag;  //  Politically Exposed Person (PEP)
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "occupation_details_id", referencedColumnName = "ID")
    private FifthOccupationDetails occupationDetails;  // Occupation-related information
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "non_individual_details_id", referencedColumnName = "ID")
    private SixthNonIndividualDetails nonIndividualDetails;  // Non-Individual related information
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sponsoring_entity_details_id", referencedColumnName = "ID")
    private SeventhSponsoringEntityDetails sponsoringEntityDetails;  // Sponsoring Entity related information

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "nffe_classification_id", referencedColumnName = "ID")
    private EightNffeClassification nffeClassification;  // NFFE Classification related information
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "stock_exchange_info_id", referencedColumnName = "ID")
    private NinethStockExchangeInfo stockExchangeInfo;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ultimate_beneficial_ownership_id", referencedColumnName = "ID")
    private TenthUltimateBeneficialOwnership ultimateBeneficialOwnership;  // UBO related information
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "additional_flags_and_identifiers_id", referencedColumnName = "ID")
    private ElleventhAdditionalFlagsAndIdentifiers additionalFlagsAndIdentifiers;  // Additional Flags and Identifiers
    
}
