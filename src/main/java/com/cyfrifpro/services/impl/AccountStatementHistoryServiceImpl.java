package com.cyfrifpro.services.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cyfrifpro.model.AccountStatement;
import com.cyfrifpro.model.AccountStatementHistory;
import com.cyfrifpro.repositories.AccountStatementHistoryRepo;
import com.cyfrifpro.repositories.AccountStatementRepo;
import com.cyfrifpro.services.AccountStatementHistoryService;

@Service
public class AccountStatementHistoryServiceImpl implements AccountStatementHistoryService{

    @Autowired
    private AccountStatementRepo accountStatementRepo;
    
    @Autowired
    private AccountStatementHistoryRepo accountStatementHistoryRepo;

    /**
     * Saves a history entry when the `AccountStatement` is inserted or updated.
     *
     * @param accountStatement the `AccountStatement` entity
     */
    public void saveHistory(AccountStatement accountStatement) {
        AccountStatementHistory history = new AccountStatementHistory();

        // Copy fields from AccountStatement to AccountStatementHistory
        history.setArnCode(accountStatement.getArnCode());
        history.setUcc(accountStatement.getUcc());
        history.setName(accountStatement.getName());
        history.setAmc(accountStatement.getAmc());
        history.setSchemeType(accountStatement.getSchemeType());
        history.setFolioNo(accountStatement.getFolioNo());
        history.setSchemeName(accountStatement.getSchemeName());
        history.setNav(accountStatement.getNav());
        history.setUnit(accountStatement.getUnit());
        history.setPurchaseValue(accountStatement.getPurchaseValue());
        history.setCurrentValue(accountStatement.getCurrentValue());
        history.setGrowth(accountStatement.getGrowth());
        history.setPercentGrowth(accountStatement.getPercentGrowth());
        history.setCreatedAt(LocalDate.now());

        // Save the history record (this will create a new row)
        accountStatementRepo.save(history);
    }
    
    @Override
    public List<AccountStatementHistory> getAllHistory() {
        return accountStatementHistoryRepo.findAll();
    }
 
}

