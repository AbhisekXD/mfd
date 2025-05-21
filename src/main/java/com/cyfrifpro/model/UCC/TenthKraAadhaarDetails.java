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
@Table(name = "client_kra_adhar")
public class TenthKraAadhaarDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String primaryHolderKraExemptRefNo;
	@Column
	private String secondHolderKraExemptRefNo;
	@Column
	private String thirdHolderKraExemptRefNo;
	@Column
	private String guardianExemptRefNo;
	@Column
	private String aadhaarUpdated;


	public TenthKraAadhaarDetails(String primaryHolderKraExemptRefNo, String secondHolderKraExemptRefNo,
			String thirdHolderKraExemptRefNo, String guardianExemptRefNo, String aadhaarUpdated) {
		this.primaryHolderKraExemptRefNo = primaryHolderKraExemptRefNo;
		this.secondHolderKraExemptRefNo = secondHolderKraExemptRefNo;
		this.thirdHolderKraExemptRefNo = thirdHolderKraExemptRefNo;
		this.guardianExemptRefNo = guardianExemptRefNo;
		this.aadhaarUpdated = aadhaarUpdated;
	}

}