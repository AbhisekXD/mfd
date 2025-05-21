package com.cyfrifpro.model.UCC;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "client_contact_info")
public class SixthContactInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String resiPhone;
    
    @Column
    private String resiFax;
    
    @Column
    private String officePhone;
    
    @Column
    private String officeFax;
    
    @Column
    private String email;
    
    @Column
    private String communicationMode;


    // Constructor with all fields
    public SixthContactInformation(String resiPhone, String resiFax, String officePhone, String officeFax, String email, String communicationMode) {
        this.resiPhone = resiPhone;
        this.resiFax = resiFax;
        this.officePhone = officePhone;
        this.officeFax = officeFax;
        this.email = email;
        this.communicationMode = communicationMode;
    }
}
