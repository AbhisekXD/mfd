package com.cyfrifpro.fiegn;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.cyfrifpro.payloads.MutualFundDetailsBySchemeNameResponse;
import com.cyfrifpro.payloads.apimf.MutualFundDetailsResponse;
import com.cyfrifpro.payloads.apimf.MutualFundResponse;

@FeignClient(name = "mutualFundClient", url = "https://api.mfapi.in/mf")
public interface MutualFundClient {

	// Fetch all mutual funds
	@GetMapping
	List<MutualFundResponse> getAllMutualFunds();

	// Fetch a specific mutual fund by scheme code
	@GetMapping("/{schemeCode}")
	MutualFundDetailsResponse getMutualFundBySchemeCode(@PathVariable String schemeCode);

	// Fetch a specific mutual fund latest data by scheme code
	@GetMapping("/{schemeCode}/latest")
	MutualFundDetailsResponse getMutualFundBySchemeCodeLatest(@PathVariable String schemeCode);
	
	// Fetch a specific mutual fund Scheme code by name
	@GetMapping("/search")
    List<MutualFundDetailsBySchemeNameResponse> getMutualFundBySchemeName(@RequestParam String q);
}
