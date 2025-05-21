package com.cyfrifpro.restcontrollers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cyfrifpro.services.impl.MutualFundDataService;
import com.cyfrifpro.services.impl.MutualFundServiceAMFI;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RestController
public class MutualFundAMFIController {

    private final MutualFundDataService mutualFundDataService;
    private final MutualFundServiceAMFI mutualFundServiceAMFI;

    public MutualFundAMFIController(MutualFundDataService mutualFundDataService,
                                    MutualFundServiceAMFI mutualFundServiceAMFI) {
        this.mutualFundDataService = mutualFundDataService;
        this.mutualFundServiceAMFI = mutualFundServiceAMFI;
    }

    @GetMapping("/fetchNavHistory")
    public String getNavHistory() throws Exception {
        // Get the current date and subtract one day
        LocalDate today = LocalDate.now();
        LocalDate oneDayBefore = today.minusDays(1);
        
        // Format the date to "dd-MMM-yyyy"
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
        String formattedDate = oneDayBefore.format(formatter);
        
        // Fetch NAV history using the formatted date
        String rawResponse = mutualFundServiceAMFI.fetchNavHistory(formattedDate);
        mutualFundDataService.saveMutualFundData(rawResponse);  // Call the method from the correct service
        return "Data saved successfully!";
    }
}
