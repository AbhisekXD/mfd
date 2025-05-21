package com.cyfrifpro.payloads.distributor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DistributorDocumentChecklistDTO {

	// Document checklist fields
	private boolean copyOfAmfiNismCertificate;
    private String copyOfAmfiNismCertificateFile;
    
    private boolean copyOfArnLetterAndArnCard;
    private String copyOfArnLetterAndArnCardFile;
    
    private boolean copyOfCancelledCheque;
    private String copyOfCancelledChequeFile;
    
    private boolean copyOfPan;
    private String copyOfPanFile;
    
    private boolean copyOfKydLetter;
    private String copyOfKydLetterFile;
    
    private boolean certifiedMemorandumArticlesOfAssociation;
    private String certifiedMemorandumArticlesOfAssociationFile;
    
    private boolean certifiedBoardResolutionOrAuthorizationLetter;
    private String certifiedBoardResolutionOrAuthorizationLetterFile;
    
    private boolean certifiedListOfAuthorizedSignatories;
    private String certifiedListOfAuthorizedSignatoriesFile;
}
