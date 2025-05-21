package com.cyfrifpro.model.UCC;

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
@Table(name = "client_paymentDividend_details")
public class FourthPaymentDividendDetails {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String chequeName;
    
    @Column
    private String divPayMode;

    // Constructor with all fields
    public FourthPaymentDividendDetails(String chequeName, String divPayMode) {
        this.chequeName = chequeName;
        this.divPayMode = divPayMode;
    }
}
