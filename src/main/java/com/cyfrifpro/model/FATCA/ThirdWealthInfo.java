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
@Table(name = "Fatca_wealth_info")
public class ThirdWealthInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;  // Primary key

    @Column(name = "SRCE_WEALT")
    private String srceWealt;  // Source of Wealth

    @Column(name = "CORP_SERVS")
    private String corpServs;  // Corporate Services

    @Column(name = "INC_SLAB")
    private String incSlab;  // Income Slab Code

    @Column(name = "NET_WORTH")
    private String netWorth;  // Net Worth (For Non-Individuals)

    @Column(name = "NW_DATE")
    private String nwDate;  // Date of Net Worth Calculation

}
