package com.cyfrifpro.model.FATCA;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "soapFeignClient", url = "https://bsestarmfdemo.bseindia.com/MFUploadService/MFUploadService.svc/Secure")
public interface SoapFeignClient {

    @PostMapping(consumes = "application/soap+xml")
    String callFatcaService(
        @RequestBody String soapRequest,
        @RequestHeader("Content-Type") String contentType
    );
}
