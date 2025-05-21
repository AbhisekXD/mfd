package com.cyfrifpro.model.FATCA;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "Fatca_ultimate_beneficial_ownership")  // Added table name with "Fatca_before"
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class TenthUltimateBeneficialOwnership {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;  // Primary key

    @Column(name = "UBO_APPL")
    private String uboAppl;  // UBO Applied Flag (Y/N)

    @Column(name = "UBO_COUNT")
    private String uboCount;  // Number of UBOs

    @Column(name = "UBO_NAME")
    private String uboName;  // UBO Name

    @Column(name = "UBO_PAN")
    private String uboPan;  // UBO PAN Number (if available)

    @Column(name = "UBO_NATION")
    private String uboNation;  // UBO Nationality

    @Column(name = "UBO_ADD1")
    private String uboAdd1;  // UBO Address Line 1

    @Column(name = "UBO_ADD2")
    private String uboAdd2;  // UBO Address Line 2

    @Column(name = "UBO_ADD3")
    private String uboAdd3;  // UBO Address Line 3

    @Column(name = "UBO_CITY")
    private String uboCity;  // UBO City

    @Column(name = "UBO_PIN")
    private String uboPin;  // UBO Pin Code

    @Column(name = "UBO_STATE")
    private String uboState;  // UBO State

    @Column(name = "UBO_CNTRY")
    private String uboCntry;  // UBO Country of Tax Residency

    @Column(name = "UBO_ADD_TY")
    private String uboAddTy;  // UBO Address Type (Residential, Business, etc.)

    @Column(name = "UBO_CTR")
    private String uboCtr;  // UBO Country of Tax Residency

    @Column(name = "UBO_TIN")
    private String uboTin;  // UBO Taxpayer Identification Number

    @Column(name = "UBO_ID_TY")
    private String uboIdTy;  // UBO Identification Type

    @Column(name = "UBO_COB")
    private String uboCob;  // UBO Country of Birth

    @Column(name = "UBO_DOB")
    private String uboDob;  // UBO Date of Birth

    @Column(name = "UBO_GENDER")
    private String uboGender;  // UBO Gender (M/F/O)

    @Column(name = "UBO_FR_NAM")
    private String uboFrNam;  // UBO Father's Name

    @Column(name = "UBO_OCC")
    private String uboOcc;  // UBO Occupation

    @Column(name = "UBO_OCC_TY")
    private String uboOccTy;  // UBO Occupation Type (S/B/O)

    @Column(name = "UBO_TEL")
    private String uboTel;  // UBO Telephone Number

    @Column(name = "UBO_MOBILE")
    private String uboMobile;  // UBO Mobile Number

    @Column(name = "UBO_CODE")
    private String uboCode;  // UBO Code

    @Column(name = "UBO_HOL_PC")
    private String uboHolPc;  // UBO Hold Percentage
}
