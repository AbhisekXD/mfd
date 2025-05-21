package com.cyfrifpro.payloads;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FirstPersonalInformationDTO {
	
    @JsonProperty("UserId")
    private String userId;

    @JsonProperty("MemberCode")
    private String memberCode;

    @JsonProperty("Password")
    private String password;

    @JsonProperty("RegnType")
    private String regnType;
    
    //main class FirstPersonalInformatio
    
    @JsonProperty("clientCode")
    private String clientCodeUcc;

    @JsonProperty("primaryHolderFirstName")
    private String primaryHolderFirstName;

    @JsonProperty("primaryHolderMiddleName")
    private String primaryHolderMiddleName;

    @JsonProperty("primaryHolderlastName")
    private String primaryHolderLastName;

    @JsonProperty("taxStatus")
    private String taxStatus;

    @JsonProperty("Gender")
    private String gender;

    @JsonProperty("primaryHolderDOB")
    private String primaryHolderDobIncorporation;

    @JsonProperty("occupationCode")
    private String occupationCode;

    @JsonProperty("holdingNature")
    private String holdingNature;

    @JsonProperty("secondholderFirstName")
    private String secondHolderFirstName;

    @JsonProperty("secondholderMiddleName")
    private String secondHolderMiddleName;

    @JsonProperty("secondholderLastName")
    private String secondHolderLastName;

    @JsonProperty("thirdholderFirstName")
    private String thirdHolderFirstName;

    @JsonProperty("thirdholderMiddleName")
    private String thirdHolderMiddleName;

    @JsonProperty("thirdholderLastName")
    private String thirdHolderLastName;

    @JsonProperty("secondHolderDOB")
    private String secondHolderDob;

    @JsonProperty("thirdHolderDOB")
    private String thirdHolderDob;

    @JsonProperty("guardianFirstName")
    private String guardianFirstName;

    @JsonProperty("guardianMiddleName")
    private String guardianMiddleName;

    @JsonProperty("GuardianLastName")
    private String guardianLastName;

    @JsonProperty("guardianDOB")
    private String guardianDob;

    @JsonProperty("primaryholderPANExempt")
    private String primaryHolderPanExempt;

    @JsonProperty("secondholderPANExempt")
    private String secondHolderPanExempt;

    @JsonProperty("thirdholderPANExempt")
    private String thirdHolderPanExempt;

    @JsonProperty("guardianPANExempt")
    private String guardianPanExempt;

    @JsonProperty("primaryholderPAN")
    private String primaryHolderPan;

    @JsonProperty("SecondholderPAN")
    private String secondHolderPan;

    @JsonProperty("thirdholderPAN")
    private String thirdHolderPan;

    @JsonProperty("guardianPAN")
    private String guardianPan;

    @JsonProperty("primaryholderExemptCategory")
    private String primaryHolderExemptCategory;

    @JsonProperty("secondholderExemptCategory")
    private String secondHolderExemptCategory;

    @JsonProperty("thirdholderExemptCategory")
    private String thirdHolderExemptCategory;

    @JsonProperty("guardianExemptCategory")
    private String guardianExemptCategory;

    @JsonProperty("clientType")
    private String clientType;
    
    private String payloadfiller1 = "";
    private String payloadfiller2 = "";

    //sub class SecondInvestmentInformation

    @JsonProperty("pms")
    private String pms;

    @JsonProperty("defaultDP")
    private String defaultDp;

    @JsonProperty("cDSLDPID")
    private String cdsldpid;

    @JsonProperty("cDSLCLTID")
    private String cdsldcltid;

    @JsonProperty("cMBPId")
    private Long cmbpId;

    @JsonProperty("nSDLDPID")
    private String nsdldpid;

    @JsonProperty("nSDLCLTID")
    private String nsdlcltid;

    
    //sub class ThirdBankAccountInformation

    @JsonProperty("accountType1")
    private String accountType1;

    @JsonProperty("accountNo1")
    private String accountNo1;

    @JsonProperty("mICRNo1")
    private String micrNo1;

    @JsonProperty("iFSCCode1")
    private String ifscCode1;

    @JsonProperty("defaultBankFlag1")
    private String defaultBankFlag1;

    @JsonProperty("accountType2")
    private String accountType2;

    @JsonProperty("accountNo2")
    private String accountNo2;

    @JsonProperty("mICRNo2")
    private String micrNo2;

    @JsonProperty("iFSCCode2")
    private String ifscCode2;

    @JsonProperty("defaultBankFlag2")
    private String defaultBankFlag2;

    @JsonProperty("AccountType3")
    private String accountType3;

    @JsonProperty("AccountNo3")
    private String accountNo3;

    @JsonProperty("MicrNo3")
    private String micrNo3;

    @JsonProperty("iFSCCode3")
    private String ifscCode3;

    @JsonProperty("defaultBankFlag3")
    private String defaultBankFlag3;

    @JsonProperty("accountType4")
    private String accountType4;

    @JsonProperty("accountNo4")
    private String accountNo4;

    @JsonProperty("mICRNo4")
    private String micrNo4;

    @JsonProperty("iFSCCode4")
    private String ifscCode4;

    @JsonProperty("defaultBankFlag4")
    private String defaultBankFlag4;

    @JsonProperty("accountType5")
    private String accountType5;

    @JsonProperty("accountNo5")
    private String accountNo5;

    @JsonProperty("mICRNo5")
    private String micrNo5;

    @JsonProperty("iFSCCode5")
    private String ifscCode5;

    @JsonProperty("defaultBankFlag5")
    private String defaultBankFlag5;
     
    //sub class FourthPaymentDividendDetails

    @JsonProperty("chequename")
    private String chequeName;

    @JsonProperty("divpaymode")
    private String divPayMode;

    //sub class FifthAddressDetails

    @JsonProperty("address1")
    private String address1;

    @JsonProperty("address2")
    private String address2;

    @JsonProperty("address3")
    private String address3;

    @JsonProperty("City")
    private String city;

    @JsonProperty("state")
    private String state;

    @JsonProperty("Pincode")
    private String pincode;

    @JsonProperty("Country")
    private String country;

    //sub class SixthContactInformation

    @JsonProperty("ResiPhone")
    private String resiPhone;

    @JsonProperty("ResiFax")
    private String resiFax;

    @JsonProperty("officePhone")
    private String officePhone;

    @JsonProperty("officeFax")
    private String officeFax;

    @JsonProperty("Email")
    private String email;

    @JsonProperty("communicationMode")
    private String communicationMode;

    //sub class SeventhForeignAddressDetails

    @JsonProperty("foreignAddress1")
    private String foreignAddress1;

    @JsonProperty("foreignAddress2")
    private String foreignAddress2;

    @JsonProperty("foreignAddress3")
    private String foreignAddress3;

    @JsonProperty("foreignAddressCity")
    private String foreignAddressCity;

    @JsonProperty("foreignAddressPincode")
    private String foreignAddressPincode;

    @JsonProperty("foreignAddressState")
    private String foreignAddressState;

    @JsonProperty("foreignAddressCountry")
    private String foreignAddressCountry;

    @JsonProperty("foreignAddressResiPhone")
    private String foreignAddressResiPhone;

    @JsonProperty("foreignAddressFax")
    private String foreignAddressFax;

    @JsonProperty("ForeignAddressOffPhone")
    private String foreignAddressOffPhone;

    @JsonProperty("ForeignAddressOffFax")
    private String foreignAddressOffFax;

    @JsonProperty("indianMobileNo")
    private String indianMobileNo;

    //sub class EighthNomineeInformation

    @JsonProperty("nominee1Name")
    private String nominee1Name;

    @JsonProperty("nominee1Relationship")
    private String nominee1Relationship;

    @JsonProperty("nominee1ApplicablePes")
    private Integer nominee1ApplicablePercent;

    @JsonProperty("nominee1MinorFlag")
    private String nominee1MinorFlag;

    @JsonProperty("nominee1DOB")
    private String nominee1Dob;

    @JsonProperty("nominee1Guardian")
    private String nominee1Guardian;

    @JsonProperty("Nominee2Name")
    private String nominee2Name;

    @JsonProperty("nominee2Relationship")
    private String nominee2Relationship;

    @JsonProperty("nominee2ApplicablePes")
    private Integer nominee2ApplicablePercent;

    @JsonProperty("nominee2DOB")
    private String nominee2Dob;

    @JsonProperty("nominee2MinorFlag")
    private String nominee2MinorFlag;

    @JsonProperty("nominee2Guardian")
    private String nominee2Guardian;

    @JsonProperty("nominee3Name")
    private String nominee3Name;

    @JsonProperty("nominee3Relationship")
    private String nominee3Relationship;

    @JsonProperty("nominee3ApplicablePes")
    private Integer nominee3ApplicablePercent;

    @JsonProperty("nominee3DOB")
    private String nominee3Dob;

    @JsonProperty("nominee3MinorFlag")
    private String nominee3MinorFlag;

    @JsonProperty("nominee3Guardian")
    private String nominee3Guardian;

    //sub class NinethKycRegulatoryInformation

    @JsonProperty("primaryholderKYCType")
    private String primaryHolderKycType;

    @JsonProperty("primaryholderCKYCNumber")
    private Long primaryHolderCkycNumber;

    @JsonProperty("secondholderKYCType")
    private String secondHolderKycType;

    @JsonProperty("secondholderCKYCNumber")
    private Long secondHolderCkycNumber;

    @JsonProperty("thirdholderKYCType")
    private String thirdHolderKycType;

    @JsonProperty("thirderCKYCNumber")
    private Long thirdHolderCkycNumber;

    @JsonProperty("guardianKYCType")
    private String guardianKycType;

    @JsonProperty("guardianCKYCNumber")
    private Long guardianCkycNumber;

    //sub class TenthKraAadhaarDetails

    @JsonProperty("primaryholderKRAExemptRefNo")
    private String primaryHolderKraExemptRefNo;

    @JsonProperty("secondholderKRAExemptRefNo")
    private String secondHolderKraExemptRefNo;

    @JsonProperty("thirdholderKRAExemptRefNo")
    private String thirdHolderKraExemptRefNo;

    @JsonProperty("guardianExemptRefNo")
    private String guardianExemptRefNo;

    @JsonProperty("aadhaarUpdated")
    private String aadhaarUpdated;

    //sub class ElleventhOtherIdentifiers

    @JsonProperty("mapinId")
    private String mapinId;

    @JsonProperty("Paperlessflag")
    private String paperlessFlag;

    @JsonProperty("lEINo")
    private String leiNo;

    @JsonProperty("lEIValidity")
    private String leiValidity;

    //sub class TwelethDeclarations

    @JsonProperty("Filler1MobileDeclarationFlag")
    private String filler1MobileDeclarationFlag;

    @JsonProperty("Filler2EmailDeclarationFlag")
    private String filler2EmailDeclarationFlag;

    //sub class ThirteenthNominationAuthorization

    @JsonProperty("nominationOpt")
    private String nominationOpt;

    @JsonProperty("nominationAuthMode")
    private String nominationAuthMode;

    @JsonProperty("nomineePAN1")
    private String nomineePan1;

    @JsonProperty("nomineeGuardianPAN1")
    private String nomineeGuardianPan1;

    @JsonProperty("nomineePAN2")
    private String nomineePan2;

    @JsonProperty("nomineeGuardianPAN2")
    private String nomineeGuardianPan2;

    @JsonProperty("nomineePAN3")
    private String nomineePan3;

    @JsonProperty("nomineeGuardianPAN3")
    private String nomineeGuardianPan3;

    //sub class FourteenthHoldersContactDetails

    @JsonProperty("secondholderEmail")
    private String secondHolderEmail;

    @JsonProperty("secondholderEmailDeclaration")
    private String secondHolderEmailDeclaration;

    @JsonProperty("secondholderMobileNo")	
    private String secondHolderMobileNo;

    @JsonProperty("secondholderMobileDeclaration")
    private String secondHolderMobileNoDeclaration;

    @JsonProperty("thirdholderEmail")
    private String thirdHolderEmail;

    @JsonProperty("thirdholderEmailDeclaration")
    private String thirdHolderEmailDeclaration;

    @JsonProperty("thirdholderMobileNo")
    private String thirdHolderMobileNo;

    @JsonProperty("thirdholderMobileDeclaration")
    private String thirdHolderMobileNoDeclaration;

    //sub class FifteenthGuardianInformation

    @JsonProperty("guardianRelationship")
    private String guardianRelationship;

    //sub class SixteenthMiscellaneous

    @JsonProperty("Filler1")
    private String filler1;

    @JsonProperty("Filler2")
    private String filler2;

    @JsonProperty("Filler3")
    private String filler3;
}
