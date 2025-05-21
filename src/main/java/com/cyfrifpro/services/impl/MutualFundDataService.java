package com.cyfrifpro.services.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cyfrifpro.model.FundHouse;
import com.cyfrifpro.model.Scheme;

@Service
public class MutualFundDataService {

    private final JdbcTemplate jdbcTemplate;

    public MutualFundDataService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * This method uses JDBC to:
     * 1. Truncate the previous tables (disabling foreign key checks).
     * 2. Parse the large response (grouping Scheme records under their corresponding FundHouse).
     *    It omits any rows where the scheme name contains "Direct Plan".
     * 3. Batch insert FundHouse records (capturing generated keys).
     * 4. Batch insert Scheme records with the corresponding FundHouse IDs.
     */
    @Async
    @Transactional
    public void saveMutualFundData(String rawResponse) {
        // Disable foreign key checks, truncate tables, then re-enable them.
        jdbcTemplate.execute("SET FOREIGN_KEY_CHECKS=0");
        jdbcTemplate.execute("TRUNCATE TABLE scheme");
        jdbcTemplate.execute("TRUNCATE TABLE fund_house");
        jdbcTemplate.execute("SET FOREIGN_KEY_CHECKS=1");

        // Use a LinkedHashMap to preserve insertion order
        Map<String, FundHouse> fundHouseMap = new LinkedHashMap<>();
        String currentCategory = null;
        FundHouse currentFundHouse = null;

        try (BufferedReader reader = new BufferedReader(new StringReader(rawResponse))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) {
                    continue;
                }
                // Skip header row if present
                if (line.startsWith("Scheme Code")) {
                    continue;
                }
                // Check for category header (e.g., "Open Ended Schemes ( Money Market )")
                if (line.startsWith("Open Ended Schemes")) {
                    int start = line.indexOf('(');
                    int end = line.indexOf(')');
                    if (start != -1 && end != -1 && end > start) {
                        currentCategory = line.substring(start + 1, end).trim();
                    } else {
                        currentCategory = line;
                    }
                    continue;
                }
                // If the line doesn't contain a semicolon, treat it as a FundHouse name.
                if (!line.contains(";")) {
                    currentFundHouse = fundHouseMap.get(line);
                    if (currentFundHouse == null) {
                        currentFundHouse = new FundHouse(line);
                        fundHouseMap.put(line, currentFundHouse);
                    }
                    continue;
                }
                // Process data row (lines with semicolons)
                String[] tokens = line.split(";");
                if (tokens.length < 8) {
                    continue;  // Skip if the line doesn't have enough tokens
                }
                // Omit rows where scheme name contains "Direct Plan"
                String schemeName = tokens[1].trim();
                if (schemeName.contains("Direct Plan")) {
                    continue;
                }
                Scheme scheme = new Scheme();
                scheme.setSchemeCode(tokens[0].trim());
                scheme.setSchemeName(schemeName);
                scheme.setIsinGrowth(tokens[2].trim());
                scheme.setNav(tokens[4].trim());
                scheme.setDate(tokens[7].trim());
                scheme.setCategory(currentCategory);

                // Associate scheme with the current FundHouse if available
                if (currentFundHouse != null) {
                    currentFundHouse.addScheme(scheme);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Error reading the mutual fund data", e);
        }

        List<FundHouse> fundHouseList = new ArrayList<>(fundHouseMap.values());
        // Map to store FundHouse name -> generated ID
        Map<String, Long> fundHouseIdMap = new LinkedHashMap<>();

        // Insert FundHouse records one by one to retrieve generated keys.
        String insertFundHouseSql = "INSERT INTO fund_house (name) VALUES (?)";
        for (FundHouse fh : fundHouseList) {
            KeyHolder keyHolder = new GeneratedKeyHolder();
            jdbcTemplate.update(connection -> {
                PreparedStatement ps = connection.prepareStatement(insertFundHouseSql, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, fh.getName());
                return ps;
            }, keyHolder);
            Long generatedId = keyHolder.getKey().longValue();
            fundHouseIdMap.put(fh.getName(), generatedId);
            fh.setId(generatedId); // Assuming FundHouse POJO has an 'id' field.
        }

        // Prepare batch insert for Scheme records.
        String insertSchemeSql = "INSERT INTO scheme (scheme_code, scheme_name, isin_growth, nav, date, category, fund_house_id) VALUES (?, ?, ?, ?, ?, ?, ?)";
        List<Object[]> batchArgs = new ArrayList<>();

        for (FundHouse fh : fundHouseList) {
            Long fundHouseId = fundHouseIdMap.get(fh.getName());
            for (Scheme scheme : fh.getSchemes()) {
                Object[] values = new Object[] {
                    scheme.getSchemeCode(),
                    scheme.getSchemeName(),
                    scheme.getIsinGrowth(),
                    scheme.getNav(),
                    scheme.getDate(),
                    scheme.getCategory(),
                    fundHouseId
                };
                batchArgs.add(values);
            }
        }

        // Perform batch update for Scheme records.
        jdbcTemplate.batchUpdate(insertSchemeSql, batchArgs);
    }
}
