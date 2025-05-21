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
@Table(name = "Fatca_additional_flags_and_identifiers")  // Added Table name
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class ElleventhAdditionalFlagsAndIdentifiers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;  // Primary key

    @Column(name = "SDF_FLAG")
    private String sdfFlag;  // SDF Flag (Y/N)

    @Column(name = "UBO_DF")
    private String uboDf;  // Default Flag for UBOs (Y/N)

    @Column(name = "AADHAAR_RP")
    private String aadhaarRp;  // Aadhaar Number of Reporting Person

    @Column(name = "NEW_CHANGE")
    private String newChange;  // Indicates if it's a new or changed record

    @Column(name = "LOG_NAME")
    private String logName;  // Log Name of the User

    @Column(name = "FILLER1")
    private String filler1;  // Placeholder for future use

    @Column(name = "FILLER2")
    private String filler2;  // Placeholder for future use
}

