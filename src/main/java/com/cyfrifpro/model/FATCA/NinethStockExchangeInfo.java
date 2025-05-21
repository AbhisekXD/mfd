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
@Table(name = "Fatca_stock_exchange_info")  // Added Table name
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class NinethStockExchangeInfo {

	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;  // Primary key

    @Column(name = "EXCH_NAME")
    private String exchName;  // Stock Exchange Name (BSE, NSE, etc.)
}
