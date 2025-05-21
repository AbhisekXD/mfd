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
@Table(name = "client_investment_information")
public class SecondInvestmentInformation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String pms;
	@Column
	private String defaultDp;
	@Column
	private String cdsldpid;
	@Column
	private String cdsldcltid;
	@Column
	private Long cmbpId;
	@Column
	private String nsdldpid;
	@Column
	private String nsdlcltid;


	// Constructor with all fields
	public SecondInvestmentInformation(String pms, String defaultDp, String cdsldpid, String cdsldcltid, Long cmbpId,
			String nsdldpid, String nsdlcltid) {
		this.pms = pms;
		this.defaultDp = defaultDp;
		this.cdsldpid = cdsldpid;
		this.cdsldcltid = cdsldcltid;
		this.cmbpId = cmbpId;
		this.nsdldpid = nsdldpid;
		this.nsdlcltid = nsdlcltid;
	}
}