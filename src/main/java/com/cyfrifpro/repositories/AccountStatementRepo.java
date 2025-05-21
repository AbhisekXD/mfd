package com.cyfrifpro.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cyfrifpro.model.AccountStatement;
import com.cyfrifpro.model.AccountStatementHistory;

@Repository
public interface AccountStatementRepo extends JpaRepository<AccountStatement, Long> {

	void save(AccountStatementHistory history);

	Optional<AccountStatement> findByArnCodeAndUccAndNameAndAmcAndSchemeTypeAndFolioNoAndSchemeName(String arnCode,
			String ucc, String name, String amc, String schemeType, String folioNo, String schemeName);
	
}
