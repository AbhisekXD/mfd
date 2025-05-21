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
@Table(name = "client_holders_contact_details")
public class FourteenthHoldersContactDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String secondHolderEmail;
	@Column
	private String secondHolderEmailDeclaration;
	@Column
	private String secondHolderMobileNo;
	@Column
	private String secondHolderMobileNoDeclaration;
	@Column
	private String thirdHolderEmail;
	@Column
	private String thirdHolderEmailDeclaration;
	@Column
	private String thirdHolderMobileNo;
	@Column
	private String thirdHolderMobileNoDeclaration;

	public FourteenthHoldersContactDetails(String secondHolderEmail, String secondHolderEmailDeclaration,
			String secondHolderMobileNo, String secondHolderMobileNoDeclaration, String thirdHolderEmail,
			String thirdHolderEmailDeclaration, String thirdHolderMobileNo, String thirdHolderMobileNoDeclaration) {
		this.secondHolderEmail = secondHolderEmail;
		this.secondHolderEmailDeclaration = secondHolderEmailDeclaration;
		this.secondHolderMobileNo = secondHolderMobileNo;
		this.secondHolderMobileNoDeclaration = secondHolderMobileNoDeclaration;
		this.thirdHolderEmail = thirdHolderEmail;
		this.thirdHolderEmailDeclaration = thirdHolderEmailDeclaration;
		this.thirdHolderMobileNo = thirdHolderMobileNo;
		this.thirdHolderMobileNoDeclaration = thirdHolderMobileNoDeclaration;
	}

}