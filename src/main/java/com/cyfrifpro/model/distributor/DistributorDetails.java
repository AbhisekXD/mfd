package com.cyfrifpro.model.distributor;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="distributor_details")

public class DistributorDetails {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Personal/Organizational Details
    private String organizationOrIndividualName;
    private String amfiNismCertificationNumber;
    private Date certificationValidityDate;
    private String pan;
    private Date dateOfBirthOrIncorporation;
    private String contactPersonAndDesignation;
    private String email;
    private String website;
    private String status;
    private String landlineNumber;
    private String mobileNumber;
    private String catagory;
    
    @Lob
    private byte[] passportPhoto;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "bank_details_id", referencedColumnName = "id")
    private DistributorBankDetails bankDetails;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "business_details_id", referencedColumnName = "id")
    private DistributorBusinessDetails businessDetails;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "nomination_details_id", referencedColumnName = "id")
    private DistributorNominationDetails nominationDetails;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "document_checklist_id", referencedColumnName = "id")
    private DistributorDocumentChecklist documentChecklist;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "declaration_and_signature_id", referencedColumnName = "id")
    private DistributorDeclarationAndSignature declarationAndSignature;

}
