package com.cyfrifpro.model.UCC;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "client_bankAccount_information")
public class ThirdBankAccountInformation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String accountType1;

	@Column
	private String accountNo1;

	@Column
	private String micrNo1;

	@Column
	private String ifscCode1;

	@Column
	private String defaultBankFlag1;

	@Column
	private String accountType2;

	@Column
	private String accountNo2;

	@Column
	private String micrNo2;

	@Column
	private String ifscCode2;

	@Column
	private String defaultBankFlag2;

	@Column
	private String accountType3;

	@Column
	private String accountNo3;

	@Column
	private String micrNo3;

	@Column
	private String ifscCode3;

	@Column
	private String defaultBankFlag3;

	@Column
	private String accountType4;

	@Column
	private String accountNo4;

	@Column
	private String micrNo4;

	@Column
	private String ifscCode4;

	@Column
	private String defaultBankFlag4;

	@Column
	private String accountType5;

	@Column
	private String accountNo5;

	@Column
	private String micrNo5;

	@Column
	private String ifscCode5;

	@Column
	private String defaultBankFlag5;

	
	// Constructor with all fields
	public ThirdBankAccountInformation(String accountType1, String accountNo1, String micrNo1, String ifscCode1,
			String defaultBankFlag1, String accountType2, String accountNo2, String micrNo2, String ifscCode2,
			String defaultBankFlag2, String accountType3, String accountNo3, String micrNo3, String ifscCode3,
			String defaultBankFlag3, String accountType4, String accountNo4, String micrNo4, String ifscCode4,
			String defaultBankFlag4, String accountType5, String accountNo5, String micrNo5, String ifscCode5,
			String defaultBankFlag5) {
		this.accountType1 = accountType1;
		this.accountNo1 = accountNo1;
		this.micrNo1 = micrNo1;
		this.ifscCode1 = ifscCode1;
		this.defaultBankFlag1 = defaultBankFlag1;
		this.accountType2 = accountType2;
		this.accountNo2 = accountNo2;
		this.micrNo2 = micrNo2;
		this.ifscCode2 = ifscCode2;
		this.defaultBankFlag2 = defaultBankFlag2;
		this.accountType3 = accountType3;
		this.accountNo3 = accountNo3;
		this.micrNo3 = micrNo3;
		this.ifscCode3 = ifscCode3;
		this.defaultBankFlag3 = defaultBankFlag3;
		this.accountType4 = accountType4;
		this.accountNo4 = accountNo4;
		this.micrNo4 = micrNo4;
		this.ifscCode4 = ifscCode4;
		this.defaultBankFlag4 = defaultBankFlag4;
		this.accountType5 = accountType5;
		this.accountNo5 = accountNo5;
		this.micrNo5 = micrNo5;
		this.ifscCode5 = ifscCode5;
		this.defaultBankFlag5 = defaultBankFlag5;
	}

}
