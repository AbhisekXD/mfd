package com.cyfrifpro.restcontrollers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cyfrifpro.model.FundHouse;
import com.cyfrifpro.model.Scheme;
import com.cyfrifpro.services.impl.MutualFundQueryService;

@RestController
public class MutualFundQueryController {

	private final MutualFundQueryService queryService;

	public MutualFundQueryController(MutualFundQueryService queryService) {
		this.queryService = queryService;
	}

	/**
	 * Endpoint to retrieve schemes. If the optional query parameter "name" is
	 * provided, the response is filtered by fund house name.
	 * 
	 * Examples: GET /schemes -> returns all schemes. GET /schemes?name=Axis ->
	 * returns schemes for fund houses with names containing "Axis".
	 */
	@GetMapping("/schemes")
	public List<Scheme> getSchemes(@RequestParam(required = false) String name) {
		return queryService.getSchemes(name);
	}

	/**
	 * Endpoint to filter schemes by category. Example:
	 * /schemes/category?filter=Equity
	 */
	@GetMapping("/schemes/category")
	public List<Scheme> getSchemesByCategory(@RequestParam String filter) {
		return queryService.getSchemesByCategory(filter);
	}

	/**
	 * Endpoint to retrieve all fund houses. Example: GET /fundhouses
	 */
	@GetMapping("/fundhouses")
	public List<FundHouse> getAllFundHouses() {
		return queryService.getAllFundHouses();
	}
}
