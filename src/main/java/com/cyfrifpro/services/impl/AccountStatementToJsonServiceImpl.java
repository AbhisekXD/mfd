package com.cyfrifpro.services.impl;

import com.cyfrifpro.repositories.AccountStatementRepo;
import com.cyfrifpro.services.AccountStatementToJsonService;
import com.cyfrifpro.services.AccountStatementHistoryService;
import com.cyfrifpro.model.AccountStatement;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class AccountStatementToJsonServiceImpl implements AccountStatementToJsonService {

    @Autowired
    private AccountStatementRepo accountStatementRepo; // JPA repository to save data

    @Autowired
    private AccountStatementHistoryService accountHistoryService; // History service

    private static final Logger log = Logger.getLogger(AccountStatementToJsonServiceImpl.class.getName()); // Logger for debugging

    @Override
    public String convertCsvToJsonAndSaveToDb(String filePath) {
        try (CSVReader csvReader = new CSVReader(new FileReader(filePath))) {
            List<String[]> records = csvReader.readAll();
            return processCsvRecords(records);
        } catch (IOException e) {
            log.severe("IOException while reading the CSV file: " + e.getMessage());
            return "Error reading the CSV file: " + e.getMessage();
        } catch (CsvException e) {
            log.severe("CsvException while parsing the CSV file: " + e.getMessage());
            return "Error parsing the CSV file: " + e.getMessage();
        } catch (Exception e) {
            log.severe("Unexpected error: " + e.getMessage());
            return "Unexpected error: " + e.getMessage();
        }
    }

    @Override
    public String convertCsvToJsonAndSaveToDb(MultipartFile file) {
        try (CSVReader csvReader = new CSVReader(new InputStreamReader(file.getInputStream()))) {
            List<String[]> records = csvReader.readAll();
            return processCsvRecords(records);
        } catch (IOException e) {
            log.severe("IOException while reading the CSV file: " + e.getMessage());
            return "Error reading the CSV file: " + e.getMessage();
        } catch (CsvException e) {
            log.severe("CsvException while parsing the CSV file: " + e.getMessage());
            return "Error parsing the CSV file: " + e.getMessage();
        } catch (Exception e) {
            log.severe("Unexpected error: " + e.getMessage());
            return "Unexpected error: " + e.getMessage();
        }
    }

    private String processCsvRecords(List<String[]> records) {
        String[] header = records.get(0);

        for (int i = 1; i < records.size(); i++) {
            String[] row = records.get(i);
            AccountStatement incomingEntity = new AccountStatement();

            for (int j = 0; j < header.length; j++) {
                String columnName = normalizeColumnName(header[j]);
                String columnValue = row[j];

                Field field = getFieldByName(AccountStatement.class, columnName);
                if (field != null) {
                    field.setAccessible(true);
                    try {
                        setFieldValue(incomingEntity, field, columnValue);
                    } catch (IllegalAccessException e) {
                        log.severe("Error setting field value: " + e.getMessage());
                    }
                }
            }

            incomingEntity.setCreatedAt(LocalDate.now());

            // Check for existing entry
            Optional<AccountStatement> existingEntityOpt = accountStatementRepo.findByArnCodeAndUccAndNameAndAmcAndSchemeTypeAndFolioNoAndSchemeName(
                incomingEntity.getArnCode(),
                incomingEntity.getUcc(),
                incomingEntity.getName(),
                incomingEntity.getAmc(),
                incomingEntity.getSchemeType(),
                incomingEntity.getFolioNo(),
                incomingEntity.getSchemeName()
            );

            if (existingEntityOpt.isPresent()) {
                AccountStatement existingEntity = existingEntityOpt.get();
                if (hasSignificantChanges(existingEntity, incomingEntity)) {
                    // Create a new row if significant changes exist
                    AccountStatement savedEntity = accountStatementRepo.save(incomingEntity);
                    accountHistoryService.saveHistory(savedEntity); // Save to history
                } else {
                    // Update non-key fields of the existing entity
                    updateNonKeyFields(existingEntity, incomingEntity);
                    AccountStatement updatedEntity = accountStatementRepo.save(existingEntity);
                    accountHistoryService.saveHistory(updatedEntity); // Save to history
                }
            } else {
                // No matching record found; create a new row
                AccountStatement savedEntity = accountStatementRepo.save(incomingEntity);
                accountHistoryService.saveHistory(savedEntity); // Save to history
            }
        }

        return "CSV records have been processed and saved to the database.";
    }

    private boolean hasSignificantChanges(AccountStatement existingEntity, AccountStatement incomingEntity) {
        return !existingEntity.getSchemeType().equals(incomingEntity.getSchemeType()) ||
               !existingEntity.getFolioNo().equals(incomingEntity.getFolioNo()) ||
               !existingEntity.getSchemeName().equals(incomingEntity.getSchemeName());
    }

    private void updateNonKeyFields(AccountStatement existingEntity, AccountStatement incomingEntity) {
        existingEntity.setNav(incomingEntity.getNav());
        existingEntity.setUnit(incomingEntity.getUnit());
        existingEntity.setPurchaseValue(incomingEntity.getPurchaseValue());
        existingEntity.setCurrentValue(incomingEntity.getCurrentValue());
        existingEntity.setGrowth(incomingEntity.getGrowth());
        existingEntity.setPercentGrowth(incomingEntity.getPercentGrowth());
        existingEntity.setCreatedAt(LocalDate.now()); // Update timestamp
    }

    private String normalizeColumnName(String columnName) {
        switch (columnName.trim().toLowerCase()) {
            case "arn code":
                return "arnCode";
            case "ucc":
                return "ucc";
            case "name":
                return "name";
            case "amc":
                return "amc";
            case "scheme type":
                return "schemeType";
            case "folio no":
                return "folioNo";
            case "scheme name":
                return "schemeName";
            case "nav":
                return "nav";
            case "unit":
                return "unit";
            case "purchase value":
                return "purchaseValue";
            case "current value":
                return "currentValue";
            case "growth":
                return "growth";
            case "percentage of growth":
                return "percentGrowth";
            default:
                return columnName;
        }
    }

    private Field getFieldByName(Class<?> clazz, String fieldName) {
        try {
            return clazz.getDeclaredField(fieldName);
        } catch (NoSuchFieldException e) {
            log.warning("Field " + fieldName + " not found in CSV entity class.");
            return null;
        }
    }

    private void setFieldValue(AccountStatement accountStatementEntity, Field field, String value) throws IllegalAccessException {
        if (value == null || value.isEmpty()) {
            value = "0";
        }

        if (field.getType() == Double.class) {
            try {
                field.set(accountStatementEntity, Double.parseDouble(value));
            } catch (NumberFormatException e) {
                field.set(accountStatementEntity, null);
            }
        } else if (field.getType() == String.class) {
            field.set(accountStatementEntity, value);
        } else {
            field.set(accountStatementEntity, value);
        }
    }
}
