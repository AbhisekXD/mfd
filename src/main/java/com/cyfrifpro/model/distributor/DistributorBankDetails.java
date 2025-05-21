package com.cyfrifpro.model.distributor;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="distributor_bank_details")

public class DistributorBankDetails {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bankName;
    private String branch;
    private String branchAddress;
    private String accountType;
    private String accountNumber;
    private String ifscCode;
    private String micrCode;
    private String city;
    private String state;
    private String pinCode;


}
