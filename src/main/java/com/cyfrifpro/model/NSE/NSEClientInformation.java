package com.cyfrifpro.model.NSE;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "NSE_client_information")
public class NSEClientInformation {

    @Id
    @Column(name = "client_code", length = 10)
    @JsonProperty("client_code")
    private String clientCode;

    @Column(name = "primary_holder_first_name", length = 70, nullable = false)
    @JsonProperty("primary_holder_first_name")
    private String primaryHolderFirstName;

    @Column(name = "primary_holder_middle_name", length = 70, nullable = false)
    @JsonProperty("primary_holder_middle_name")
    private String primaryHolderMiddleName;

    @Column(name = "primary_holder_last_name", length = 70, nullable = false)
    @JsonProperty("primary_holder_last_name")
    private String primaryHolderLastName;

    @Column(name = "tax_status", length = 2, nullable = false)
    @JsonProperty("tax_status")
    private String taxStatus;

    @Column(name = "gender", length = 1, nullable = false)
    @JsonProperty("gender")
    private String gender; // M/F/O/T

    // Map "primary_holder_dob_incorporation" from JSON to primaryHolderDob in the entity
    @Column(name = "primary_holder_dob", nullable = false)
    @JsonProperty("primary_holder_dob_incorporation")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date primaryHolderDob;

    @Column(name = "occupation_code", length = 2, nullable = false)
    @JsonProperty("occupation_code")
    private String occupationCode;

    @Column(name = "holding_nature", length = 2, nullable = false)
    @JsonProperty("holding_nature")
    private String holdingNature;

    @Column(name = "second_holder_first_name", length = 70)
    @JsonProperty("second_holder_first_name")
    private String secondHolderFirstName;

    @Column(name = "second_holder_middle_name", length = 70)
    @JsonProperty("second_holder_middle_name")
    private String secondHolderMiddleName;

    @Column(name = "second_holder_last_name", length = 70)
    @JsonProperty("second_holder_last_name")
    private String secondHolderLastName;

    @Column(name = "third_holder_first_name", length = 70)
    @JsonProperty("third_holder_first_name")
    private String thirdHolderFirstName;

    @Column(name = "third_holder_middle_name", length = 70)
    @JsonProperty("third_holder_middle_name")
    private String thirdHolderMiddleName;

    @Column(name = "third_holder_last_name", length = 70)
    @JsonProperty("third_holder_last_name")
    private String thirdHolderLastName;

    @Column(name = "second_holder_dob")
    @JsonProperty("second_holder_dob")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date secondHolderDob;

    @Column(name = "third_holder_dob")
    @JsonProperty("third_holder_dob")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date thirdHolderDob;
    
    @Column(name = "guardian_first_name", length = 120)
    @JsonProperty("guardian_first_name")
    private String guardianFirstName;

    @Column(name = "guardian_middle_name", length = 120)
    @JsonProperty("guardian_middle_name")
    private String guardianMiddleName;

    @Column(name = "guardian_last_name", length = 120)
    @JsonProperty("guardian_last_name")
    private String guardianLastName;

    @Column(name = "guardian_dob")
    @JsonProperty("guardian_dob")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date guardianDob;

    @Column(name = "primary_holder_pan_exempt", length = 1, nullable = false)
    @JsonProperty("primary_holder_pan_exempt")
    private String primaryHolderPanExempt; // 'Y' or 'N'

    @Column(name = "second_holder_pan_exempt", length = 1, nullable = false)
    @JsonProperty("second_holder_pan_exempt")
    private String secondHolderPanExempt; // 'Y' or 'N'

    @Column(name = "third_holder_pan_exempt", length = 1, nullable = false)
    @JsonProperty("third_holder_pan_exempt")
    private String thirdHolderPanExempt; // 'Y' or 'N'

    @Column(name = "guardian_pan_exempt", length = 1, nullable = false)
    @JsonProperty("guardian_pan_exempt")
    private String guardianPanExempt; // 'Y' or 'N'

    @Column(name = "primary_holder_pan", length = 10)
    @JsonProperty("primary_holder_pan")
    private String primaryHolderPan;

    @Column(name = "second_holder_pan", length = 10)
    @JsonProperty("second_holder_pan")
    private String secondHolderPan;

