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
@Table(name = "Fatca_sponsoring_entity_details")  // Added Table name
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class SeventhSponsoringEntityDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;  // Primary key

    @Column(name = "SPR_ENTITY")
    private String sprEntity;  // Sponsoring Entity Name

    @Column(name = "GIIN_NA")
    private String giinNa;  // GIIN Status (Applied for, Not Required, or Not Obtained)

    @Column(name = "GIIN_EXEMC")
    private String giinExemc;  // GIIN Exemption Code
}
