package com.cyfrifpro.restcontrollers.NSE;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cyfrifpro.model.NSE.NSEInvestorDetails;
import com.cyfrifpro.services.NSE.NSEInvestorDetailsService;

@RestController("api/nse")
public class InvestorController {

    private final NSEInvestorDetailsService nseInvestorService;

    public InvestorController(NSEInvestorDetailsService nseInvestorService) {
        this.nseInvestorService = nseInvestorService;
    }

    @PostMapping("/save")
    public NSEInvestorDetails createInvestor(@RequestBody NSEInvestorDetails investorDetails) {
        return nseInvestorService.saveInvestorDetails(investorDetails);
    }

    @GetMapping("/get")
    public List<NSEInvestorDetails> getAllInvestors() {
        return nseInvestorService.getAllInvestorDetails();
    }
}