    @Column(name = "third_holder_pan", length = 10)
    @JsonProperty("third_holder_pan")
    private String thirdHolderPan;

    @Column(name = "guardian_pan", length = 10)
    @JsonProperty("guardian_pan")
    private String guardianPan;

    @Column(name = "primary_holder_exempt_category", length = 2)
    @JsonProperty("primary_holder_exempt_category")
    private String primaryHolderExemptCategory;

    @Column(name = "second_holder_exempt_category", length = 2)
    @JsonProperty("second_holder_exempt_category")
    private String secondHolderExemptCategory;

    @Column(name = "third_holder_exempt_category", length = 2)
    @JsonProperty("third_holder_exempt_category")
    private String thirdHolderExemptCategory;

    @Column(name = "guardian_exempt_category", length = 2)
    @JsonProperty("guardian_exempt_category")
    private String guardianExemptCategory;

    @Column(name = "client_type", length = 1, nullable = false)
    @JsonProperty("client_type")
    private String clientType; // D/P

    @Column(name = "pms", length = 1)
    @JsonProperty("pms")
    private String pms;

    @Column(name = "default_dp", length = 4)
    @JsonProperty("default_dp")
    private String defaultDp;

    @Column(name = "cdsl_dpid", length = 8)
    @JsonProperty("cdsl_dpid")
    private String cdslDpid;

    @Column(name = "cdslcltid", length = 16)
    @JsonProperty("cdslcltid")
    private String cdslcltid;

    @Column(name = "cmbp_id", length = 16)
    @JsonProperty("cmbp_id")
    private String cmbpId;

    @Column(name = "nsdldpid", length = 8)
    @JsonProperty("nsdldpid")
    private String nsdldpid;

    @Column(name = "nsdlcltid", length = 8)
    @JsonProperty("nsdlcltid")
    private String nsdlcltid;

    @Column(name = "account_type_1", length = 2)
    @JsonProperty("account_type_1")
    private String accountType1;

    @Column(name = "account_no_1", length = 40, nullable = false)
    @JsonProperty("account_no_1")
    private String accountNo1;

    @Column(name = "micr_no_1", length = 9)
    @JsonProperty("micr_no_1")
    private String micrNo1;

    @Column(name = "ifsc_code_1", length = 11, nullable = false)
    @JsonProperty("ifsc_code_1")
    private String ifscCode1;

    @Column(name = "default_bank_flag_1", length = 1, nullable = false)
    @JsonProperty("default_bank_flag_1")
    private String defaultBankFlag1; // Y/N

    @Column(name = "account_type_2", length = 2)
    @JsonProperty("account_type_2")
    private String accountType2;

    @Column(name = "account_no_2", length = 40)
    @JsonProperty("account_no_2")
    private String accountNo2;

    @Column(name = "micr_no_2", length = 9)
    @JsonProperty("micr_no_2")
    private String micrNo2;

    @Column(name = "ifsc_code_2", length = 11)
    @JsonProperty("ifsc_code_2")
    private String ifscCode2;

    @Column(name = "default_bank_flag_2", length = 1)
    @JsonProperty("default_bank_flag_2")
    private String defaultBankFlag2;

    @Column(name = "account_type_3", length = 2)
    @JsonProperty("account_type_3")
    private String accountType3;

    @Column(name = "account_no_3", length = 40)
    @JsonProperty("account_no_3")
    private String accountNo3;

    @Column(name = "micr_no_3", length = 9)
    @JsonProperty("micr_no_3")
    private String micrNo3;

    @Column(name = "ifsc_code_3", length = 11)
    @JsonProperty("ifsc_code_3")
    private String ifscCode3;

    @Column(name = "default_bank_flag_3", length = 1)
    @JsonProperty("default_bank_flag_3")
    private String defaultBankFlag3;

    @Column(name = "account_type_4", length = 2)
    @JsonProperty("account_type_4")
    private String accountType4;

    @Column(name = "account_no_4", length = 40)
    @JsonProperty("account_no_4")
    private String accountNo4;

    @Column(name = "micr_no_4", length = 9)
    @JsonProperty("micr_no_4")
    private String micrNo4;

    @Column(name = "ifsc_code_4", length = 11)
    @JsonProperty("ifsc_code_4")
    private String ifscCode4;

