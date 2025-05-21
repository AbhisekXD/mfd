package com.cyfrifpro.services;

import java.util.List;
import java.util.Optional;

import com.cyfrifpro.model.UCC.FirstPersonalInformation;
import com.cyfrifpro.payloads.FirstPersonalInformationDTO;

import jakarta.validation.Valid;

public interface FirstPersonalInformationService {

	String generateParamString(FirstPersonalInformationDTO FirstPersonalInformationDTO);

	public List<FirstPersonalInformation> getAllData();

	// Method to find by ID
	public Optional<FirstPersonalInformation> getById(Long id);

	// Method to find by clientCodeUcc
	public Optional<FirstPersonalInformation> getByClientCodeUcc(String clientCodeUcc);

	public FirstPersonalInformation updateFirstPersonalInformationComplete(Long id,
			FirstPersonalInformationDTO firstPersonalInformationDTO);

	public FirstPersonalInformation updateFirstPersonalInformationPartial(Long id,
			FirstPersonalInformationDTO firstPersonalInformationDTO);

	public FirstPersonalInformation saveFirstPersonalInformation(
			FirstPersonalInformationDTO firstPersonalInformationDTO);

	boolean updatePersonalInformationByClientCodeUcc(String clientCodeUcc,
			@Valid FirstPersonalInformationDTO firstPersonalInformationDTO);

	boolean savePersonalInformationIfValid(@Valid FirstPersonalInformationDTO firstPersonalInformationDTO);

	List<FirstPersonalInformation> getAllUsers();

}
