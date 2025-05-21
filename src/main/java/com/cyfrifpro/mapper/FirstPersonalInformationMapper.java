package com.cyfrifpro.mapper;

import org.springframework.stereotype.Component;

import com.cyfrifpro.model.UCC.*;
import com.cyfrifpro.payloads.FirstPersonalInformationDTO;

@Component
public class FirstPersonalInformationMapper {

	
    // Map to Entity with PUT or PATCH logic
    public FirstPersonalInformation mapToEntity(FirstPersonalInformationDTO firstPersonalInformationDTO, FirstPersonalInformation existingFirstPersonalInformation, boolean isPatch) {
        if (existingFirstPersonalInformation == null) {
        	existingFirstPersonalInformation = new FirstPersonalInformation(); // Create a new entity if not present
        }

        // Handle PUT or PATCH based on the isPatch flag
        if (!isPatch) {
            // PUT (Full Update): Set all fields, even if null
        	existingFirstPersonalInformation.setMemberCode(firstPersonalInformationDTO.getMemberCode());
        	existingFirstPersonalInformation.setRegnType(firstPersonalInformationDTO.getRegnType());
        	existingFirstPersonalInformation.setClientCodeUcc(firstPersonalInformationDTO.getClientCodeUcc());
        	existingFirstPersonalInformation.setPrimaryHolderFirstName(firstPersonalInformationDTO.getPrimaryHolderFirstName());
        	existingFirstPersonalInformation.setPrimaryHolderMiddleName(firstPersonalInformationDTO.getPrimaryHolderMiddleName());
        	existingFirstPersonalInformation.setPrimaryHolderLastName(firstPersonalInformationDTO.getPrimaryHolderLastName());
        	existingFirstPersonalInformation.setTaxStatus(firstPersonalInformationDTO.getTaxStatus());
        	existingFirstPersonalInformation.setGender(firstPersonalInformationDTO.getGender());
        	existingFirstPersonalInformation.setPrimaryHolderDobIncorporation(firstPersonalInformationDTO.getPrimaryHolderDobIncorporation());
        	existingFirstPersonalInformation.setOccupationCode(firstPersonalInformationDTO.getOccupationCode());
        	existingFirstPersonalInformation.setHoldingNature(firstPersonalInformationDTO.getHoldingNature());
        	existingFirstPersonalInformation.setSecondHolderFirstName(firstPersonalInformationDTO.getSecondHolderFirstName());
        	existingFirstPersonalInformation.setSecondHolderMiddleName(firstPersonalInformationDTO.getSecondHolderMiddleName());
        	existingFirstPersonalInformation.setSecondHolderLastName(firstPersonalInformationDTO.getSecondHolderLastName());
        	existingFirstPersonalInformation.setThirdHolderFirstName(firstPersonalInformationDTO.getThirdHolderFirstName());
        	existingFirstPersonalInformation.setThirdHolderMiddleName(firstPersonalInformationDTO.getThirdHolderMiddleName());
        	existingFirstPersonalInformation.setThirdHolderLastName(firstPersonalInformationDTO.getThirdHolderLastName());
        	existingFirstPersonalInformation.setSecondHolderDob(firstPersonalInformationDTO.getSecondHolderDob());
        	existingFirstPersonalInformation.setThirdHolderDob(firstPersonalInformationDTO.getThirdHolderDob());
        	existingFirstPersonalInformation.setGuardianFirstName(firstPersonalInformationDTO.getGuardianFirstName());
        	existingFirstPersonalInformation.setGuardianMiddleName(firstPersonalInformationDTO.getGuardianMiddleName());
        	existingFirstPersonalInformation.setGuardianLastName(firstPersonalInformationDTO.getGuardianLastName());
        	existingFirstPersonalInformation.setGuardianDob(firstPersonalInformationDTO.getGuardianDob());
        	existingFirstPersonalInformation.setPrimaryHolderPanExempt(firstPersonalInformationDTO.getPrimaryHolderPanExempt());
        	existingFirstPersonalInformation.setSecondHolderPanExempt(firstPersonalInformationDTO.getSecondHolderPanExempt());
        	existingFirstPersonalInformation.setThirdHolderPanExempt(firstPersonalInformationDTO.getThirdHolderPanExempt());
        	existingFirstPersonalInformation.setGuardianPanExempt(firstPersonalInformationDTO.getGuardianPanExempt());
        	existingFirstPersonalInformation.setPrimaryHolderPan(firstPersonalInformationDTO.getPrimaryHolderPan());
        	existingFirstPersonalInformation.setSecondHolderPan(firstPersonalInformationDTO.getSecondHolderPan());
        	existingFirstPersonalInformation.setThirdHolderPan(firstPersonalInformationDTO.getThirdHolderPan());
        	existingFirstPersonalInformation.setGuardianPan(firstPersonalInformationDTO.getGuardianPan());
        	existingFirstPersonalInformation.setPrimaryHolderExemptCategory(firstPersonalInformationDTO.getPrimaryHolderExemptCategory());
        	existingFirstPersonalInformation.setSecondHolderExemptCategory(firstPersonalInformationDTO.getSecondHolderExemptCategory());
        	existingFirstPersonalInformation.setThirdHolderExemptCategory(firstPersonalInformationDTO.getThirdHolderExemptCategory());
        	existingFirstPersonalInformation.setGuardianExemptCategory(firstPersonalInformationDTO.getGuardianExemptCategory());
        	existingFirstPersonalInformation.setClientType(firstPersonalInformationDTO.getClientType());
        } else {
            // PATCH (Partial Update): Only update non-null fields
        	if (firstPersonalInformationDTO.getMemberCode() != null) existingFirstPersonalInformation.setMemberCode(firstPersonalInformationDTO.getMemberCode());
        	if (firstPersonalInformationDTO.getRegnType() != null) existingFirstPersonalInformation.setRegnType(firstPersonalInformationDTO.getRegnType());
        	if (firstPersonalInformationDTO.getClientCodeUcc() != null) existingFirstPersonalInformation.setClientCodeUcc(firstPersonalInformationDTO.getClientCodeUcc());
        	if (firstPersonalInformationDTO.getPrimaryHolderFirstName() != null) existingFirstPersonalInformation.setPrimaryHolderFirstName(firstPersonalInformationDTO.getPrimaryHolderFirstName());
        	if (firstPersonalInformationDTO.getPrimaryHolderMiddleName() != null) existingFirstPersonalInformation.setPrimaryHolderMiddleName(firstPersonalInformationDTO.getPrimaryHolderMiddleName());
        	if (firstPersonalInformationDTO.getPrimaryHolderLastName() != null) existingFirstPersonalInformation.setPrimaryHolderLastName(firstPersonalInformationDTO.getPrimaryHolderLastName());
        	if (firstPersonalInformationDTO.getTaxStatus() != null) existingFirstPersonalInformation.setTaxStatus(firstPersonalInformationDTO.getTaxStatus());
        	if (firstPersonalInformationDTO.getGender() != null) existingFirstPersonalInformation.setGender(firstPersonalInformationDTO.getGender());
        	if (firstPersonalInformationDTO.getPrimaryHolderDobIncorporation() != null) existingFirstPersonalInformation.setPrimaryHolderDobIncorporation(firstPersonalInformationDTO.getPrimaryHolderDobIncorporation());
        	if (firstPersonalInformationDTO.getOccupationCode() != null) existingFirstPersonalInformation.setOccupationCode(firstPersonalInformationDTO.getOccupationCode());
        	if (firstPersonalInformationDTO.getHoldingNature() != null) existingFirstPersonalInformation.setHoldingNature(firstPersonalInformationDTO.getHoldingNature());
        	if (firstPersonalInformationDTO.getSecondHolderFirstName() != null) existingFirstPersonalInformation.setSecondHolderFirstName(firstPersonalInformationDTO.getSecondHolderFirstName());
        	if (firstPersonalInformationDTO.getSecondHolderMiddleName() != null) existingFirstPersonalInformation.setSecondHolderMiddleName(firstPersonalInformationDTO.getSecondHolderMiddleName());
        	if (firstPersonalInformationDTO.getSecondHolderLastName() != null) existingFirstPersonalInformation.setSecondHolderLastName(firstPersonalInformationDTO.getSecondHolderLastName());
        	if (firstPersonalInformationDTO.getThirdHolderFirstName() != null) existingFirstPersonalInformation.setThirdHolderFirstName(firstPersonalInformationDTO.getThirdHolderFirstName());
        	if (firstPersonalInformationDTO.getThirdHolderMiddleName() != null) existingFirstPersonalInformation.setThirdHolderMiddleName(firstPersonalInformationDTO.getThirdHolderMiddleName());
        	if (firstPersonalInformationDTO.getThirdHolderLastName() != null) existingFirstPersonalInformation.setThirdHolderLastName(firstPersonalInformationDTO.getThirdHolderLastName());
        	if (firstPersonalInformationDTO.getSecondHolderDob() != null) existingFirstPersonalInformation.setSecondHolderDob(firstPersonalInformationDTO.getSecondHolderDob());
        	if (firstPersonalInformationDTO.getThirdHolderDob() != null) existingFirstPersonalInformation.setThirdHolderDob(firstPersonalInformationDTO.getThirdHolderDob());
        	if (firstPersonalInformationDTO.getGuardianFirstName() != null) existingFirstPersonalInformation.setGuardianFirstName(firstPersonalInformationDTO.getGuardianFirstName());
        	if (firstPersonalInformationDTO.getGuardianMiddleName() != null) existingFirstPersonalInformation.setGuardianMiddleName(firstPersonalInformationDTO.getGuardianMiddleName());
        	if (firstPersonalInformationDTO.getGuardianLastName() != null) existingFirstPersonalInformation.setGuardianLastName(firstPersonalInformationDTO.getGuardianLastName());
        	if (firstPersonalInformationDTO.getGuardianDob() != null) existingFirstPersonalInformation.setGuardianDob(firstPersonalInformationDTO.getGuardianDob());
        	if (firstPersonalInformationDTO.getPrimaryHolderPanExempt() != null) existingFirstPersonalInformation.setPrimaryHolderPanExempt(firstPersonalInformationDTO.getPrimaryHolderPanExempt());
        	if (firstPersonalInformationDTO.getSecondHolderPanExempt() != null) existingFirstPersonalInformation.setSecondHolderPanExempt(firstPersonalInformationDTO.getSecondHolderPanExempt());
        	if (firstPersonalInformationDTO.getThirdHolderPanExempt() != null) existingFirstPersonalInformation.setThirdHolderPanExempt(firstPersonalInformationDTO.getThirdHolderPanExempt());
        	if (firstPersonalInformationDTO.getGuardianPanExempt() != null) existingFirstPersonalInformation.setGuardianPanExempt(firstPersonalInformationDTO.getGuardianPanExempt());
        	if (firstPersonalInformationDTO.getPrimaryHolderPan() != null) existingFirstPersonalInformation.setPrimaryHolderPan(firstPersonalInformationDTO.getPrimaryHolderPan());
        	if (firstPersonalInformationDTO.getSecondHolderPan() != null) existingFirstPersonalInformation.setSecondHolderPan(firstPersonalInformationDTO.getSecondHolderPan());
        	if (firstPersonalInformationDTO.getThirdHolderPan() != null) existingFirstPersonalInformation.setThirdHolderPan(firstPersonalInformationDTO.getThirdHolderPan());
        	if (firstPersonalInformationDTO.getGuardianPan() != null) existingFirstPersonalInformation.setGuardianPan(firstPersonalInformationDTO.getGuardianPan());
        	if (firstPersonalInformationDTO.getPrimaryHolderExemptCategory() != null) existingFirstPersonalInformation.setPrimaryHolderExemptCategory(firstPersonalInformationDTO.getPrimaryHolderExemptCategory());
        	if (firstPersonalInformationDTO.getSecondHolderExemptCategory() != null) existingFirstPersonalInformation.setSecondHolderExemptCategory(firstPersonalInformationDTO.getSecondHolderExemptCategory());
        	if (firstPersonalInformationDTO.getThirdHolderExemptCategory() != null) existingFirstPersonalInformation.setThirdHolderExemptCategory(firstPersonalInformationDTO.getThirdHolderExemptCategory());
        	if (firstPersonalInformationDTO.getGuardianExemptCategory() != null) existingFirstPersonalInformation.setGuardianExemptCategory(firstPersonalInformationDTO.getGuardianExemptCategory());
        	if (firstPersonalInformationDTO.getClientType() != null) existingFirstPersonalInformation.setClientType(firstPersonalInformationDTO.getClientType());
        	}

        	existingFirstPersonalInformation.setInvestmentInformations(mapInvestmentInformations(existingFirstPersonalInformation.getInvestmentInformations(), firstPersonalInformationDTO, isPatch));
        	existingFirstPersonalInformation.setBankAccountInformations(mapBankAccountInformations(existingFirstPersonalInformation.getBankAccountInformations(), firstPersonalInformationDTO, isPatch));
        	existingFirstPersonalInformation.setPaymentDividendDetails(mapPaymentDividendDetails(existingFirstPersonalInformation.getPaymentDividendDetails(), firstPersonalInformationDTO, isPatch));
        	existingFirstPersonalInformation.setAddressDetails(mapAddressDetails(existingFirstPersonalInformation.getAddressDetails(), firstPersonalInformationDTO, isPatch));
        	existingFirstPersonalInformation.setContactInformations(mapContactInformations(existingFirstPersonalInformation.getContactInformations(), firstPersonalInformationDTO, isPatch));
        	existingFirstPersonalInformation.setForeignAddressDetails(mapForeignAddressDetails(existingFirstPersonalInformation.getForeignAddressDetails(), firstPersonalInformationDTO, isPatch));
        	existingFirstPersonalInformation.setNomineeInformations(mapNomineeInformations(existingFirstPersonalInformation.getNomineeInformations(), firstPersonalInformationDTO, isPatch));
        	existingFirstPersonalInformation.setKycRegulatoryInformations(mapKycRegulatoryInformations(existingFirstPersonalInformation.getKycRegulatoryInformations(), firstPersonalInformationDTO, isPatch));
        	existingFirstPersonalInformation.setKraAadhaarDetails(mapKraAadhaarDetails(existingFirstPersonalInformation.getKraAadhaarDetails(), firstPersonalInformationDTO, isPatch));
        	existingFirstPersonalInformation.setOtherIdentifiers(mapOtherIdentifiers(existingFirstPersonalInformation.getOtherIdentifiers(), firstPersonalInformationDTO, isPatch));
        	existingFirstPersonalInformation.setDeclarations(mapDeclarations(existingFirstPersonalInformation.getDeclarations(), firstPersonalInformationDTO, isPatch));
        	existingFirstPersonalInformation.setNominationAuthorizations(mapNominationAuthorizations(existingFirstPersonalInformation.getNominationAuthorizations(), firstPersonalInformationDTO, isPatch));
        	existingFirstPersonalInformation.setHoldersContactDetails(mapHoldersContactDetails(existingFirstPersonalInformation.getHoldersContactDetails(), firstPersonalInformationDTO, isPatch));
        	existingFirstPersonalInformation.setGuardianInformations(mapGuardianInformation(existingFirstPersonalInformation.getGuardianInformations(), firstPersonalInformationDTO, isPatch));
        	existingFirstPersonalInformation.setMiscellaneous(mapMiscellaneous(existingFirstPersonalInformation.getMiscellaneous(), firstPersonalInformationDTO, isPatch));

        	return existingFirstPersonalInformation;


    }
    private SecondInvestmentInformation mapInvestmentInformations(SecondInvestmentInformation existingSecondInvestmentInformation, FirstPersonalInformationDTO firstPersonalInformationDTO, boolean isPatch) {
        if (existingSecondInvestmentInformation == null) {
            existingSecondInvestmentInformation = new SecondInvestmentInformation(); // Create a new instance if not present
        }

        if (!isPatch) {
            // PUT: Set all fields, even if null
            existingSecondInvestmentInformation.setPms(firstPersonalInformationDTO.getPms());
            existingSecondInvestmentInformation.setDefaultDp(firstPersonalInformationDTO.getDefaultDp());
            existingSecondInvestmentInformation.setCdsldpid(firstPersonalInformationDTO.getCdsldpid());
            existingSecondInvestmentInformation.setCdsldcltid(firstPersonalInformationDTO.getCdsldcltid());
            existingSecondInvestmentInformation.setCmbpId(firstPersonalInformationDTO.getCmbpId());
            existingSecondInvestmentInformation.setNsdldpid(firstPersonalInformationDTO.getNsdldpid());
            existingSecondInvestmentInformation.setNsdlcltid(firstPersonalInformationDTO.getNsdlcltid());
        } else {
            // PATCH: Update only non-null values
            if (firstPersonalInformationDTO.getPms() != null)
                existingSecondInvestmentInformation.setPms(firstPersonalInformationDTO.getPms());
            if (firstPersonalInformationDTO.getDefaultDp() != null)
                existingSecondInvestmentInformation.setDefaultDp(firstPersonalInformationDTO.getDefaultDp());
            if (firstPersonalInformationDTO.getCdsldpid() != null)
                existingSecondInvestmentInformation.setCdsldpid(firstPersonalInformationDTO.getCdsldpid());
            if (firstPersonalInformationDTO.getCdsldcltid() != null)
                existingSecondInvestmentInformation.setCdsldcltid(firstPersonalInformationDTO.getCdsldcltid());
            if (firstPersonalInformationDTO.getCmbpId() != null)
                existingSecondInvestmentInformation.setCmbpId(firstPersonalInformationDTO.getCmbpId());
            if (firstPersonalInformationDTO.getNsdldpid() != null)
                existingSecondInvestmentInformation.setNsdldpid(firstPersonalInformationDTO.getNsdldpid());
            if (firstPersonalInformationDTO.getNsdlcltid() != null)
                existingSecondInvestmentInformation.setNsdlcltid(firstPersonalInformationDTO.getNsdlcltid());
        }

        return existingSecondInvestmentInformation;
    }

