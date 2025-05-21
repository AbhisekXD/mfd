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
@Table(name = "client_foreign_adress")
public class SeventhForeignAddressDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String foreignAddress1;
	@Column
	private String foreignAddress2;
	@Column
	private String foreignAddress3;
	@Column
	private String foreignAddressCity;
	@Column
	private String foreignAddressPincode;
	@Column
	private String foreignAddressState;
	@Column
	private String foreignAddressCountry;
	@Column
	private String foreignAddressResiPhone;
	@Column
	private String foreignAddressFax;
	@Column
	private String foreignAddressOffPhone;
	@Column
	private String foreignAddressOffFax;
	@Column
	private String indianMobileNo;


	public SeventhForeignAddressDetails(String foreignAddress1, String foreignAddress2, String foreignAddress3,
			String foreignAddressCity, String foreignAddressPincode, String foreignAddressState,
			String foreignAddressCountry, String foreignAddressResiPhone, String foreignAddressFax,
			String foreignAddressOffPhone, String foreignAddressOffFax, String indianMobileNo) {
		this.foreignAddress1 = foreignAddress1;
		this.foreignAddress2 = foreignAddress2;
		this.foreignAddress3 = foreignAddress3;
		this.foreignAddressCity = foreignAddressCity;
		this.foreignAddressPincode = foreignAddressPincode;
		this.foreignAddressState = foreignAddressState;
		this.foreignAddressCountry = foreignAddressCountry;
		this.foreignAddressResiPhone = foreignAddressResiPhone;
		this.foreignAddressFax = foreignAddressFax;
		this.foreignAddressOffPhone = foreignAddressOffPhone;
		this.foreignAddressOffFax = foreignAddressOffFax;
		this.indianMobileNo = indianMobileNo;
	}

}