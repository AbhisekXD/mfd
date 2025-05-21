package com.cyfrifpro.model;

import org.springframework.web.bind.annotation.RestController;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@RestController
public class MutualFundEntity {

    @Id
    private Integer schemeCode;
    private String schemeName;
    private String isinGrowth;
    private String isinDivReinvestment;
    
	public MutualFundEntity(Integer schemeCode, String schemeName, String isinGrowth,
			String isinDivReinvestment) {
		super();
		this.schemeCode = schemeCode;
		this.schemeName = schemeName;
		this.isinGrowth = isinGrowth;
		this.isinDivReinvestment = isinDivReinvestment;
	}

}
