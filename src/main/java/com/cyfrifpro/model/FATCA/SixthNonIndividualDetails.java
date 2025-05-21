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
@Table(name = "Fatca_non_individual_details")
public class SixthNonIndividualDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;  // Primary key

    @Column(name = "EXEMP_CODE")
    private String exemCode;  // Exemption Code (For Non-Individuals)

    @Column(name = "FFI_DRNFE")
    private String ffiDrnfe;  // FFI/DRNFE Classification

    @Column(name = "GIIN_NO")
    private String giinNo;  // GIIN Number (For Non-Individuals)
}
