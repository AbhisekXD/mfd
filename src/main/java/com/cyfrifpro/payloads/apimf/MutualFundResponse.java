package com.cyfrifpro.payloads.apimf;

import lombok.Data;

@Data
public class MutualFundResponse {
    private Integer schemeCode;
    private String schemeName;
    private String isinGrowth;
    private String isinDivReinvestment;

}
