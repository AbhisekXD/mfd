package com.cyfrifpro.fiegn;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "mutualFundClientAMFI", url = "https://portal.amfiindia.com")
public interface MutualFundClientAMFI {

    // Correct endpoint with query parameter
    @GetMapping("/DownloadNAVHistoryReport_Po.aspx")
    String getNavHistory(@RequestParam("frmdt") String fromDate);
}
