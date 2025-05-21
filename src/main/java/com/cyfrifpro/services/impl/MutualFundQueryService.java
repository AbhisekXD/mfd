package com.cyfrifpro.services.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cyfrifpro.model.Scheme;
import com.cyfrifpro.model.FundHouse;

@Service
@Transactional(readOnly = true)
public class MutualFundQueryService {

    private final JdbcTemplate jdbcTemplate;

    // Base query joining scheme with fund_house to also fetch the fund house name.
    private static final String SCHEME_COLUMNS =
            "s.scheme_code, s.scheme_name, s.isin_growth, s.nav, s.date, s.category, f.name as fund_house";
    private static final String BASE_QUERY =
            "SELECT " + SCHEME_COLUMNS + " FROM scheme s JOIN fund_house f ON s.fund_house_id = f.id";

    public MutualFundQueryService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * Returns schemes, optionally filtering by fund house name.
     * 
     * If the provided fundHouse parameter is null or empty, all schemes are returned.
     * Otherwise, only schemes where the fund house name matches (using LIKE filtering) are returned.
     * 
     * @param fundHouse (optional) the (partial) name of the fund house to search for.
     * @return a list of schemes matching the criteria.
     */
    public List<Scheme> getSchemes(String fundHouse) {
        if (fundHouse == null || fundHouse.trim().isEmpty()) {
            return jdbcTemplate.query(BASE_QUERY, new SchemeRowMapper());
        } else {
            String sql = BASE_QUERY + " WHERE f.name LIKE ?";
            return jdbcTemplate.query(sql, new SchemeRowMapper(), "%" + fundHouse + "%");
        }
    }

    /**
     * Returns schemes whose category contains the specified filter.
     * For example, filter "Money Market" will match "Open Ended Schemes ( Money Market )"
     * even if extra words are present.
     * 
     * @param categoryFilter the filter to search in the category column.
     * @return a list of schemes matching the criteria.
     */
    public List<Scheme> getSchemesByCategory(String categoryFilter) {
        String sql = BASE_QUERY + " WHERE s.category LIKE ?";
        return jdbcTemplate.query(sql, new SchemeRowMapper(), "%" + categoryFilter + "%");
    }

    /**
     * Returns all fund houses from the fund_house table.
     *
     * @return a list of FundHouse objects.
     */
    public List<FundHouse> getAllFundHouses() {
        String sql = "SELECT id, name FROM fund_house";
        return jdbcTemplate.query(sql, new FundHouseRowMapper());
    }

    /**
     * RowMapper to map the result set to a Scheme POJO.
     */
    private static class SchemeRowMapper implements RowMapper<Scheme> {
        @Override
        public Scheme mapRow(ResultSet rs, int rowNum) throws SQLException {
            Scheme scheme = new Scheme();
            scheme.setSchemeCode(rs.getString("scheme_code"));
            scheme.setSchemeName(rs.getString("scheme_name"));
            scheme.setIsinGrowth(rs.getString("isin_growth"));
            scheme.setNav(rs.getString("nav"));
            scheme.setDate(rs.getString("date"));
            scheme.setCategory(rs.getString("category"));
            // Optionally, you can store the fund house name if needed:
            // scheme.setFundHouse(rs.getString("fund_house"));
            return scheme;
        }
    }

    /**
     * RowMapper to map the result set to a FundHouse POJO.
     */
    private static class FundHouseRowMapper implements RowMapper<FundHouse> {
        @Override
        public FundHouse mapRow(ResultSet rs, int rowNum) throws SQLException {
            FundHouse fundHouse = new FundHouse();
            fundHouse.setId(rs.getLong("id"));
            fundHouse.setName(rs.getString("name"));
            return fundHouse;
        }
    }
}
