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
@Table(name = "client_other_fields")
public class ElleventhOtherIdentifiers {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String mapinId;
	@Column
	private String paperlessFlag;
	@Column
	private String leiNo;
	@Column
	private String leiValidity;


	public ElleventhOtherIdentifiers(String mapinId, String paperlessFlag, String leiNo, String leiValidity) {
		this.mapinId = mapinId;
		this.paperlessFlag = paperlessFlag;
		this.leiNo = leiNo;
		this.leiValidity = leiValidity;
	}

}