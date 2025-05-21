package com.cyfrifpro.services.impl;

import org.springframework.stereotype.Service;

import com.cyfrifpro.fiegn.MutualFundClientAMFI;

@Service
public class MutualFundServiceAMFI {

    private final MutualFundClientAMFI mutualFundClientAMFI;

    public MutualFundServiceAMFI(MutualFundClientAMFI mutualFundClientAMFI) {
        this.mutualFundClientAMFI = mutualFundClientAMFI;
    }

    public String fetchNavHistory(String fromDate) {
        // Call the Feign client and fetch the response
        return mutualFundClientAMFI.getNavHistory(fromDate);
    }
}
