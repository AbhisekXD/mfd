package com.cyfrifpro.payloads.apimf;

import lombok.Data;

@Data
public class Meta {
	private String fund_house;
	private String scheme_type;
	private String scheme_category;
	private int scheme_code;
	private String scheme_name;
	private String isin_growth;
	private String isin_div_reinvestment;

}