    private ThirdBankAccountInformation mapBankAccountInformations(ThirdBankAccountInformation existingThirdBankAccountInformation, FirstPersonalInformationDTO firstPersonalInformationDTO, boolean isPatch) {
        if (existingThirdBankAccountInformation == null) {
            existingThirdBankAccountInformation = new ThirdBankAccountInformation(); // Create a new instance if not present
        }

        if (!isPatch) {
            // PUT (Full Update): Set all fields, even if null
            existingThirdBankAccountInformation.setAccountType1(firstPersonalInformationDTO.getAccountType1());
            existingThirdBankAccountInformation.setAccountNo1(firstPersonalInformationDTO.getAccountNo1());
            existingThirdBankAccountInformation.setMicrNo1(firstPersonalInformationDTO.getMicrNo1());
            existingThirdBankAccountInformation.setIfscCode1(firstPersonalInformationDTO.getIfscCode1());
            existingThirdBankAccountInformation.setDefaultBankFlag1(firstPersonalInformationDTO.getDefaultBankFlag1());

            existingThirdBankAccountInformation.setAccountType2(firstPersonalInformationDTO.getAccountType2());
            existingThirdBankAccountInformation.setAccountNo2(firstPersonalInformationDTO.getAccountNo2());
            existingThirdBankAccountInformation.setMicrNo2(firstPersonalInformationDTO.getMicrNo2());
            existingThirdBankAccountInformation.setIfscCode2(firstPersonalInformationDTO.getIfscCode2());
            existingThirdBankAccountInformation.setDefaultBankFlag2(firstPersonalInformationDTO.getDefaultBankFlag2());

            existingThirdBankAccountInformation.setAccountType3(firstPersonalInformationDTO.getAccountType3());
            existingThirdBankAccountInformation.setAccountNo3(firstPersonalInformationDTO.getAccountNo3());
            existingThirdBankAccountInformation.setMicrNo3(firstPersonalInformationDTO.getMicrNo3());
            existingThirdBankAccountInformation.setIfscCode3(firstPersonalInformationDTO.getIfscCode3());
            existingThirdBankAccountInformation.setDefaultBankFlag3(firstPersonalInformationDTO.getDefaultBankFlag3());

            existingThirdBankAccountInformation.setAccountType4(firstPersonalInformationDTO.getAccountType4());
            existingThirdBankAccountInformation.setAccountNo4(firstPersonalInformationDTO.getAccountNo4());
            existingThirdBankAccountInformation.setMicrNo4(firstPersonalInformationDTO.getMicrNo4());
            existingThirdBankAccountInformation.setIfscCode4(firstPersonalInformationDTO.getIfscCode4());
            existingThirdBankAccountInformation.setDefaultBankFlag4(firstPersonalInformationDTO.getDefaultBankFlag4());

            existingThirdBankAccountInformation.setAccountType5(firstPersonalInformationDTO.getAccountType5());
            existingThirdBankAccountInformation.setAccountNo5(firstPersonalInformationDTO.getAccountNo5());
            existingThirdBankAccountInformation.setMicrNo5(firstPersonalInformationDTO.getMicrNo5());
            existingThirdBankAccountInformation.setIfscCode5(firstPersonalInformationDTO.getIfscCode5());
            existingThirdBankAccountInformation.setDefaultBankFlag5(firstPersonalInformationDTO.getDefaultBankFlag5());
        } else {
            // PATCH (Partial Update): Only update non-null values
            if (firstPersonalInformationDTO.getAccountType1() != null) existingThirdBankAccountInformation.setAccountType1(firstPersonalInformationDTO.getAccountType1());
            if (firstPersonalInformationDTO.getAccountNo1() != null) existingThirdBankAccountInformation.setAccountNo1(firstPersonalInformationDTO.getAccountNo1());
            if (firstPersonalInformationDTO.getMicrNo1() != null) existingThirdBankAccountInformation.setMicrNo1(firstPersonalInformationDTO.getMicrNo1());
            if (firstPersonalInformationDTO.getIfscCode1() != null) existingThirdBankAccountInformation.setIfscCode1(firstPersonalInformationDTO.getIfscCode1());
            if (firstPersonalInformationDTO.getDefaultBankFlag1() != null) existingThirdBankAccountInformation.setDefaultBankFlag1(firstPersonalInformationDTO.getDefaultBankFlag1());

            if (firstPersonalInformationDTO.getAccountType2() != null) existingThirdBankAccountInformation.setAccountType2(firstPersonalInformationDTO.getAccountType2());
            if (firstPersonalInformationDTO.getAccountNo2() != null) existingThirdBankAccountInformation.setAccountNo2(firstPersonalInformationDTO.getAccountNo2());
            if (firstPersonalInformationDTO.getMicrNo2() != null) existingThirdBankAccountInformation.setMicrNo2(firstPersonalInformationDTO.getMicrNo2());
            if (firstPersonalInformationDTO.getIfscCode2() != null) existingThirdBankAccountInformation.setIfscCode2(firstPersonalInformationDTO.getIfscCode2());
            if (firstPersonalInformationDTO.getDefaultBankFlag2() != null) existingThirdBankAccountInformation.setDefaultBankFlag2(firstPersonalInformationDTO.getDefaultBankFlag2());

            if (firstPersonalInformationDTO.getAccountType3() != null) existingThirdBankAccountInformation.setAccountType3(firstPersonalInformationDTO.getAccountType3());
            if (firstPersonalInformationDTO.getAccountNo3() != null) existingThirdBankAccountInformation.setAccountNo3(firstPersonalInformationDTO.getAccountNo3());
            if (firstPersonalInformationDTO.getMicrNo3() != null) existingThirdBankAccountInformation.setMicrNo3(firstPersonalInformationDTO.getMicrNo3());
            if (firstPersonalInformationDTO.getIfscCode3() != null) existingThirdBankAccountInformation.setIfscCode3(firstPersonalInformationDTO.getIfscCode3());
            if (firstPersonalInformationDTO.getDefaultBankFlag3() != null) existingThirdBankAccountInformation.setDefaultBankFlag3(firstPersonalInformationDTO.getDefaultBankFlag3());

            if (firstPersonalInformationDTO.getAccountType4() != null) existingThirdBankAccountInformation.setAccountType4(firstPersonalInformationDTO.getAccountType4());
            if (firstPersonalInformationDTO.getAccountNo4() != null) existingThirdBankAccountInformation.setAccountNo4(firstPersonalInformationDTO.getAccountNo4());
            if (firstPersonalInformationDTO.getMicrNo4() != null) existingThirdBankAccountInformation.setMicrNo4(firstPersonalInformationDTO.getMicrNo4());
            if (firstPersonalInformationDTO.getIfscCode4() != null) existingThirdBankAccountInformation.setIfscCode4(firstPersonalInformationDTO.getIfscCode4());
            if (firstPersonalInformationDTO.getDefaultBankFlag4() != null) existingThirdBankAccountInformation.setDefaultBankFlag4(firstPersonalInformationDTO.getDefaultBankFlag4());

            if (firstPersonalInformationDTO.getAccountType5() != null) existingThirdBankAccountInformation.setAccountType5(firstPersonalInformationDTO.getAccountType5());
            if (firstPersonalInformationDTO.getAccountNo5() != null) existingThirdBankAccountInformation.setAccountNo5(firstPersonalInformationDTO.getAccountNo5());
            if (firstPersonalInformationDTO.getMicrNo5() != null) existingThirdBankAccountInformation.setMicrNo5(firstPersonalInformationDTO.getMicrNo5());
            if (firstPersonalInformationDTO.getIfscCode5() != null) existingThirdBankAccountInformation.setIfscCode5(firstPersonalInformationDTO.getIfscCode5());
            if (firstPersonalInformationDTO.getDefaultBankFlag5() != null) existingThirdBankAccountInformation.setDefaultBankFlag5(firstPersonalInformationDTO.getDefaultBankFlag5());
        }

        return existingThirdBankAccountInformation;
    }

