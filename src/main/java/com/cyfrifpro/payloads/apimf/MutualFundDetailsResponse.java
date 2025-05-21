package com.cyfrifpro.payloads.apimf;

import java.util.List;

import lombok.Data;

@Data
public class MutualFundDetailsResponse {
	    private Meta meta;
	    private List<NavDetail> data;
	    private String status;
}

