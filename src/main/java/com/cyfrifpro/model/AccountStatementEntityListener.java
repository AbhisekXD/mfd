package com.cyfrifpro.model;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.cyfrifpro.services.AccountStatementHistoryService;

@Component
public class AccountStatementEntityListener {

	@Autowired
    private AccountStatementHistoryService accountHistoryService;

    // This method will be triggered before inserting a new record
    @PrePersist
    public void onPrePersist(AccountStatement accountStatement) {
        if (accountHistoryService != null) {
            accountHistoryService.saveHistory(accountStatement);
        }
    }

    // This method will be triggered before updating an existing record
    @PreUpdate
    public void onPreUpdate(AccountStatement accountStatement) {
        if (accountHistoryService != null) {
            accountHistoryService.saveHistory(accountStatement);
        }
    }
}

