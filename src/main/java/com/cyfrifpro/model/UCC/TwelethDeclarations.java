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
@Table(name = "client_declaration")
public class TwelethDeclarations {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String filler1MobileDeclarationFlag;
	@Column
	private String filler2EmailDeclarationFlag;


	public TwelethDeclarations(String filler1MobileDeclarationFlag, String filler2EmailDeclarationFlag) {
		this.filler1MobileDeclarationFlag = filler1MobileDeclarationFlag;
		this.filler2EmailDeclarationFlag = filler2EmailDeclarationFlag;
	}

}