    @Column(name = "default_bank_flag_4", length = 1)
    @JsonProperty("default_bank_flag_4")
    private String defaultBankFlag4;

    @Column(name = "account_type_5", length = 2)
    @JsonProperty("account_type_5")
    private String accountType5;

    @Column(name = "account_no_5", length = 40)
    @JsonProperty("account_no_5")
    private String accountNo5;

    @Column(name = "micr_no_5", length = 9)
    @JsonProperty("micr_no_5")
    private String micrNo5;

    @Column(name = "ifsc_code_5", length = 11)
    @JsonProperty("ifsc_code_5")
    private String ifscCode5;

    @Column(name = "default_bank_flag_5", length = 1)
    @JsonProperty("default_bank_flag_5")
    private String defaultBankFlag5;

    @Column(name = "cheque_name", length = 35)
    @JsonProperty("cheque_name")
    private String chequeName;

    @Column(name = "div_pay_mode", length = 2, nullable = false)
    @JsonProperty("div_pay_mode")
    private String divPayMode; // 01=Cheque, 02=Direct Credit, etc.

    @Column(name = "address_1", length = 40, nullable = false)
    @JsonProperty("address_1")
    private String address1;

    @Column(name = "address_2", length = 40)
    @JsonProperty("address_2")
    private String address2;

    @Column(name = "address_3", length = 40)
    @JsonProperty("address_3")
    private String address3;

    @Column(name = "city", length = 35, nullable = false)
    @JsonProperty("city")
    private String city;

    @Column(name = "state", length = 2, nullable = false)
    @JsonProperty("state")
    private String state;

    @Column(name = "pincode")
    @JsonProperty("pincode")
    private Integer pincode;

    @Column(name = "country", length = 35, nullable = false)
    @JsonProperty("country")
    private String country;

    @Column(name = "resi_phone", length = 15)
    @JsonProperty("resi_phone")
    private String resiPhone;

    @Column(name = "resi_fax", length = 15)
    @JsonProperty("resi_fax")
    private String resiFax;

    @Column(name = "office_phone", length = 15)
    @JsonProperty("office_phone")
    private String officePhone;

    @Column(name = "office_fax", length = 15)
    @JsonProperty("office_fax")
    private String officeFax;

    @Column(name = "email", length = 50, nullable = false)
    @JsonProperty("email")
    private String email;

    @Column(name = "communication_mode", length = 1, nullable = false)
    @JsonProperty("communication_mode")
    private String communicationMode; // P/E/M

    @Column(name = "foreign_address_1", length = 40)
    @JsonProperty("foreign_address_1")
    private String foreignAddress1;

    @Column(name = "foreign_address_2", length = 40)
    @JsonProperty("foreign_address_2")
    private String foreignAddress2;

    @Column(name = "foreign_address_3", length = 40)
    @JsonProperty("foreign_address_3")
    private String foreignAddress3;

    @Column(name = "foreign_address_city", length = 35)
    @JsonProperty("foreign_address_city")
    private String foreignAddressCity;

    @Column(name = "foreign_address_pincode", length = 10)
    @JsonProperty("foreign_address_pincode")
    private String foreignAddressPincode;

    @Column(name = "foreign_address_state", length = 35)
    @JsonProperty("foreign_address_state")
    private String foreignAddressState;

    @Column(name = "foreign_address_country", length = 3, nullable = false)
    @JsonProperty("foreign_address_country")
    private String foreignAddressCountry;

    @Column(name = "foreign_address_resi_phone", length = 15)
    @JsonProperty("foreign_address_resi_phone")
    private String foreignAddressResiPhone;

    @Column(name = "foreign_address_fax", length = 15)
    @JsonProperty("foreign_address_fax")
    private String foreignAddressFax;

    @Column(name = "foreign_address_off_phone", length = 15)
    @JsonProperty("foreign_address_off_phone")
    private String foreignAddressOffPhone;

    @Column(name = "foreign_address_off_fax", length = 15)
    @JsonProperty("foreign_address_off_fax")
    private String foreignAddressOffFax;

    @Column(name = "indian_mobile_no", length = 10)
    @JsonProperty("indian_mobile_no")
    private String indianMobileNo;