    private FourthPaymentDividendDetails mapPaymentDividendDetails(FourthPaymentDividendDetails existingFourthPaymentDividendDetails, FirstPersonalInformationDTO firstPersonalInformationDTO, boolean isPatch) {
        if (existingFourthPaymentDividendDetails == null) {
            existingFourthPaymentDividendDetails = new FourthPaymentDividendDetails(); // Create a new instance if not present
        }

        if (!isPatch) {
            // PUT: Set all fields, even if null
            existingFourthPaymentDividendDetails.setChequeName(firstPersonalInformationDTO.getChequeName());
            existingFourthPaymentDividendDetails.setDivPayMode(firstPersonalInformationDTO.getDivPayMode());
        } else {
            // PATCH: Update only non-null values
            if (firstPersonalInformationDTO.getChequeName() != null)
                existingFourthPaymentDividendDetails.setChequeName(firstPersonalInformationDTO.getChequeName());
            if (firstPersonalInformationDTO.getDivPayMode() != null)
                existingFourthPaymentDividendDetails.setDivPayMode(firstPersonalInformationDTO.getDivPayMode());
        }

        return existingFourthPaymentDividendDetails;
    }

    private FifthAddressDetails mapAddressDetails(FifthAddressDetails existingFifthAddressDetails, FirstPersonalInformationDTO firstPersonalInformationDTO, boolean isPatch) {
        if (existingFifthAddressDetails == null) {
            existingFifthAddressDetails = new FifthAddressDetails(); // Create a new instance if not present
        }

        if (!isPatch) {
            // PUT: Set all fields, even if null
            existingFifthAddressDetails.setAddress1(firstPersonalInformationDTO.getAddress1());
            existingFifthAddressDetails.setAddress2(firstPersonalInformationDTO.getAddress2());
            existingFifthAddressDetails.setAddress3(firstPersonalInformationDTO.getAddress3());
            existingFifthAddressDetails.setCity(firstPersonalInformationDTO.getCity());
            existingFifthAddressDetails.setState(firstPersonalInformationDTO.getState());
            existingFifthAddressDetails.setPincode(firstPersonalInformationDTO.getPincode());
            existingFifthAddressDetails.setCountry(firstPersonalInformationDTO.getCountry());
        } else {
            // PATCH: Update only non-null values
            if (firstPersonalInformationDTO.getAddress1() != null)
                existingFifthAddressDetails.setAddress1(firstPersonalInformationDTO.getAddress1());
            if (firstPersonalInformationDTO.getAddress2() != null)
                existingFifthAddressDetails.setAddress2(firstPersonalInformationDTO.getAddress2());
            if (firstPersonalInformationDTO.getAddress3() != null)
                existingFifthAddressDetails.setAddress3(firstPersonalInformationDTO.getAddress3());
            if (firstPersonalInformationDTO.getCity() != null)
                existingFifthAddressDetails.setCity(firstPersonalInformationDTO.getCity());
            if (firstPersonalInformationDTO.getState() != null)
                existingFifthAddressDetails.setState(firstPersonalInformationDTO.getState());
            if (firstPersonalInformationDTO.getPincode() != null)
                existingFifthAddressDetails.setPincode(firstPersonalInformationDTO.getPincode());
            if (firstPersonalInformationDTO.getCountry() != null)
                existingFifthAddressDetails.setCountry(firstPersonalInformationDTO.getCountry());
        }

        return existingFifthAddressDetails;
    }

