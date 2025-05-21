package com.cyfrifpro.payloads;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class MutualFundDetailsBySchemeNameResponse {
    private Integer schemeCode;
    private String schemeName;
}