    @Column(name = "nominee_1_name", length = 40)
    @JsonProperty("nominee_1_name")
    private String nominee1Name;

    @Column(name = "nominee_1_relationship", length = 40)
    @JsonProperty("nominee_1_relationship")
    private String nominee1Relationship;

    @Column(name = "nominee_1_applicable")
    @JsonProperty("nominee_1_applicable")
    private BigDecimal nominee1Applicable;

    @Column(name = "nominee_1_minor_flag", length = 1)
    @JsonProperty("nominee_1_minor_flag")
    private String nominee1MinorFlag;

    @Column(name = "nominee_1_dob")
    @JsonProperty("nominee_1_dob")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date nominee1Dob;
    
    @Column(name = "nominee_1_guardian", length = 35)
    @JsonProperty("nominee_1_guardian")
    private String nominee1Guardian;

    @Column(name = "nominee_2_name", length = 40)
    @JsonProperty("nominee_2_name")
    private String nominee2Name;

    @Column(name = "nominee_2_relationship", length = 40)
    @JsonProperty("nominee_2_relationship")
    private String nominee2Relationship;

    @Column(name = "nominee_2_applicable")
    @JsonProperty("nominee_2_applicable")
    private Double nominee2Applicable;

    @Column(name = "nominee_2_dob")
    @Temporal(TemporalType.DATE)
    @JsonProperty("nominee_2_dob")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date nominee2Dob;

    @Column(name = "nominee_2_minor_flag", length = 1)
    @JsonProperty("nominee_2_minor_flag")
    private String nominee2MinorFlag;

    @Column(name = "nominee_2_guardian", length = 35)
    @JsonProperty("nominee_2_guardian")
    private String nominee2Guardian;

    @Column(name = "nominee_3_name", length = 40)
    @JsonProperty("nominee_3_name")
    private String nominee3Name;

    @Column(name = "nominee_3_relationship", length = 40)
    @JsonProperty("nominee_3_relationship")
    private String nominee3Relationship;

    @Column(name = "nominee_3_applicable")
    @JsonProperty("nominee_3_applicable")
    private Double nominee3Applicable;

    @Column(name = "nominee_3_dob")
    @Temporal(TemporalType.DATE)
    @JsonProperty("nominee_3_dob")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date nominee3Dob;

    @Column(name = "nominee_3_minor_flag", length = 1)
    @JsonProperty("nominee_3_minor_flag")
    private String nominee3MinorFlag;

    @Column(name = "nominee_3_guardian", length = 35)
    @JsonProperty("nominee_3_guardian")
    private String nominee3Guardian;

    @Column(name = "primary_holder_kyc_type", length = 1, nullable = false)
    @JsonProperty("primary_holder_kyc_type")
    private String primaryHolderKycType;

    @Column(name = "primary_holder_ckyc_number", length = 14)
    @JsonProperty("primary_holder_ckyc_number")
    private String primaryHolderCkycNumber;

    @Column(name = "second_holder_kyc_type", length = 1)
    @JsonProperty("second_holder_kyc_type")
    private String secondHolderKycType;

    @Column(name = "second_holder_ckyc_number", length = 14)
    @JsonProperty("second_holder_ckyc_number")
    private String secondHolderCkycNumber;

    @Column(name = "third_holder_kyc_type", length = 1)
    @JsonProperty("third_holder_kyc_type")
    private String thirdHolderKycType;

    @Column(name = "third_holder_ckyc_number", length = 14)
    @JsonProperty("third_holder_ckyc_number")
    private String thirdHolderCkycNumber;

    @Column(name = "guardian_kyc_type", length = 1)
    @JsonProperty("guardian_kyc_type")
    private String guardianKycType;

    @Column(name = "guardian_ckyc_number", length = 14)
    @JsonProperty("guardian_ckyc_number")
    private String guardianCkycNumber;

    @Column(name = "primary_holder_kra_exempt_ref_no", length = 10)
    @JsonProperty("primary_holder_kra_exempt_ref_no")
    private String primaryHolderKraExemptRefNo;

    @Column(name = "second_holder_kra_exempt_ref_no", length = 10)
    @JsonProperty("second_holder_kra_exempt_ref_no")
    private String secondHolderKraExemptRefNo;

