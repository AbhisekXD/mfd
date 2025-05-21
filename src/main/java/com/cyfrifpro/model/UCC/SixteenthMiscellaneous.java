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
@Table(name = "cliet_miscellaneous")
public class SixteenthMiscellaneous {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String filler1;
	@Column
	private String filler2;
	@Column
	private String filler3;


	public SixteenthMiscellaneous(String filler1, String filler2, String filler3) {
		this.filler1 = filler1;
		this.filler2 = filler2;
		this.filler3 = filler3;
	}

}