    private SixthContactInformation mapContactInformations(SixthContactInformation existingSixthContactInformation, FirstPersonalInformationDTO firstPersonalInformationDTO, boolean isPatch) {
        if (existingSixthContactInformation == null) {
            existingSixthContactInformation = new SixthContactInformation(); // Create a new instance if not present
        }

        if (!isPatch) {
            // PUT: Set all fields, even if null
            existingSixthContactInformation.setResiPhone(firstPersonalInformationDTO.getResiPhone());
            existingSixthContactInformation.setResiFax(firstPersonalInformationDTO.getResiFax());
            existingSixthContactInformation.setOfficePhone(firstPersonalInformationDTO.getOfficePhone());
            existingSixthContactInformation.setOfficeFax(firstPersonalInformationDTO.getOfficeFax());
            existingSixthContactInformation.setEmail(firstPersonalInformationDTO.getEmail());
            existingSixthContactInformation.setCommunicationMode(firstPersonalInformationDTO.getCommunicationMode());
        } else {
            // PATCH: Update only non-null values
            if (firstPersonalInformationDTO.getResiPhone() != null)
                existingSixthContactInformation.setResiPhone(firstPersonalInformationDTO.getResiPhone());
            if (firstPersonalInformationDTO.getResiFax() != null)
                existingSixthContactInformation.setResiFax(firstPersonalInformationDTO.getResiFax());
            if (firstPersonalInformationDTO.getOfficePhone() != null)
                existingSixthContactInformation.setOfficePhone(firstPersonalInformationDTO.getOfficePhone());
            if (firstPersonalInformationDTO.getOfficeFax() != null)
                existingSixthContactInformation.setOfficeFax(firstPersonalInformationDTO.getOfficeFax());
            if (firstPersonalInformationDTO.getEmail() != null)
                existingSixthContactInformation.setEmail(firstPersonalInformationDTO.getEmail());
            if (firstPersonalInformationDTO.getCommunicationMode() != null)
                existingSixthContactInformation.setCommunicationMode(firstPersonalInformationDTO.getCommunicationMode());
        }

        return existingSixthContactInformation;
    }

