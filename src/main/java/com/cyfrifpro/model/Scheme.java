package com.cyfrifpro.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Scheme {

    @Id
    private String schemeCode;
    private String schemeName;
    private String isinGrowth;
    private String nav;
    private String date;
    private String category; // e.g. Money Market, Equity, Debt, etc.

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fund_house_id")
    private FundHouse fundHouse;

    // Constructors, getters, setters

    public Scheme() {}

    // Getters and setters...

    public void setFundHouse(FundHouse fundHouse) {
        this.fundHouse = fundHouse;
    }
}