    @Column(name = "third_holder_kra_exempt_ref_no", length = 10)
    @JsonProperty("third_holder_kra_exempt_ref_no")
    private String thirdHolderKraExemptRefNo;

    @Column(name = "guardian_exempt_ref_no", length = 10)
    @JsonProperty("guardian_exempt_ref_no")
    private String guardianExemptRefNo;

    @Column(name = "aadhaar_updated", length = 1)
    @JsonProperty("aadhaar_updated")
    private String aadhaarUpdated;

    @Column(name = "mapin_id", length = 16)
    @JsonProperty("mapin_id")
    private String mapinId;

    @Column(name = "paperless_flag", length = 1, nullable = false)
    @JsonProperty("paperless_flag")
    private String paperlessFlag;

    @Column(name = "lei_no", length = 20)
    @JsonProperty("lei_no")
    private String leiNo;

    @Column(name = "lei_validity")
    @Temporal(TemporalType.DATE)
    @JsonProperty("lei_validity")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date leiValidity;

    @Column(name = "mobile_declaration_flag", length = 2)
    @JsonProperty("mobile_declaration_flag")
    private String mobileDeclarationFlag;

    @Column(name = "email_declaration_flag", length = 2)
    @JsonProperty("email_declaration_flag")
    private String emailDeclarationFlag;

    @Column(name = "nomination_opt", length = 1)
    @JsonProperty("nomination_opt")
    private String nominationOpt;

    @Column(name = "nomination_authentication", length = 1)
    @JsonProperty("nomination_authentication")
    private String nominationAuthentication;

    @Column(name = "nominee_1_pan", length = 10)
    @JsonProperty("nominee_1_pan")
    private String nominee1Pan;

    @Column(name = "nominee_1_guardian_pan", length = 10)
    @JsonProperty("nominee_1_guardian_pan")
    private String nominee1GuardianPan;

    @Column(name = "nominee_2_pan", length = 10)
    @JsonProperty("nominee_2_pan")
    private String nominee2Pan;

    @Column(name = "nominee_2_guardian_pan", length = 10)
    @JsonProperty("nominee_2_guardian_pan")
    private String nominee2GuardianPan;

    @Column(name = "nominee_3_pan", length = 10)
    @JsonProperty("nominee_3_pan")
    private String nominee3Pan;

    @Column(name = "nominee_3_guardian_pan", length = 10)
    @JsonProperty("nominee_3_guardian_pan")
    private String nominee3GuardianPan;

    @Column(name = "second_holder_email", length = 50)
    @JsonProperty("second_holder_email")
    private String secondHolderEmail;

    @Column(name = "second_holder_email_declaration", length = 2)
    @JsonProperty("second_holder_email_declaration")
    private String secondHolderEmailDeclaration;

    @Column(name = "second_holder_mobile", length = 10)
    @JsonProperty("second_holder_mobile")
    private String secondHolderMobile;

    // Note the JSON key has a space in it
    @Column(name = "second_holder_mobile_declaration", length = 2)
    @JsonProperty("second_holder_mobile declaration")
    private String secondHolderMobileDeclaration;

    @Column(name = "third_holder_email", length = 50)
    @JsonProperty("third_holder_email")
    private String thirdHolderEmail;

    @Column(name = "third_holder_email_declaration", length = 2)
    @JsonProperty("third_holder_email_declaration")
    private String thirdHolderEmailDeclaration;

    @Column(name = "third_holder_mobile", length = 10)
    @JsonProperty("third_holder_mobile")
    private String thirdHolderMobile;

    @Column(name = "third_holder_mobile_declaration", length = 2)
    @JsonProperty("third_holder_mobile_declaration")
    private String thirdHolderMobileDeclaration;

    @JsonProperty("guardian_relation")
    @Column(name = "guardian_relation", length = 2)
    private String guardianRelation;
    
    
    @Column(name = "reg_id", length = 20)
    @JsonProperty("reg_id")
    private String regId;

    @Column(name = "reg_status", length = 10)
    @JsonProperty("reg_status")
    private String regStatus;

    @Column(name = "reg_remark", length = 2)
    @JsonProperty("reg_remark")
    private String regRenark;

    @JsonProperty("consent_flag")
    @Column(name = "consent_flag", length = 10)
    private String consentFlag;
}
