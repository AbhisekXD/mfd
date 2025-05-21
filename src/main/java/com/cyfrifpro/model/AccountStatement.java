package com.cyfrifpro.model;

import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@EntityListeners(AccountStatementEntityListener.class) // Register the listener
@Table(name="account_statement")
public class AccountStatement {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // Auto-generation strategy for unique ID
	private Long id;

	private String arnCode;
	private String ucc;
	private String name;
	private String amc;
	private String schemeType;
	private String folioNo;
	private String schemeName;
	private Double nav;
	private Double unit;
	private Double purchaseValue;
	private Double currentValue;
	private Double growth;
	private Double percentGrowth;

	private LocalDate createdAt; // Timestamp when the entry is created

}
