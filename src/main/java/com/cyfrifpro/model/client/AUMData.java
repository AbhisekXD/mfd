 	package com.cyfrifpro.model.client;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "AUM_data")
public class AUMData{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "brok_dlr_code")
    private String brokDlrCode;

    @Column(name = "product")
    private String product;

    @Column(name = "asset_date")
    @Temporal(TemporalType.DATE)
    private Date assetDate;

    @Column(name = "folio")
    private String folio;

    @Column(name = "inv_name")
    private String invName;

    @Column(name = "scheme_name")
    private String schemeName;

    @Column(name = "cost_value")
    private Double costValue;

    @Column(name = "closing_assets")
    private Double closingAssets;

    @Column(name = "city")
    private String city;

    @Column(name = "email_id")
    private String emailId;

    @Column(name = "tax_status")
    private String taxStatus;

    @Column(name = "units")
    private Double units;

    @Column(name = "nav")
    private Double nav;

    @Column(name = "inv_iin")
    private String invIin;
}
