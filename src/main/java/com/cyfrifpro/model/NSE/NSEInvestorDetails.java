package com.cyfrifpro.model.NSE;

import java.math.BigDecimal;
import java.util.Date;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "nse_investor_details")
public class NSEInvestorDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 70)
    @Column(name = "fr_name", length = 70)
    private String frName;

    @Size(max = 70)
    @Column(name = "sp_name", length = 70)
    private String spName;

    @Size(max = 3)
    @Column(name = "tax_status", length = 3)
    private String taxStatus;

    @Size(max = 1)
    @Column(name = "data_src", length = 1)
    private String dataSrc;

    @Size(max = 1)
    @Column(name = "addr_type", length = 1)
    private String addrType;

    @Size(max = 60)
    @Column(name = "po_bir_inc", length = 60)
    private String poBirInc;

    @Size(max = 50)
    @Column(name = "co_bir_inc", length = 50)
    private String coBirInc;

    @Size(max = 50)
    @Column(name = "tax_res1", length = 50)
    private String taxRes1;

    @Size(max = 20)
    @Column(name = "tpin1", length = 20)
    private String tpin1;

    @Size(max = 2)
    @Column(name = "id1_type", length = 2)
    private String id1Type;

    @Size(max = 50)
    @Column(name = "tax_res2", length = 50)
    private String taxRes2;

    @Size(max = 20)
    @Column(name = "tpin2", length = 20)
    private String tpin2;

    @Size(max = 2)
    @Column(name = "id2_type", length = 2)
    private String id2Type;

    @Size(max = 50)
    @Column(name = "tax_res3", length = 50)
    private String taxRes3;

    @Size(max = 20)
    @Column(name = "tpin3", length = 20)
    private String tpin3;

    @Size(max = 2)
    @Column(name = "id3_type", length = 2)
    private String id3Type;

    @Size(max = 50)
    @Column(name = "tax_res4", length = 50)
    private String taxRes4;

    @Size(max = 20)
    @Column(name = "tpin4", length = 20)
    private String tpin4;

    @Size(max = 2)
    @Column(name = "id4_type", length = 2)
    private String id4Type;

    @Size(max = 3)
    @Column(name = "srce_wealt", length = 3)
    private String srceWealt;

    @Size(max = 2)
    @Column(name = "corp_servs", length = 2)
    private String corpServs;

    @Size(max = 5)
    @Column(name = "inc_slab", length = 5)
    private String incSlab;

    @Column(name = "net_worth", precision = 19, scale = 2)
    private BigDecimal netWorth;

    @Column(name = "nw_date")
    private Date nwDate;

    @Size(max = 1)
    @Column(name = "pep_flag", length = 1)
    private String pepFlag;

    @Size(max = 2)
    @Column(name = "occ_code", length = 2)
    private String occCode;

    @Size(max = 1)
    @Column(name = "occ_type", length = 1)
    private String occType;

    @Size(max = 2)
    @Column(name = "exemp_code", length = 2)
    private String exempCode;

    @Size(max = 20)
    @Column(name = "ffi_drnfe", length = 20)
    private String ffiDrnfe;

    @Size(max = 19)
    @Column(name = "giin_no", length = 19)
    private String giinNo;

    @Size(max = 60)
    @Column(name = "spr_entity", length = 60)
    private String sprEntity;

    @Size(max = 2)
    @Column(name = "giin_na", length = 2)
    private String giinNa;

    @Size(max = 2)
    @Column(name = "giin_exemc", length = 2)
    private String giinExemc;

    @Size(max = 3)
    @Column(name = "nffe_catg", length = 3)
    private String nffeCatg;

    @Size(max = 3)
    @Column(name = "act_nfe_sc", length = 3)
    private String actNfeSc;

    @Size(max = 30)
    @Column(name = "nature_bus", length = 30)
    private String natureBus;

    @Size(max = 70)
    @Column(name = "rel_listed", length = 70)
    private String relListed;

    @Size(max = 2)
    @Column(name = "exch_name", length = 2)
    private String exchName;

    @Size(max = 2)
    @Column(name = "ubo_appl", length = 2)
    private String uboAppl;

    @Size(max = 3)
    @Column(name = "ubo_count", length = 3)
    private String uboCount;

    @Size(max = 70)
    @Column(name = "ubo_name", length = 70)
    private String uboName;

    @Size(max = 10)
    @Column(name = "ubo_pan", length = 10)
    private String uboPan;

    @Size(max = 3)
    @Column(name = "ubo_nation", length = 3)
    private String uboNation;

    @Size(max = 50)
    @Column(name = "ubo_add1", length = 50)
    private String uboAdd1;

    @Size(max = 50)
    @Column(name = "ubo_add2", length = 50)
    private String uboAdd2;

    @Size(max = 50)
    @Column(name = "ubo_add3", length = 50)
    private String uboAdd3;

    @Size(max = 50)
    @Column(name = "ubo_city", length = 50)
    private String uboCity;

    @Size(max = 6)
    @Column(name = "ubo_pin", length = 6)
    private String uboPin;

    @Size(max = 3)
    @Column(name = "ubo_state", length = 3)
    private String uboState;

    @Size(max = 4)
    @Column(name = "ubo_cntry", length = 4)
    private String uboCntry;

    @Size(max = 2)
    @Column(name = "ubo_add_ty", length = 2)
    private String uboAddTy;

    @Size(max = 4)
    @Column(name = "ubo_ctr", length = 4)
    private String uboCtr;

    @Size(max = 20)
    @Column(name = "ubo_tin", length = 20)
    private String uboTin;

    @Size(max = 2)
    @Column(name = "ubo_id_ty", length = 2)
    private String uboIdTy;

    @Size(max = 30)
    @Column(name = "ubo_cob", length = 30)
    private String uboCob;

    @Column(name = "ubo_dob")
    private Date uboDob;

    @Size(max = 1)
    @Column(name = "ubo_gender", length = 1)
    private String uboGender;

    @Size(max = 50)
    @Column(name = "ubo_fr_nam", length = 50)
    private String uboFrNam;

    @Size(max = 2)
    @Column(name = "ubo_occ", length = 2)
    private String uboOcc;

    @Size(max = 2)
    @Column(name = "ubo_occ_ty", length = 2)
    private String uboOccTy;

    @Size(max = 12)
    @Column(name = "ubo_tel", length = 12)
    private String uboTel;

    @Size(max = 12)
    @Column(name = "ubo_mobile", length = 12)
    private String uboMobile;

    @Size(max = 3)
    @Column(name = "ubo_code", length = 3)
    private String uboCode;

    @Size(max = 3)
    @Column(name = "ubo_hol_pc", length = 3)
    private String uboHolPc;

    @Size(max = 2)
    @Column(name = "sdf_flag", length = 2)
    private String sdfFlag;

    @Size(max = 2)
    @Column(name = "ubo_df", length = 2)
    private String uboDf;

    @Size(max = 30)
    @Column(name = "aadhaar_rp", length = 30)
    private String aadhaarRp;

    @Size(max = 2)
    @Column(name = "new_change", length = 2)
    private String newChange;

    @Size(max = 30)
    @Column(name = "log_name", length = 30)
    private String logName;

    @Size(max = 30)
    @Column(name = "filler1", length = 30)
    private String filler1;

    @Size(max = 30)
    @Column(name = "filler2", length = 30)
    private String filler2;

}
