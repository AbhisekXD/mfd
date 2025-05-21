package com.cyfrifpro.services;

import java.util.List;

import com.cyfrifpro.model.AccountStatement;
import com.cyfrifpro.model.AccountStatementHistory;

public interface AccountStatementHistoryService {

    /**
     * Saves a history entry when the `AccountStatement` is inserted or updated.
     *
     * @param accountStatement the `AccountStatement` entity
     */
    void saveHistory(AccountStatement accountStatement);

    List<AccountStatementHistory> getAllHistory();
}
