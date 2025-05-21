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
@Table(name = "client_adress")
public class FifthAddressDetails {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String address1;
    
    @Column
    private String address2;
    
    @Column
    private String address3;
    
    @Column
    private String city;
    
    @Column
    private String state;
    
    @Column
    private String pincode;
    
    @Column
    private String country;

    // Constructor with all fields
    public FifthAddressDetails(String address1, String address2, String address3, String city, String state, String pincode, String country) {
        this.address1 = address1;
        this.address2 = address2;
        this.address3 = address3;
        this.city = city;
        this.state = state;
        this.pincode = pincode;
        this.country = country;
    }
}
