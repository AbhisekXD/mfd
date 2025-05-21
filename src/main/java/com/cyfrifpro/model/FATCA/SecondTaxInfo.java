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

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "Fatca_tax_info")
public class SecondTaxInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;  // Primary key

    @Column(name = "TAX_STATUS")
    private String taxStatus;  // Tax Status of the investor
    
    @Column(name = "ADDRESE_TYPE")
    private String addrType;

    @Column(name = "DATA_SRC")
    private String dataSrc;  // Data Source (E for Electronically or P for Physical)

    @Column(name = "PO_BIR_INC")
    private String poBirInc;  // Place of Birth or Income (Individuals/Non-Individuals)

    @Column(name = "CO_BIR_INC")
    private String coBirInc;  // Country of Birth/Income

    @Column(name = "TAX_RES1")
    private String taxRes1;  // Country of Tax Residency (First)

    @Column(name = "TPIN1")
    private String tpin1;  // Taxpayer Identification Number / Equivalent

    @Column(name = "ID1_TYPE")
    private String id1Type;  // Identification Document Type (First)

    @Column(name = "TAX_RES2")
    private String taxRes2;  // Country of Tax Residency (Second)

    @Column(name = "TPIN2")
    private String tpin2;  // Taxpayer Identification Number / Equivalent (Second)

    @Column(name = "ID2_TYPE")
    private String id2Type;  // Identification Document Type (Second)

    @Column(name = "TAX_RES3")
    private String taxRes3;  // Country of Tax Residency (Third)

    @Column(name = "TPIN3")
    private String tpin3;  // Taxpayer Identification Number / Equivalent (Third)

    @Column(name = "ID3_TYPE")
    private String id3Type;  // Identification Document Type (Third)

    @Column(name = "TAX_RES4")
    private String taxRes4;  // Country of Tax Residency (Fourth)

    @Column(name = "TPIN4")
    private String tpin4;  // Taxpayer Identification Number / Equivalent (Fourth)

    @Column(name = "ID4_TYPE")
    private String id4Type;  // Identification Document Type (Fourth)

}
