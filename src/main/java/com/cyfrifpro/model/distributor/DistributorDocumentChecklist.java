package com.cyfrifpro.model.distributor;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="distributor_document_checklist_details")

public class DistributorDocumentChecklist {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Document checklist fields
    private boolean copyOfAmfiNismCertificate;
    private byte[] copyOfAmfiNismCertificateFile;
    
    private boolean copyOfArnLetterAndArnCard;
    private byte[] copyOfArnLetterAndArnCardFile;
    
    private boolean copyOfCancelledCheque;
    private byte[] copyOfCancelledChequeFile;
    
    private boolean copyOfPan;
    private byte[] copyOfPanFile;
    
    private boolean copyOfKydLetter;
    private byte[] copyOfKydLetterFile;
    
    private boolean certifiedMemorandumArticlesOfAssociation;
    private byte[] certifiedMemorandumArticlesOfAssociationFile;
    
    private boolean certifiedBoardResolutionOrAuthorizationLetter;
    private byte[] certifiedBoardResolutionOrAuthorizationLetterFile;
    
    private boolean certifiedListOfAuthorizedSignatories;
    private byte[] certifiedListOfAuthorizedSignatoriesFile;

}
