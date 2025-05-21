package com.cyfrifpro.payloads;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class FatcaDTO {
	
	@JsonProperty("UserId")
	private Long userId;
	
	@JsonProperty("Flag")
	private String flag;
	
	@JsonProperty("EncryptedPassword")
	private String encryptedPassword;

	// 1. Basic Information
	private String panRp;

	private String pekrn;

	private String invName;

	private String dob;

	private String frName;

	private String spName;
	

	// 2. Tax Information
	private String taxStatus;

	private String dataSrc;

	private String addrType;

	private String poBirInc;

	private String coBirInc;
	
                 // Tax Identification & Documentation
	private String taxRes1;

	private String tpin1;

	private String id1Type;

	private String taxRes2;

	private String tpin2;

	private String id2Type;

	private String taxRes3;

	private String tpin3;

	private String id3Type;

	private String taxRes4;

	private String tpin4;

	private String id4Type;
	
	
    // 3. Wealth and Corporate Information
	private String srceWealt;

	private String corpServs;

	private String incSlab;

	private String netWorth;

	private String nwDate;
	
	
	// 4. Politically Exposed Person (PEP)
	private String pepFlag;

	
	// 5. Occupation Information
	private String occCode;

	private String occType;

	
	// 6. Exemption and FFI/DRNFE Information
	private String exemCode;

	private String ffiDrnfe;

	private String giinNo;
	
	
	// 7. Sponsoring Entity Information
	private String sprEntity;

	private String giinNa;

	private String giinExemc;

	
	// 8. NFFE Classification
	private String nffeCatg;

	private String actNfeSc;

	private String natureBus;
	
	private String relListed;
	
	
	// 9. Stock Exchange Information
	private String exchName;
	
	
	// 10. Ultimate Beneficial Ownership (UBO)
	private String uboAppl;

	private String uboCount;

	private String uboName;

	private String uboPan;

	private String uboNation;

	private String uboAdd1;

	private String uboAdd2;

	private String uboAdd3;

	private String uboCity;

	private String uboPin;

	private String uboState;

	private String uboCntry;

	private String uboAddTy;

	private String uboCtr;

	private String uboTin;

	private String uboIdTy;

	private String uboCob;

	private String uboDob;

	private String uboGender;

	private String uboFrNam;

	private String uboOcc;

	private String uboOccTy;

	private String uboTel;

	private String uboMobile;

	private String uboCode;

	private String uboHolPc;
	
	
	// 11. Additional Flags and Identifiers
	private String sdfFlag;

	private String uboDf;

	private String aadhaarRp;

	private String newChange;

	private String logName;

	private String filler1;

	private String filler2;
	
}
