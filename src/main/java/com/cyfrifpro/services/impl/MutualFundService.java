package com.cyfrifpro.services.impl;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cyfrifpro.fiegn.MutualFundClient;
import com.cyfrifpro.model.MutualFundEntity;
import com.cyfrifpro.payloads.MutualFundDetailsBySchemeNameResponse;
import com.cyfrifpro.payloads.apimf.MutualFundDetailsResponse;
import com.cyfrifpro.payloads.apimf.MutualFundResponse;

import feign.FeignException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class MutualFundService {

	private static final Logger log = LoggerFactory.getLogger(MutualFundService.class);

	private final MutualFundClient mutualFundClient;
	private final JdbcTemplate jdbcTemplate;

	public MutualFundService(MutualFundClient mutualFundClient, JdbcTemplate jdbcTemplate) {
		this.mutualFundClient = mutualFundClient;
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * Fetches all mutual funds from the external client, truncates the table, and
	 * saves the new data using a multi-row insert per partition. This method is
	 * asynchronous and transactional.
	 */
	@Async("taskExecutor")
	@Transactional
	public CompletableFuture<List<MutualFundEntity>> getAllMutualFundsAsync() {
		log.info("Fetching all mutual funds from external client...");
		List<MutualFundResponse> mutualFunds = mutualFundClient.getAllMutualFunds();

		log.info("Truncating table for fast deletion...");
		jdbcTemplate.execute("TRUNCATE TABLE mutual_fund_entity");

		log.info("Mapping responses to entities using parallel stream...");
		List<MutualFundEntity> entities = mutualFunds
				.parallelStream().map(response -> new MutualFundEntity(response.getSchemeCode(),
						response.getSchemeName(), response.getIsinGrowth(), response.getIsinDivReinvestment()))
				.collect(Collectors.toList());

		int partitionSize = 100; // Adjust this value as needed
		List<List<MutualFundEntity>> partitions = partitionList(entities, partitionSize);
		log.info("Inserting new data in {} partitions using multi-row insert...", partitions.size());

		// For each partition, build one multi-row INSERT statement.
		for (List<MutualFundEntity> partition : partitions) {
			// Build a SQL statement with one set of placeholders for each row.
			String sql = "INSERT INTO mutual_fund_entity (scheme_code, scheme_name, isin_growth, isin_div_reinvestment) VALUES "
					+ partition.stream().map(entity -> "(?, ?, ?, ?)").collect(Collectors.joining(", "));

			// Build the parameters array by flattening the partition.
			Object[] params = partition.stream().flatMap(entity ->
			// Using Stream.of(...) to create a stream of the four values.
			java.util.stream.Stream.of(entity.getSchemeCode(), entity.getSchemeName(), entity.getIsinGrowth(),
					entity.getIsinDivReinvestment())).toArray();

			jdbcTemplate.update(sql, params);
		}
		log.info("Data updated successfully. Total rows saved: {}", entities.size());
		System.err.println(entities.size());
		return CompletableFuture.completedFuture(entities);
	}

	@Async
	public CompletableFuture<MutualFundDetailsResponse> getMutualFundDetailsAsync(String schemeCode) {
		log.info("Fetching mutual fund details for schemeCode: {}", schemeCode);
		return CompletableFuture.completedFuture(mutualFundClient.getMutualFundBySchemeCode(schemeCode));
	}
	
	@Async
	public CompletableFuture<List<MutualFundDetailsBySchemeNameResponse>> getMutualFundBySchemeName(String schemeName) {
	    log.info("Fetching mutual fund details for schemeName: {}", schemeName);
	    try {
	        // Call the Feign client to get a list of mutual funds
	        List<MutualFundDetailsBySchemeNameResponse> response = mutualFundClient.getMutualFundBySchemeName(schemeName);

	        if (response == null || response.isEmpty()) {
	            log.warn("No mutual funds found for schemeName: {}", schemeName);
	            throw new RuntimeException("No mutual funds found for the given schemeName");
	        }

	        return CompletableFuture.completedFuture(response);
	    } catch (FeignException e) {
	        log.error("Feign exception while fetching mutual fund details: {}", e.getMessage(), e);
	        throw new RuntimeException("Error during Feign call", e);
	    } catch (Exception e) {
	        log.error("Unexpected error while fetching mutual fund details: {}", e.getMessage(), e);
	        throw new RuntimeException("Unexpected error", e);
	    }
	}
	
	@Async
	public CompletableFuture<MutualFundDetailsResponse> getMutualFundDetailslatestAsync(String schemeCode) {
		log.info("Fetching mutual fund latest details for schemeCode: {}", schemeCode);
		return CompletableFuture.completedFuture(mutualFundClient.getMutualFundBySchemeCodeLatest(schemeCode));
	}

	@Async
	public CompletableFuture<List<MutualFundEntity>> getAllMutualFundsFromDb() {
		log.info("Fetching all mutual fund entities from the database...");
		String sql = "SELECT scheme_code, scheme_name, isin_growth, isin_div_reinvestment FROM mutual_fund_entity";
		List<MutualFundEntity> entities = jdbcTemplate.query(sql, (rs, rowNum) -> {
			MutualFundEntity entity = new MutualFundEntity();
			entity.setSchemeCode(rs.getInt("scheme_code"));
			entity.setSchemeName(rs.getString("scheme_name"));
			entity.setIsinGrowth(rs.getString("isin_growth"));
			entity.setIsinDivReinvestment(rs.getString("isin_div_reinvestment"));
			return entity;
		});
		log.info("Fetched {} rows from the database.", entities.size());
		return CompletableFuture.completedFuture(entities);
	}

	// Helper method to partition a list into sublists of the given batch size.
	private <T> List<List<T>> partitionList(List<T> list, int partitionSize) {
		return IntStream.range(0, (list.size() + partitionSize - 1) / partitionSize)
				.mapToObj(i -> list.subList(i * partitionSize, Math.min(list.size(), (i + 1) * partitionSize)))
				.collect(Collectors.toList());
	}

	// Scheduled to run daily at 10:55 AM (adjust cron expression as needed)
	@Scheduled(cron = "0 55 10 * * ?")
	public void scheduleDailyUpdate() {
		getAllMutualFundsAsync();
	}
}
