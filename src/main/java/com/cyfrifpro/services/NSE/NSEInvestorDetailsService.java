package com.cyfrifpro.services.NSE;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cyfrifpro.model.NSE.NSEInvestorDetails;
import com.cyfrifpro.repositories.NSEInvestorDetailsRepository;

@Service
public class NSEInvestorDetailsService {

    @Autowired
    private NSEInvestorDetailsRepository nseInvestorDetailsRepository;

    public NSEInvestorDetails saveInvestorDetails(NSEInvestorDetails details) {
        return nseInvestorDetailsRepository.save(details);
    }

    public List<NSEInvestorDetails> getAllInvestorDetails() {
        return nseInvestorDetailsRepository.findAll();
    }
}