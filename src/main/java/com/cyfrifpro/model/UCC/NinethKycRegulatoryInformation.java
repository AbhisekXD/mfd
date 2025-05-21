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
@Table(name = ("client_kyc_regulatory"))
public class NinethKycRegulatoryInformation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String primaryHolderKycType;
	@Column
	private Long primaryHolderCkycNumber;
	@Column
	private String secondHolderKycType;
	@Column
	private Long secondHolderCkycNumber;
	@Column
	private String thirdHolderKycType;
	@Column
	private Long thirdHolderCkycNumber;
	@Column
	private String guardianKycType;
	@Column
	private Long guardianCkycNumber;


	public NinethKycRegulatoryInformation(String primaryHolderKycType, Long primaryHolderCkycNumber,
			String secondHolderKycType, Long secondHolderCkycNumber, String thirdHolderKycType,
			Long thirdHolderCkycNumber, String guardianKycType, Long guardianCkycNumber) {
		this.primaryHolderKycType = primaryHolderKycType;
		this.primaryHolderCkycNumber = primaryHolderCkycNumber;
		this.secondHolderKycType = secondHolderKycType;
		this.secondHolderCkycNumber = secondHolderCkycNumber;
		this.thirdHolderKycType = thirdHolderKycType;
		this.thirdHolderCkycNumber = thirdHolderCkycNumber;
		this.guardianKycType = guardianKycType;
		this.guardianCkycNumber = guardianCkycNumber;
	}

}