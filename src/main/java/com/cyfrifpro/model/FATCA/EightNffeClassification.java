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
@Table(name = "Fatca_nffe_classification")  // Added Table name
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class EightNffeClassification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;  // Primary key

    @Column(name = "NFFE_CATG")
    private String nffeCatg;  // NFFE Category (Listed, Active, Passive, etc.)

    @Column(name = "ACT_NFE_SC")
    private String actNfeSc;  // Active NFE Subcategory

    @Column(name = "NATURE_BUS")
    private String natureBus;  // Nature of Business for Active/Passive NFE

    @Column(name = "REL_LISTED")
    private String relListed;  // Listed Company Relation (If any)
}
