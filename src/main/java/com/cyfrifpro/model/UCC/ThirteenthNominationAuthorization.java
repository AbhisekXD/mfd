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
@Table(name = "client_nomination_authorization")
public class ThirteenthNominationAuthorization {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String nominationOpt;
	@Column
	private String nominationAuthMode;
	@Column
	private String nomineePan1;
	@Column
	private String nomineeGuardianPan1;
	@Column
	private String nomineePan2;
	@Column
	private String nomineeGuardianPan2;
	@Column
	private String nomineePan3;
	@Column
	private String nomineeGuardianPan3;


	public ThirteenthNominationAuthorization(String nominationOpt, String nominationAuthMode, String nomineePan1,
			String nomineeGuardianPan1, String nomineePan2, String nomineeGuardianPan2, String nomineePan3,
			String nomineeGuardianPan3) {
		this.nominationOpt = nominationOpt;
		this.nominationAuthMode = nominationAuthMode;
		this.nomineePan1 = nomineePan1;
		this.nomineeGuardianPan1 = nomineeGuardianPan1;
		this.nomineePan2 = nomineePan2;
		this.nomineeGuardianPan2 = nomineeGuardianPan2;
		this.nomineePan3 = nomineePan3;
		this.nomineeGuardianPan3 = nomineeGuardianPan3;
	}
}