    private SeventhForeignAddressDetails mapForeignAddressDetails(SeventhForeignAddressDetails existingSeventhForeignAddressDetails, FirstPersonalInformationDTO firstPersonalInformationDTO, boolean isPatch) {
        if (existingSeventhForeignAddressDetails == null) {
            existingSeventhForeignAddressDetails = new SeventhForeignAddressDetails(); // Create a new instance if not present
        }

        if (!isPatch) {
            // PUT: Set all fields, even if null
            existingSeventhForeignAddressDetails.setForeignAddress1(firstPersonalInformationDTO.getForeignAddress1());
            existingSeventhForeignAddressDetails.setForeignAddress2(firstPersonalInformationDTO.getForeignAddress2());
            existingSeventhForeignAddressDetails.setForeignAddress3(firstPersonalInformationDTO.getForeignAddress3());
            existingSeventhForeignAddressDetails.setForeignAddressCity(firstPersonalInformationDTO.getForeignAddressCity());
            existingSeventhForeignAddressDetails.setForeignAddressPincode(firstPersonalInformationDTO.getForeignAddressPincode());
            existingSeventhForeignAddressDetails.setForeignAddressState(firstPersonalInformationDTO.getForeignAddressState());
            existingSeventhForeignAddressDetails.setForeignAddressCountry(firstPersonalInformationDTO.getForeignAddressCountry());
            existingSeventhForeignAddressDetails.setForeignAddressResiPhone(firstPersonalInformationDTO.getForeignAddressResiPhone());
            existingSeventhForeignAddressDetails.setForeignAddressFax(firstPersonalInformationDTO.getForeignAddressFax());
            existingSeventhForeignAddressDetails.setForeignAddressOffPhone(firstPersonalInformationDTO.getForeignAddressOffPhone());
            existingSeventhForeignAddressDetails.setForeignAddressOffFax(firstPersonalInformationDTO.getForeignAddressOffFax());
            existingSeventhForeignAddressDetails.setIndianMobileNo(firstPersonalInformationDTO.getIndianMobileNo());
        } else {
            // PATCH: Update only non-null values
            if (firstPersonalInformationDTO.getForeignAddress1() != null)
                existingSeventhForeignAddressDetails.setForeignAddress1(firstPersonalInformationDTO.getForeignAddress1());
            if (firstPersonalInformationDTO.getForeignAddress2() != null)
                existingSeventhForeignAddressDetails.setForeignAddress2(firstPersonalInformationDTO.getForeignAddress2());
            if (firstPersonalInformationDTO.getForeignAddress3() != null)
                existingSeventhForeignAddressDetails.setForeignAddress3(firstPersonalInformationDTO.getForeignAddress3());
            if (firstPersonalInformationDTO.getForeignAddressCity() != null)
                existingSeventhForeignAddressDetails.setForeignAddressCity(firstPersonalInformationDTO.getForeignAddressCity());
            if (firstPersonalInformationDTO.getForeignAddressPincode() != null)
                existingSeventhForeignAddressDetails.setForeignAddressPincode(firstPersonalInformationDTO.getForeignAddressPincode());
            if (firstPersonalInformationDTO.getForeignAddressState() != null)
                existingSeventhForeignAddressDetails.setForeignAddressState(firstPersonalInformationDTO.getForeignAddressState());
            if (firstPersonalInformationDTO.getForeignAddressCountry() != null)
                existingSeventhForeignAddressDetails.setForeignAddressCountry(firstPersonalInformationDTO.getForeignAddressCountry());
            if (firstPersonalInformationDTO.getForeignAddressResiPhone() != null)
                existingSeventhForeignAddressDetails.setForeignAddressResiPhone(firstPersonalInformationDTO.getForeignAddressResiPhone());
            if (firstPersonalInformationDTO.getForeignAddressFax() != null)
                existingSeventhForeignAddressDetails.setForeignAddressFax(firstPersonalInformationDTO.getForeignAddressFax());
            if (firstPersonalInformationDTO.getForeignAddressOffPhone() != null)
                existingSeventhForeignAddressDetails.setForeignAddressOffPhone(firstPersonalInformationDTO.getForeignAddressOffPhone());
            if (firstPersonalInformationDTO.getForeignAddressOffFax() != null)
                existingSeventhForeignAddressDetails.setForeignAddressOffFax(firstPersonalInformationDTO.getForeignAddressOffFax());
            if (firstPersonalInformationDTO.getIndianMobileNo() != null)
                existingSeventhForeignAddressDetails.setIndianMobileNo(firstPersonalInformationDTO.getIndianMobileNo());
        }

        return existingSeventhForeignAddressDetails;
    }

