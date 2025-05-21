package com.cyfrifpro.model.distributor;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="distributor_declaration_and_signature")

public class DistributorDeclarationAndSignature {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date declarationValidUpto;
    private String declarationPlace;
    
    @Lob
    private byte[] declarationSignature;

}
