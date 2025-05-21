package com.cyfrifpro.model.UCC;

import java.time.LocalDate;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "client_personal_information")
public class FirstPersonalInformation {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column
    private String userId;
    @Column
    private String memberCode;
    @Column
    private String regnType;

    @Column
    private String clientCodeUcc;
    @Column
    private String primaryHolderFirstName;
    @Column
    private String primaryHolderMiddleName;
    @Column
    private String primaryHolderLastName;
    @Column
    private String taxStatus;
    @Column
    private String gender;

    @Column
    private String primaryHolderDobIncorporation;

    @Column
    private String occupationCode;
    @Column
    private String holdingNature;
    @Column
    private String secondHolderFirstName;
    @Column
    private String secondHolderMiddleName;
    @Column
    private String secondHolderLastName;
    @Column
    private String thirdHolderFirstName;
    @Column
    private String thirdHolderMiddleName;
    @Column
    private String thirdHolderLastName;

    @Column
    private String secondHolderDob;

    @Column
    private String thirdHolderDob;

    @Column
    private String guardianFirstName;
    @Column
    private String guardianMiddleName;
    @Column
    private String guardianLastName;

    @Column
    private String guardianDob;

    @Column
    private String primaryHolderPanExempt;
    @Column
    private String secondHolderPanExempt;
    @Column
    private String thirdHolderPanExempt;
    @Column
    private String guardianPanExempt;

    @Column
    private String primaryHolderPan;
    @Column
    private String secondHolderPan;
    @Column
    private String thirdHolderPan;
    @Column
    private String guardianPan;

    @Column
    private String primaryHolderExemptCategory;
    @Column
    private String secondHolderExemptCategory;
    @Column
    private String thirdHolderExemptCategory;
    @Column
    private String guardianExemptCategory;

    @Column
    private String clientType;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "investment_informations_id", referencedColumnName = "id")
    private SecondInvestmentInformation investmentInformations;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bank_account_informations_id", referencedColumnName = "id")
    private ThirdBankAccountInformation bankAccountInformations;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "payment_dividend_details_id", referencedColumnName = "id")
    private FourthPaymentDividendDetails paymentDividendDetails;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_details_id", referencedColumnName = "id")
    private FifthAddressDetails addressDetails;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contact_informations_id", referencedColumnName = "id")
    private SixthContactInformation contactInformations;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "foreign_address_details_id", referencedColumnName = "id")
    private SeventhForeignAddressDetails foreignAddressDetails;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "nominee_informations_id", referencedColumnName = "id")
    private EighthNomineeInformation nomineeInformations;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "kyc_regulatory_informations_id", referencedColumnName = "id")
    private NinethKycRegulatoryInformation kycRegulatoryInformations;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "kra_aadhaar_details_id", referencedColumnName = "id")
    private TenthKraAadhaarDetails kraAadhaarDetails;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "other_identifiers_id", referencedColumnName = "id")
    private ElleventhOtherIdentifiers otherIdentifiers;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "declarations_id", referencedColumnName = "id")
    private TwelethDeclarations declarations;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "nomination_authorizations_id", referencedColumnName = "id")
    private ThirteenthNominationAuthorization nominationAuthorizations;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "holders_contact_details_id", referencedColumnName = "id")
    private FourteenthHoldersContactDetails holdersContactDetails;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "guardian_informations_id", referencedColumnName = "id")
    private FifteenthGuardianInformation guardianInformations;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "miscellaneous_id", referencedColumnName = "id")
    private SixteenthMiscellaneous miscellaneous;

    @Column
    private String payloadfiller1;

    @Column
    private String payloadfiller2;
    
    @Column
    private LocalDate createdTime;

    @PrePersist
    protected void onCreate() {
        // Sets the 'createdAt' field to the current date when the entity is first created.
        this.createdTime = LocalDate.now();
    }
    
}