    private EighthNomineeInformation mapNomineeInformations(EighthNomineeInformation existingNomineeInfo, FirstPersonalInformationDTO firstPersonalInformationDTO, boolean isPatch) {
        if (existingNomineeInfo == null) {
            existingNomineeInfo = new EighthNomineeInformation(); // Create a new instance if not present
        }

        if (!isPatch) {
            // PUT: Set all fields, even if null
            existingNomineeInfo.setNominee1Name(firstPersonalInformationDTO.getNominee1Name());
            existingNomineeInfo.setNominee1Relationship(firstPersonalInformationDTO.getNominee1Relationship());
            existingNomineeInfo.setNominee1ApplicablePercent(firstPersonalInformationDTO.getNominee1ApplicablePercent());
            existingNomineeInfo.setNominee1MinorFlag(firstPersonalInformationDTO.getNominee1MinorFlag());
            existingNomineeInfo.setNominee1Dob(firstPersonalInformationDTO.getNominee1Dob());
            existingNomineeInfo.setNominee1Guardian(firstPersonalInformationDTO.getNominee1Guardian());
            
            existingNomineeInfo.setNominee2Name(firstPersonalInformationDTO.getNominee2Name());
            existingNomineeInfo.setNominee2Relationship(firstPersonalInformationDTO.getNominee2Relationship());
            existingNomineeInfo.setNominee2ApplicablePercent(firstPersonalInformationDTO.getNominee2ApplicablePercent());
            existingNomineeInfo.setNominee2Dob(firstPersonalInformationDTO.getNominee2Dob());
            existingNomineeInfo.setNominee2MinorFlag(firstPersonalInformationDTO.getNominee2MinorFlag());
            existingNomineeInfo.setNominee2Guardian(firstPersonalInformationDTO.getNominee2Guardian());
            
            existingNomineeInfo.setNominee3Name(firstPersonalInformationDTO.getNominee3Name());
            existingNomineeInfo.setNominee3Relationship(firstPersonalInformationDTO.getNominee3Relationship());
            existingNomineeInfo.setNominee3ApplicablePercent(firstPersonalInformationDTO.getNominee3ApplicablePercent());
            existingNomineeInfo.setNominee3Dob(firstPersonalInformationDTO.getNominee3Dob());
            existingNomineeInfo.setNominee3MinorFlag(firstPersonalInformationDTO.getNominee3MinorFlag());
            existingNomineeInfo.setNominee3Guardian(firstPersonalInformationDTO.getNominee3Guardian());
        } else {
            // PATCH: Update only non-null values
            if (firstPersonalInformationDTO.getNominee1Name() != null)
                existingNomineeInfo.setNominee1Name(firstPersonalInformationDTO.getNominee1Name());
            if (firstPersonalInformationDTO.getNominee1Relationship() != null)
                existingNomineeInfo.setNominee1Relationship(firstPersonalInformationDTO.getNominee1Relationship());
            if (firstPersonalInformationDTO.getNominee1ApplicablePercent() != null)
                existingNomineeInfo.setNominee1ApplicablePercent(firstPersonalInformationDTO.getNominee1ApplicablePercent());
            if (firstPersonalInformationDTO.getNominee1MinorFlag() != null)
                existingNomineeInfo.setNominee1MinorFlag(firstPersonalInformationDTO.getNominee1MinorFlag());
            if (firstPersonalInformationDTO.getNominee1Dob() != null)
                existingNomineeInfo.setNominee1Dob(firstPersonalInformationDTO.getNominee1Dob());
            if (firstPersonalInformationDTO.getNominee1Guardian() != null)
                existingNomineeInfo.setNominee1Guardian(firstPersonalInformationDTO.getNominee1Guardian());

            if (firstPersonalInformationDTO.getNominee2Name() != null)
                existingNomineeInfo.setNominee2Name(firstPersonalInformationDTO.getNominee2Name());
            if (firstPersonalInformationDTO.getNominee2Relationship() != null)
                existingNomineeInfo.setNominee2Relationship(firstPersonalInformationDTO.getNominee2Relationship());
            if (firstPersonalInformationDTO.getNominee2ApplicablePercent() != null)
                existingNomineeInfo.setNominee2ApplicablePercent(firstPersonalInformationDTO.getNominee2ApplicablePercent());
            if (firstPersonalInformationDTO.getNominee2Dob() != null)
                existingNomineeInfo.setNominee2Dob(firstPersonalInformationDTO.getNominee2Dob());
            if (firstPersonalInformationDTO.getNominee2MinorFlag() != null)
                existingNomineeInfo.setNominee2MinorFlag(firstPersonalInformationDTO.getNominee2MinorFlag());
            if (firstPersonalInformationDTO.getNominee2Guardian() != null)
                existingNomineeInfo.setNominee2Guardian(firstPersonalInformationDTO.getNominee2Guardian());

            if (firstPersonalInformationDTO.getNominee3Name() != null)
                existingNomineeInfo.setNominee3Name(firstPersonalInformationDTO.getNominee3Name());
            if (firstPersonalInformationDTO.getNominee3Relationship() != null)
                existingNomineeInfo.setNominee3Relationship(firstPersonalInformationDTO.getNominee3Relationship());
            if (firstPersonalInformationDTO.getNominee3ApplicablePercent() != null)
                existingNomineeInfo.setNominee3ApplicablePercent(firstPersonalInformationDTO.getNominee3ApplicablePercent());
            if (firstPersonalInformationDTO.getNominee3Dob() != null)
                existingNomineeInfo.setNominee3Dob(firstPersonalInformationDTO.getNominee3Dob());
            if (firstPersonalInformationDTO.getNominee3MinorFlag() != null)
                existingNomineeInfo.setNominee3MinorFlag(firstPersonalInformationDTO.getNominee3MinorFlag());
            if (firstPersonalInformationDTO.getNominee3Guardian() != null)
                existingNomineeInfo.setNominee3Guardian(firstPersonalInformationDTO.getNominee3Guardian());
        }

        return existingNomineeInfo;
    }

    private NinethKycRegulatoryInformation mapKycRegulatoryInformations(NinethKycRegulatoryInformation existingKycRegulatoryInfo, FirstPersonalInformationDTO firstPersonalInformationDTO, boolean isPatch) {
        if (existingKycRegulatoryInfo == null) {
            existingKycRegulatoryInfo = new NinethKycRegulatoryInformation(); // Create a new instance if not present
        }

        if (!isPatch) {
            // PUT: Set all fields, even if null
            existingKycRegulatoryInfo.setPrimaryHolderKycType(firstPersonalInformationDTO.getPrimaryHolderKycType());
            existingKycRegulatoryInfo.setPrimaryHolderCkycNumber(firstPersonalInformationDTO.getPrimaryHolderCkycNumber());
            existingKycRegulatoryInfo.setSecondHolderKycType(firstPersonalInformationDTO.getSecondHolderKycType());
            existingKycRegulatoryInfo.setSecondHolderCkycNumber(firstPersonalInformationDTO.getSecondHolderCkycNumber());
            existingKycRegulatoryInfo.setThirdHolderKycType(firstPersonalInformationDTO.getThirdHolderKycType());
            existingKycRegulatoryInfo.setThirdHolderCkycNumber(firstPersonalInformationDTO.getThirdHolderCkycNumber());
            existingKycRegulatoryInfo.setGuardianKycType(firstPersonalInformationDTO.getGuardianKycType());
            existingKycRegulatoryInfo.setGuardianCkycNumber(firstPersonalInformationDTO.getGuardianCkycNumber());
        } else {
            // PATCH: Update only non-null values
            if (firstPersonalInformationDTO.getPrimaryHolderKycType() != null)
                existingKycRegulatoryInfo.setPrimaryHolderKycType(firstPersonalInformationDTO.getPrimaryHolderKycType());
            if (firstPersonalInformationDTO.getPrimaryHolderCkycNumber() != null)
                existingKycRegulatoryInfo.setPrimaryHolderCkycNumber(firstPersonalInformationDTO.getPrimaryHolderCkycNumber());
            if (firstPersonalInformationDTO.getSecondHolderKycType() != null)
                existingKycRegulatoryInfo.setSecondHolderKycType(firstPersonalInformationDTO.getSecondHolderKycType());
            if (firstPersonalInformationDTO.getSecondHolderCkycNumber() != null)
                existingKycRegulatoryInfo.setSecondHolderCkycNumber(firstPersonalInformationDTO.getSecondHolderCkycNumber());
            if (firstPersonalInformationDTO.getThirdHolderKycType() != null)
                existingKycRegulatoryInfo.setThirdHolderKycType(firstPersonalInformationDTO.getThirdHolderKycType());
            if (firstPersonalInformationDTO.getThirdHolderCkycNumber() != null)
                existingKycRegulatoryInfo.setThirdHolderCkycNumber(firstPersonalInformationDTO.getThirdHolderCkycNumber());
            if (firstPersonalInformationDTO.getGuardianKycType() != null)
                existingKycRegulatoryInfo.setGuardianKycType(firstPersonalInformationDTO.getGuardianKycType());
            if (firstPersonalInformationDTO.getGuardianCkycNumber() != null)
                existingKycRegulatoryInfo.setGuardianCkycNumber(firstPersonalInformationDTO.getGuardianCkycNumber());
        }

        return existingKycRegulatoryInfo;
    }


