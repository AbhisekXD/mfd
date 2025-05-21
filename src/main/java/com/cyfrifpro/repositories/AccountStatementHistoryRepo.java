package com.cyfrifpro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cyfrifpro.model.AccountStatementHistory;

@Repository
public interface AccountStatementHistoryRepo extends JpaRepository<AccountStatementHistory, Long> {
}
