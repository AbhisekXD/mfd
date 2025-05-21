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
@Table(name = "client_nominee")
public class EighthNomineeInformation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String nominee1Name;
	@Column
	private String nominee1Relationship;
	@Column
	private Integer nominee1ApplicablePercent;
	@Column
	private String nominee1MinorFlag;
	@Column
	private String nominee1Dob;
	@Column
	private String nominee1Guardian;
	@Column
	private String nominee2Name;
	@Column
	private String nominee2Relationship;
	@Column
	private Integer nominee2ApplicablePercent;
	@Column
	private String nominee2Dob;
	@Column
	private String nominee2MinorFlag;
	@Column
	private String nominee2Guardian;
	@Column
	private String nominee3Name;
	@Column
	private String nominee3Relationship;
	@Column
	private Integer nominee3ApplicablePercent;
	@Column
	private String nominee3Dob;
	@Column
	private String nominee3MinorFlag;
	@Column
	private String nominee3Guardian;

	public EighthNomineeInformation(String nominee1Name, String nominee1Relationship, Integer nominee1ApplicablePercent,
			String nominee1MinorFlag, String nominee1Dob, String nominee1Guardian, String nominee2Name,
			String nominee2Relationship, Integer nominee2ApplicablePercent, String nominee2Dob,
			String nominee2MinorFlag, String nominee2Guardian, String nominee3Name, String nominee3Relationship,
			Integer nominee3ApplicablePercent, String nominee3Dob, String nominee3MinorFlag, String nominee3Guardian) {
		this.nominee1Name = nominee1Name;
		this.nominee1Relationship = nominee1Relationship;
		this.nominee1ApplicablePercent = nominee1ApplicablePercent;
		this.nominee1MinorFlag = nominee1MinorFlag;
		this.nominee1Dob = nominee1Dob;
		this.nominee1Guardian = nominee1Guardian;
		this.nominee2Name = nominee2Name;
		this.nominee2Relationship = nominee2Relationship;
		this.nominee2ApplicablePercent = nominee2ApplicablePercent;
		this.nominee2Dob = nominee2Dob;
		this.nominee2MinorFlag = nominee2MinorFlag;
		this.nominee2Guardian = nominee2Guardian;
		this.nominee3Name = nominee3Name;
		this.nominee3Relationship = nominee3Relationship;
		this.nominee3ApplicablePercent = nominee3ApplicablePercent;
		this.nominee3Dob = nominee3Dob;
		this.nominee3MinorFlag = nominee3MinorFlag;
		this.nominee3Guardian = nominee3Guardian;
	}

}