    private TenthKraAadhaarDetails mapKraAadhaarDetails(TenthKraAadhaarDetails existingKraAadhaarDetails, FirstPersonalInformationDTO firstPersonalInformationDTO, boolean isPatch) {
        if (existingKraAadhaarDetails == null) {
            existingKraAadhaarDetails = new TenthKraAadhaarDetails(); // Create a new instance if not present
        }

        if (!isPatch) {
            // PUT: Set all fields, even if null
            existingKraAadhaarDetails.setPrimaryHolderKraExemptRefNo(firstPersonalInformationDTO.getPrimaryHolderKraExemptRefNo());
            existingKraAadhaarDetails.setSecondHolderKraExemptRefNo(firstPersonalInformationDTO.getSecondHolderKraExemptRefNo());
            existingKraAadhaarDetails.setThirdHolderKraExemptRefNo(firstPersonalInformationDTO.getThirdHolderKraExemptRefNo());
            existingKraAadhaarDetails.setGuardianExemptRefNo(firstPersonalInformationDTO.getGuardianExemptRefNo());
            existingKraAadhaarDetails.setAadhaarUpdated(firstPersonalInformationDTO.getAadhaarUpdated());
        } else {
            // PATCH: Update only non-null values
            if (firstPersonalInformationDTO.getPrimaryHolderKraExemptRefNo() != null)
                existingKraAadhaarDetails.setPrimaryHolderKraExemptRefNo(firstPersonalInformationDTO.getPrimaryHolderKraExemptRefNo());
            if (firstPersonalInformationDTO.getSecondHolderKraExemptRefNo() != null)
                existingKraAadhaarDetails.setSecondHolderKraExemptRefNo(firstPersonalInformationDTO.getSecondHolderKraExemptRefNo());
            if (firstPersonalInformationDTO.getThirdHolderKraExemptRefNo() != null)
                existingKraAadhaarDetails.setThirdHolderKraExemptRefNo(firstPersonalInformationDTO.getThirdHolderKraExemptRefNo());
            if (firstPersonalInformationDTO.getGuardianExemptRefNo() != null)
                existingKraAadhaarDetails.setGuardianExemptRefNo(firstPersonalInformationDTO.getGuardianExemptRefNo());
            if (firstPersonalInformationDTO.getAadhaarUpdated() != null)
                existingKraAadhaarDetails.setAadhaarUpdated(firstPersonalInformationDTO.getAadhaarUpdated());
        }

        return existingKraAadhaarDetails;
    }

    private ElleventhOtherIdentifiers mapOtherIdentifiers(ElleventhOtherIdentifiers existingOtherIdentifiers, FirstPersonalInformationDTO firstPersonalInformationDTO, boolean isPatch) {
        if (existingOtherIdentifiers == null) {
            existingOtherIdentifiers = new ElleventhOtherIdentifiers(); // Create a new instance if not present
        }

        if (!isPatch) {
            // PUT: Set all fields, even if null
            existingOtherIdentifiers.setMapinId(firstPersonalInformationDTO.getMapinId());
            existingOtherIdentifiers.setPaperlessFlag(firstPersonalInformationDTO.getPaperlessFlag());
            existingOtherIdentifiers.setLeiNo(firstPersonalInformationDTO.getLeiNo());
            existingOtherIdentifiers.setLeiValidity(firstPersonalInformationDTO.getLeiValidity());
        } else {
            // PATCH: Update only non-null values
            if (firstPersonalInformationDTO.getMapinId() != null)
                existingOtherIdentifiers.setMapinId(firstPersonalInformationDTO.getMapinId());
            if (firstPersonalInformationDTO.getPaperlessFlag() != null)
                existingOtherIdentifiers.setPaperlessFlag(firstPersonalInformationDTO.getPaperlessFlag());
            if (firstPersonalInformationDTO.getLeiNo() != null)
                existingOtherIdentifiers.setLeiNo(firstPersonalInformationDTO.getLeiNo());
            if (firstPersonalInformationDTO.getLeiValidity() != null)
                existingOtherIdentifiers.setLeiValidity(firstPersonalInformationDTO.getLeiValidity());
        }

        return existingOtherIdentifiers;
    }

    private TwelethDeclarations mapDeclarations(TwelethDeclarations existingDeclarations, FirstPersonalInformationDTO firstPersonalInformationDTO, boolean isPatch) {
        if (existingDeclarations == null) {
            existingDeclarations = new TwelethDeclarations(); // Create a new instance if not present
        }

        if (!isPatch) {
            // PUT: Set all fields, even if null
            existingDeclarations.setFiller1MobileDeclarationFlag(firstPersonalInformationDTO.getFiller1MobileDeclarationFlag());
            existingDeclarations.setFiller2EmailDeclarationFlag(firstPersonalInformationDTO.getFiller2EmailDeclarationFlag());
        } else {
            // PATCH: Update only non-null values
            if (firstPersonalInformationDTO.getFiller1MobileDeclarationFlag() != null)
                existingDeclarations.setFiller1MobileDeclarationFlag(firstPersonalInformationDTO.getFiller1MobileDeclarationFlag());
            if (firstPersonalInformationDTO.getFiller2EmailDeclarationFlag() != null)
                existingDeclarations.setFiller2EmailDeclarationFlag(firstPersonalInformationDTO.getFiller2EmailDeclarationFlag());
        }

        return existingDeclarations;
    }

