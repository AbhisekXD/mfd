package com.cyfrifpro.services.impl;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cyfrifpro.mapper.FatcaMapper;
import com.cyfrifpro.model.FATCA.Fatca;
import com.cyfrifpro.model.FATCA.SoapFeignClient;
import com.cyfrifpro.payloads.FatcaDTO;
import com.cyfrifpro.payloads.GetPasswordDTO;
import com.cyfrifpro.repositories.FatcaRepo;
import com.cyfrifpro.services.FatcaService;
import com.cyfrifpro.util.ParamStringBuilder;
import com.cyfrifpro.util.SoapUtils;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class FatcaServiceImpl implements FatcaService {

	@Autowired
	private FatcaRepo fatcaRepo;

	@Autowired
	private FatcaMapper fatcaMapper;

	@Autowired
	private SoapFeignClient soapFeignClient; // Inject the Feign client
	
	private static final Logger logger = LoggerFactory.getLogger(FatcaServiceImpl.class);

	/**
	 * Using RestTemplate to call SOAP service
	 */
	private String callSoapServiceWithRestTemplate(String soapRequest) {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.valueOf("application/soap+xml; charset=utf-8"));

		HttpEntity<String> requestEntity = new HttpEntity<>(soapRequest, headers);
		String soapEndpoint = "https://bsestarmfdemo.bseindia.com/MFUploadService/MFUploadService.svc/Secure";

		// Send the SOAP request and get the response as String
		String soapResponse = restTemplate.postForObject(soapEndpoint, requestEntity, String.class);

		// Parse the SOAP response using the utility method
		return SoapUtils.parseGetPasswordResponse(soapResponse);
	}

	/**
	 * Using Feign Client to call SOAP service
	 */
	private String callSoapServiceWithFeignClient(String soapRequest) {
		return soapFeignClient.callFatcaService(soapRequest, "application/soap+xml; charset=utf-8");
	}

	public String getPassword(GetPasswordDTO getPasswordDTO) {
		String soapRequest = constructGetPasswordSoapRequest(getPasswordDTO);

		// Choose between RestTemplate and Feign Client
		// return callSoapServiceWithFeignClient(soapRequest); // Feign Client
		return callSoapServiceWithRestTemplate(soapRequest); // RestTemplate
	}

	public String createFatca(FatcaDTO fatcaDTO) {
		String soapRequest = constructFatcaSoapRequest(fatcaDTO);

		// Choose between RestTemplate and Feign Client
		return callSoapServiceWithFeignClient(soapRequest); // Feign Client
		// return callSoapServiceWithRestTemplate(soapRequest); // RestTemplate
	}

	private String constructGetPasswordSoapRequest(GetPasswordDTO dto) {
	    String soapRequest = """
	            <soap:Envelope xmlns:soap="http://www.w3.org/2003/05/soap-envelope" xmlns:ns="http://bsestarmfdemo.bseindia.com/2016/01/">
	                <soap:Header xmlns:wsa="http://www.w3.org/2005/08/addressing">
	                    <wsa:Action>http://bsestarmfdemo.bseindia.com/2016/01/IMFUploadService/getPassword</wsa:Action>
	                    <wsa:To>https://bsestarmfdemo.bseindia.com/MFUploadService/MFUploadService.svc/Secure</wsa:To>
	                </soap:Header>
	                <soap:Body>
	                    <ns:getPassword>
	                        <ns:UserId>%s</ns:UserId>
	                        <ns:MemberId>%s</ns:MemberId>
	                        <ns:Password>%s</ns:Password>
	                        <ns:PassKey>%s</ns:PassKey>
	                    </ns:getPassword>
	                </soap:Body>
	            </soap:Envelope>
	            """
	            .formatted(dto.getUserId(), dto.getMemberId(), dto.getPassword(), dto.getPassKey());

	    // Print or log the SOAP request
	    logger.info("Generated SOAP Request for GetPassword:\n{}", soapRequest);
	    // System.out.println("Generated SOAP Request for GetPassword:\n" + soapRequest);

	    return soapRequest;
	}

	public String generateParamString(FatcaDTO fatcaDTO) {
		Set<String> excludedFields = new HashSet<>();
		excludedFields.add("flag");
		excludedFields.add("userId");
		excludedFields.add("encryptedPassword");
		excludedFields.add("ddlPANType");

		if (excludedFields.isEmpty()) {
			excludedFields = null; // Pass null to include all fields without exclusion
		}

		return ParamStringBuilder.buildParamString(fatcaDTO, excludedFields);
	}

	private String constructFatcaSoapRequest(FatcaDTO fatcaDTO) {
	    String param = generateParamString(fatcaDTO);
	    String soapRequest = """
	            <soap:Envelope xmlns:soap="http://www.w3.org/2003/05/soap-envelope" xmlns:ns="http://bsestarmfdemo.bseindia.com/2016/01/">
	                <soap:Header xmlns:wsa="http://www.w3.org/2005/08/addressing">
	                    <wsa:Action>http://bsestarmfdemo.bseindia.com/2016/01/IMFUploadService/MFAPI</wsa:Action>
	                    <wsa:To>https://bsestarmfdemo.bseindia.com/MFUploadService/MFUploadService.svc/Secure</wsa:To>
	                </soap:Header>
	                <soap:Body>
	                    <ns:MFAPI>
	                        <ns:Flag>%s</ns:Flag>
	                        <ns:UserId>%s</ns:UserId>
	                        <ns:EncryptedPassword>%s</ns:EncryptedPassword>
	                        <ns:param>%s</ns:param>
	                    </ns:MFAPI>
	                </soap:Body>
	            </soap:Envelope>
	            """
	            .formatted(fatcaDTO.getFlag(), fatcaDTO.getUserId(), fatcaDTO.getEncryptedPassword(), param);

	    // Print or log the SOAP request
	    logger.info("Generated SOAP Request for FATCA:\n{}", soapRequest);
	    // System.out.println("Generated SOAP Request for FATCA:\n" + soapRequest);

	    return soapRequest;
	}


	@Transactional
	public Fatca saveFatca(FatcaDTO fatcaDTO) {
		Fatca fatca = fatcaMapper.mapToEntity(fatcaDTO, null, false); // Create new entity
		return fatcaRepo.save(fatca);
	}

	@Transactional
	public Fatca updateFatcaComplete(Long id, FatcaDTO fatcaDTO) {
		Fatca existingFatca = fatcaRepo.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Fatca entity not found with id: " + id));

		Fatca updatedFatca = fatcaMapper.mapToEntity(fatcaDTO, existingFatca, false);
		return fatcaRepo.save(updatedFatca);
	}

	@Transactional
	public Fatca updateFatcaPartial(Long id, FatcaDTO fatcaDTO) {
		Fatca existingFatca = fatcaRepo.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Fatca entity not found with id: " + id));

		existingFatca = fatcaMapper.mapToEntity(fatcaDTO, existingFatca, true);
		return fatcaRepo.save(existingFatca);
	}
}