    private ThirteenthNominationAuthorization mapNominationAuthorizations(ThirteenthNominationAuthorization existingNominationAuth, FirstPersonalInformationDTO firstPersonalInformationDTO, boolean isPatch) {
        if (existingNominationAuth == null) {
            existingNominationAuth = new ThirteenthNominationAuthorization(); // Create a new instance if not present
        }

        if (!isPatch) {
            // PUT: Set all fields, even if null
            existingNominationAuth.setNominationOpt(firstPersonalInformationDTO.getNominationOpt());
            existingNominationAuth.setNominationAuthMode(firstPersonalInformationDTO.getNominationAuthMode());
            existingNominationAuth.setNomineePan1(firstPersonalInformationDTO.getNomineePan1());
            existingNominationAuth.setNomineeGuardianPan1(firstPersonalInformationDTO.getNomineeGuardianPan1());
            existingNominationAuth.setNomineePan2(firstPersonalInformationDTO.getNomineePan2());
            existingNominationAuth.setNomineeGuardianPan2(firstPersonalInformationDTO.getNomineeGuardianPan2());
            existingNominationAuth.setNomineePan3(firstPersonalInformationDTO.getNomineePan3());
            existingNominationAuth.setNomineeGuardianPan3(firstPersonalInformationDTO.getNomineeGuardianPan3());
        } else {
            // PATCH: Update only non-null values
            if (firstPersonalInformationDTO.getNominationOpt() != null)
                existingNominationAuth.setNominationOpt(firstPersonalInformationDTO.getNominationOpt());
            if (firstPersonalInformationDTO.getNominationAuthMode() != null)
                existingNominationAuth.setNominationAuthMode(firstPersonalInformationDTO.getNominationAuthMode());
            if (firstPersonalInformationDTO.getNomineePan1() != null)
                existingNominationAuth.setNomineePan1(firstPersonalInformationDTO.getNomineePan1());
            if (firstPersonalInformationDTO.getNomineeGuardianPan1() != null)
                existingNominationAuth.setNomineeGuardianPan1(firstPersonalInformationDTO.getNomineeGuardianPan1());
            if (firstPersonalInformationDTO.getNomineePan2() != null)
                existingNominationAuth.setNomineePan2(firstPersonalInformationDTO.getNomineePan2());
            if (firstPersonalInformationDTO.getNomineeGuardianPan2() != null)
                existingNominationAuth.setNomineeGuardianPan2(firstPersonalInformationDTO.getNomineeGuardianPan2());
            if (firstPersonalInformationDTO.getNomineePan3() != null)
                existingNominationAuth.setNomineePan3(firstPersonalInformationDTO.getNomineePan3());
            if (firstPersonalInformationDTO.getNomineeGuardianPan3() != null)
                existingNominationAuth.setNomineeGuardianPan3(firstPersonalInformationDTO.getNomineeGuardianPan3());
        }

        return existingNominationAuth;
    }

    private FourteenthHoldersContactDetails mapHoldersContactDetails(FourteenthHoldersContactDetails existingHoldersContactDetails, FirstPersonalInformationDTO firstPersonalInformationDTO, boolean isPatch) {
        if (existingHoldersContactDetails == null) {
            existingHoldersContactDetails = new FourteenthHoldersContactDetails(); // Create a new instance if not present
        }

        if (!isPatch) {
            // PUT: Set all fields, even if null
            existingHoldersContactDetails.setSecondHolderEmail(firstPersonalInformationDTO.getSecondHolderEmail());
            existingHoldersContactDetails.setSecondHolderEmailDeclaration(firstPersonalInformationDTO.getSecondHolderEmailDeclaration());
            existingHoldersContactDetails.setSecondHolderMobileNo(firstPersonalInformationDTO.getSecondHolderMobileNo());
            existingHoldersContactDetails.setSecondHolderMobileNoDeclaration(firstPersonalInformationDTO.getSecondHolderMobileNoDeclaration());
            existingHoldersContactDetails.setThirdHolderEmail(firstPersonalInformationDTO.getThirdHolderEmail());
            existingHoldersContactDetails.setThirdHolderEmailDeclaration(firstPersonalInformationDTO.getThirdHolderEmailDeclaration());
            existingHoldersContactDetails.setThirdHolderMobileNo(firstPersonalInformationDTO.getThirdHolderMobileNo());
            existingHoldersContactDetails.setThirdHolderMobileNoDeclaration(firstPersonalInformationDTO.getThirdHolderMobileNoDeclaration());
        } else {
            // PATCH: Update only non-null values
            if (firstPersonalInformationDTO.getSecondHolderEmail() != null)
                existingHoldersContactDetails.setSecondHolderEmail(firstPersonalInformationDTO.getSecondHolderEmail());
            if (firstPersonalInformationDTO.getSecondHolderEmailDeclaration() != null)
                existingHoldersContactDetails.setSecondHolderEmailDeclaration(firstPersonalInformationDTO.getSecondHolderEmailDeclaration());
            if (firstPersonalInformationDTO.getSecondHolderMobileNo() != null)
                existingHoldersContactDetails.setSecondHolderMobileNo(firstPersonalInformationDTO.getSecondHolderMobileNo());
            if (firstPersonalInformationDTO.getSecondHolderMobileNoDeclaration() != null)
                existingHoldersContactDetails.setSecondHolderMobileNoDeclaration(firstPersonalInformationDTO.getSecondHolderMobileNoDeclaration());
            if (firstPersonalInformationDTO.getThirdHolderEmail() != null)
                existingHoldersContactDetails.setThirdHolderEmail(firstPersonalInformationDTO.getThirdHolderEmail());
            if (firstPersonalInformationDTO.getThirdHolderEmailDeclaration() != null)
                existingHoldersContactDetails.setThirdHolderEmailDeclaration(firstPersonalInformationDTO.getThirdHolderEmailDeclaration());
            if (firstPersonalInformationDTO.getThirdHolderMobileNo() != null)
                existingHoldersContactDetails.setThirdHolderMobileNo(firstPersonalInformationDTO.getThirdHolderMobileNo());
            if (firstPersonalInformationDTO.getThirdHolderMobileNoDeclaration() != null)
                existingHoldersContactDetails.setThirdHolderMobileNoDeclaration(firstPersonalInformationDTO.getThirdHolderMobileNoDeclaration());
        }

        return existingHoldersContactDetails;
    }

    private FifteenthGuardianInformation mapGuardianInformation(FifteenthGuardianInformation existingGuardianInformation, FirstPersonalInformationDTO firstPersonalInformationDTO, boolean isPatch) {
        if (existingGuardianInformation == null) {
            existingGuardianInformation = new FifteenthGuardianInformation(); // Create a new instance if not present
        }

        if (!isPatch) {
            // PUT: Set all fields, even if null
            existingGuardianInformation.setGuardianRelationship(firstPersonalInformationDTO.getGuardianRelationship());
        } else {
            // PATCH: Update only non-null values
            if (firstPersonalInformationDTO.getGuardianRelationship() != null)
                existingGuardianInformation.setGuardianRelationship(firstPersonalInformationDTO.getGuardianRelationship());
        }

        return existingGuardianInformation;
    }

    private SixteenthMiscellaneous mapMiscellaneous(SixteenthMiscellaneous existingMiscellaneous, FirstPersonalInformationDTO firstPersonalInformationDTO, boolean isPatch) {
        if (existingMiscellaneous == null) {
            existingMiscellaneous = new SixteenthMiscellaneous(); // Create a new instance if not present
        }

        if (!isPatch) {
            // PUT: Set all fields, even if null
            existingMiscellaneous.setFiller1(firstPersonalInformationDTO.getFiller1());
            existingMiscellaneous.setFiller2(firstPersonalInformationDTO.getFiller2());
            existingMiscellaneous.setFiller3(firstPersonalInformationDTO.getFiller3());
        } else {
            // PATCH: Update only non-null values
            if (firstPersonalInformationDTO.getFiller1() != null)
                existingMiscellaneous.setFiller1(firstPersonalInformationDTO.getFiller1());
            if (firstPersonalInformationDTO.getFiller2() != null)
                existingMiscellaneous.setFiller2(firstPersonalInformationDTO.getFiller2());
            if (firstPersonalInformationDTO.getFiller3() != null)
                existingMiscellaneous.setFiller3(firstPersonalInformationDTO.getFiller3());
        }

        return existingMiscellaneous;
    }
    
}
