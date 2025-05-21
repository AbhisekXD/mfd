package com.cyfrifpro.mapper;

import com.cyfrifpro.model.FATCA.*;
import com.cyfrifpro.payloads.FatcaDTO;

import org.springframework.stereotype.Component;

@Component
public class FatcaMapper {


	public Fatca mapToEntity(FatcaDTO fatcaDTO, Fatca existingFatca, boolean isPatch) {
		if (existingFatca == null) {
			existingFatca = new Fatca(); // If it's a new entity, create a new one
		}

		// Handle PUT or PATCH based on the isPatch flag
		if (!isPatch) {
			// PUT (Full Update): Set all fields, even if null
			existingFatca.setPanRp(fatcaDTO.getPanRp());
			existingFatca.setPekrn(fatcaDTO.getPekrn());
			existingFatca.setInvName(fatcaDTO.getInvName());
			existingFatca.setDob(fatcaDTO.getDob());
			existingFatca.setFrName(fatcaDTO.getFrName());
			existingFatca.setSpName(fatcaDTO.getSpName());
		} else {
			// PATCH (Partial Update): Only update non-null fields
			if (fatcaDTO.getPanRp() != null)
				existingFatca.setPanRp(fatcaDTO.getPanRp());
			if (fatcaDTO.getPekrn() != null)
				existingFatca.setPekrn(fatcaDTO.getPekrn());
			if (fatcaDTO.getInvName() != null)
				existingFatca.setInvName(fatcaDTO.getInvName());
			if (fatcaDTO.getDob() != null)
				existingFatca.setDob(fatcaDTO.getDob());
			if (fatcaDTO.getFrName() != null)
				existingFatca.setFrName(fatcaDTO.getFrName());
			if (fatcaDTO.getSpName() != null)
				existingFatca.setSpName(fatcaDTO.getSpName());
		}

		// Handle nested entities in a similar way
		existingFatca.setTaxInfo(mapTaxInfo(existingFatca.getTaxInfo(), fatcaDTO, isPatch));
		existingFatca.setWealthInfo(mapWealthInfo(existingFatca.getWealthInfo(), fatcaDTO, isPatch));
		existingFatca.setPepFlag(mapPepFlag(existingFatca.getPepFlag(), fatcaDTO, isPatch));
		existingFatca
				.setOccupationDetails(mapOccupationDetails(existingFatca.getOccupationDetails(), fatcaDTO, isPatch));
		existingFatca.setNonIndividualDetails(
				mapNonIndividualDetails(existingFatca.getNonIndividualDetails(), fatcaDTO, isPatch));
		existingFatca.setSponsoringEntityDetails(
				mapSponsoringEntityDetails(existingFatca.getSponsoringEntityDetails(), fatcaDTO, isPatch));
		existingFatca
				.setNffeClassification(mapNffeClassification(existingFatca.getNffeClassification(), fatcaDTO, isPatch));
		existingFatca
				.setStockExchangeInfo(mapStockExchangeInfo(existingFatca.getStockExchangeInfo(), fatcaDTO, isPatch));
		existingFatca.setUltimateBeneficialOwnership(
				mapUltimateBeneficialOwnership(existingFatca.getUltimateBeneficialOwnership(), fatcaDTO, isPatch));
		existingFatca.setAdditionalFlagsAndIdentifiers(
				mapAdditionalFlagsAndIdentifiers(existingFatca.getAdditionalFlagsAndIdentifiers(), fatcaDTO, isPatch));

		return existingFatca;
	}

	private SecondTaxInfo mapTaxInfo(SecondTaxInfo existingTaxInfo, FatcaDTO fatcaDTO, boolean isPatch) {
		if (existingTaxInfo == null) {
			existingTaxInfo = new SecondTaxInfo(); // Create a new instance if not present
		}

		if (!isPatch) {
			// PUT: Set all fields, even if null
			existingTaxInfo.setTaxStatus(fatcaDTO.getTaxStatus());
			existingTaxInfo.setDataSrc(fatcaDTO.getDataSrc());
			existingTaxInfo.setAddrType(fatcaDTO.getAddrType());
			existingTaxInfo.setPoBirInc(fatcaDTO.getPoBirInc());
			existingTaxInfo.setCoBirInc(fatcaDTO.getCoBirInc());
			existingTaxInfo.setTaxRes1(fatcaDTO.getTaxRes1());
			existingTaxInfo.setTpin1(fatcaDTO.getTpin1());
			existingTaxInfo.setId1Type(fatcaDTO.getId1Type());
			existingTaxInfo.setTaxRes2(fatcaDTO.getTaxRes2());
			existingTaxInfo.setTpin2(fatcaDTO.getTpin2());
			existingTaxInfo.setId2Type(fatcaDTO.getId2Type());
			existingTaxInfo.setTaxRes3(fatcaDTO.getTaxRes3());
			existingTaxInfo.setTpin3(fatcaDTO.getTpin3());
			existingTaxInfo.setId3Type(fatcaDTO.getId3Type());
			existingTaxInfo.setTaxRes4(fatcaDTO.getTaxRes4());
			existingTaxInfo.setTpin4(fatcaDTO.getTpin4());
			existingTaxInfo.setId4Type(fatcaDTO.getId4Type());
		} else {
			// PATCH: Update only non-null values
			if (fatcaDTO.getTaxStatus() != null)
				existingTaxInfo.setTaxStatus(fatcaDTO.getTaxStatus());
			if (fatcaDTO.getDataSrc() != null)
				existingTaxInfo.setDataSrc(fatcaDTO.getDataSrc());
			if (fatcaDTO.getAddrType() != null)
				existingTaxInfo.setAddrType(fatcaDTO.getAddrType());
			if (fatcaDTO.getPoBirInc() != null)
				existingTaxInfo.setPoBirInc(fatcaDTO.getPoBirInc());
			if (fatcaDTO.getCoBirInc() != null)
				existingTaxInfo.setCoBirInc(fatcaDTO.getCoBirInc());
			if (fatcaDTO.getTaxRes1() != null)
				existingTaxInfo.setTaxRes1(fatcaDTO.getTaxRes1());
			if (fatcaDTO.getTpin1() != null)
				existingTaxInfo.setTpin1(fatcaDTO.getTpin1());
			if (fatcaDTO.getId1Type() != null)
				existingTaxInfo.setId1Type(fatcaDTO.getId1Type());
			if (fatcaDTO.getTaxRes2() != null)
				existingTaxInfo.setTaxRes2(fatcaDTO.getTaxRes2());
			if (fatcaDTO.getTpin2() != null)
				existingTaxInfo.setTpin2(fatcaDTO.getTpin2());
			if (fatcaDTO.getId2Type() != null)
				existingTaxInfo.setId2Type(fatcaDTO.getId2Type());
			if (fatcaDTO.getTaxRes3() != null)
				existingTaxInfo.setTaxRes3(fatcaDTO.getTaxRes3());
			if (fatcaDTO.getTpin3() != null)
				existingTaxInfo.setTpin3(fatcaDTO.getTpin3());
			if (fatcaDTO.getId3Type() != null)
				existingTaxInfo.setId3Type(fatcaDTO.getId3Type());
			if (fatcaDTO.getTaxRes4() != null)
				existingTaxInfo.setTaxRes4(fatcaDTO.getTaxRes4());
			if (fatcaDTO.getTpin4() != null)
				existingTaxInfo.setTpin4(fatcaDTO.getTpin4());
			if (fatcaDTO.getId4Type() != null)
				existingTaxInfo.setId4Type(fatcaDTO.getId4Type());
		}

		return existingTaxInfo;
	}

	private ThirdWealthInfo mapWealthInfo(ThirdWealthInfo existingWealthInfo, FatcaDTO fatcaDTO, boolean isPatch) {
		if (existingWealthInfo == null) {
			existingWealthInfo = new ThirdWealthInfo(); // Create a new instance if not present
		}

		if (!isPatch) {
			// PUT: Set all fields, even if null
			existingWealthInfo.setSrceWealt(fatcaDTO.getSrceWealt());
			existingWealthInfo.setCorpServs(fatcaDTO.getCorpServs());
			existingWealthInfo.setIncSlab(fatcaDTO.getIncSlab());
			existingWealthInfo.setNetWorth(fatcaDTO.getNetWorth());
			existingWealthInfo.setNwDate(fatcaDTO.getNwDate());
		} else {
			// PATCH: Only update if the field is non-null
			if (fatcaDTO.getSrceWealt() != null)
				existingWealthInfo.setSrceWealt(fatcaDTO.getSrceWealt());
			if (fatcaDTO.getCorpServs() != null)
				existingWealthInfo.setCorpServs(fatcaDTO.getCorpServs());
			if (fatcaDTO.getIncSlab() != null)
				existingWealthInfo.setIncSlab(fatcaDTO.getIncSlab());
			if (fatcaDTO.getNetWorth() != null)
				existingWealthInfo.setNetWorth(fatcaDTO.getNetWorth());
			if (fatcaDTO.getNwDate() != null)
				existingWealthInfo.setNwDate(fatcaDTO.getNwDate());
		}

		return existingWealthInfo;
	}

	private FourthPoliticalExposed mapPepFlag(FourthPoliticalExposed existingPepFlag, FatcaDTO fatcaDTO,
			boolean isPatch) {
		if (existingPepFlag == null) {
			existingPepFlag = new FourthPoliticalExposed(); // Create a new instance if not present
		}

		if (!isPatch) {
			// PUT: Set all fields, even if null
			existingPepFlag.setPepFlag(fatcaDTO.getPepFlag());
		} else {
			// PATCH: Only update if the field is non-null
			if (fatcaDTO.getPepFlag() != null)
				existingPepFlag.setPepFlag(fatcaDTO.getPepFlag());
		}

		return existingPepFlag;
	}

	private FifthOccupationDetails mapOccupationDetails(FifthOccupationDetails existingOccupationDetails,
			FatcaDTO fatcaDTO, boolean isPatch) {
		if (existingOccupationDetails == null) {
			existingOccupationDetails = new FifthOccupationDetails(); // Create a new instance if not present
		}

		if (!isPatch) {
			// PUT: Set all fields, even if null
			existingOccupationDetails.setOccCode(fatcaDTO.getOccCode());
			existingOccupationDetails.setOccType(fatcaDTO.getOccType());
		} else {
			// PATCH: Only update if the field is non-null
			if (fatcaDTO.getOccCode() != null)
				existingOccupationDetails.setOccCode(fatcaDTO.getOccCode());
			if (fatcaDTO.getOccType() != null)
				existingOccupationDetails.setOccType(fatcaDTO.getOccType());
		}

		return existingOccupationDetails;
	}

	private SixthNonIndividualDetails mapNonIndividualDetails(SixthNonIndividualDetails existingNonIndividualDetails,
			FatcaDTO fatcaDTO, boolean isPatch) {
		if (existingNonIndividualDetails == null) {
			existingNonIndividualDetails = new SixthNonIndividualDetails(); // Create a new instance if not present
		}

		if (!isPatch) {
			// PUT: Set all fields, even if null
			existingNonIndividualDetails.setExemCode(fatcaDTO.getExemCode());
			existingNonIndividualDetails.setFfiDrnfe(fatcaDTO.getFfiDrnfe());
			existingNonIndividualDetails.setGiinNo(fatcaDTO.getGiinNo());
		} else {
			// PATCH: Only update if the field is non-null
			if (fatcaDTO.getExemCode() != null)
				existingNonIndividualDetails.setExemCode(fatcaDTO.getExemCode());
			if (fatcaDTO.getFfiDrnfe() != null)
				existingNonIndividualDetails.setFfiDrnfe(fatcaDTO.getFfiDrnfe());
			if (fatcaDTO.getGiinNo() != null)
				existingNonIndividualDetails.setGiinNo(fatcaDTO.getGiinNo());
		}

		return existingNonIndividualDetails;
	}

	private SeventhSponsoringEntityDetails mapSponsoringEntityDetails(
			SeventhSponsoringEntityDetails existingSponsoringEntityDetails, FatcaDTO fatcaDTO, boolean isPatch) {
		if (existingSponsoringEntityDetails == null) {
			existingSponsoringEntityDetails = new SeventhSponsoringEntityDetails(); // Create a new instance if not
																					// present
		}

		if (!isPatch) {
			// PUT: Set all fields, even if null
			existingSponsoringEntityDetails.setSprEntity(fatcaDTO.getSprEntity());
			existingSponsoringEntityDetails.setGiinNa(fatcaDTO.getGiinNa());
			existingSponsoringEntityDetails.setGiinExemc(fatcaDTO.getGiinExemc());
		} else {
			// PATCH: Only update if the field is non-null
			if (fatcaDTO.getSprEntity() != null)
				existingSponsoringEntityDetails.setSprEntity(fatcaDTO.getSprEntity());
			if (fatcaDTO.getGiinNa() != null)
				existingSponsoringEntityDetails.setGiinNa(fatcaDTO.getGiinNa());
			if (fatcaDTO.getGiinExemc() != null)
				existingSponsoringEntityDetails.setGiinExemc(fatcaDTO.getGiinExemc());
		}

		return existingSponsoringEntityDetails;
	}

	private EightNffeClassification mapNffeClassification(EightNffeClassification existingNffeClassification,
			FatcaDTO fatcaDTO, boolean isPatch) {
		if (existingNffeClassification == null) {
			existingNffeClassification = new EightNffeClassification(); // Create a new instance if null
		}

		if (!isPatch) {
			// PUT: Set all fields, even if null
			existingNffeClassification.setNffeCatg(fatcaDTO.getNffeCatg());
			existingNffeClassification.setActNfeSc(fatcaDTO.getActNfeSc());
			existingNffeClassification.setNatureBus(fatcaDTO.getNatureBus());
			existingNffeClassification.setRelListed(fatcaDTO.getRelListed());
		} else {
			// PATCH: Only update if the field is non-null
			if (fatcaDTO.getNffeCatg() != null)
				existingNffeClassification.setNffeCatg(fatcaDTO.getNffeCatg());
			if (fatcaDTO.getActNfeSc() != null)
				existingNffeClassification.setActNfeSc(fatcaDTO.getActNfeSc());
			if (fatcaDTO.getNatureBus() != null)
				existingNffeClassification.setNatureBus(fatcaDTO.getNatureBus());
			if (fatcaDTO.getRelListed() != null)
				existingNffeClassification.setRelListed(fatcaDTO.getRelListed());
		}

		return existingNffeClassification;
	}

	private NinethStockExchangeInfo mapStockExchangeInfo(NinethStockExchangeInfo existingStockExchangeInfo,
			FatcaDTO fatcaDTO, boolean isPatch) {
		if (existingStockExchangeInfo == null) {
			existingStockExchangeInfo = new NinethStockExchangeInfo(); // Create a new instance if null
		}

		if (!isPatch) {
			// PUT: Set all fields, even if null
			existingStockExchangeInfo.setExchName(fatcaDTO.getExchName());
		} else {
			// PATCH: Only update if the field is non-null
			if (fatcaDTO.getExchName() != null)
				existingStockExchangeInfo.setExchName(fatcaDTO.getExchName());
		}

		return existingStockExchangeInfo;
	}

	private TenthUltimateBeneficialOwnership mapUltimateBeneficialOwnership(
			TenthUltimateBeneficialOwnership existingUltimateBeneficialOwnership, FatcaDTO fatcaDTO, boolean isPatch) {
		if (existingUltimateBeneficialOwnership == null) {
			existingUltimateBeneficialOwnership = new TenthUltimateBeneficialOwnership(); // Create a new instance if
																							// null
		}

		if (!isPatch) {
			// PUT: Set all fields, even if null
			existingUltimateBeneficialOwnership.setUboAppl(fatcaDTO.getUboAppl());
			existingUltimateBeneficialOwnership.setUboCount(fatcaDTO.getUboCount());
			existingUltimateBeneficialOwnership.setUboName(fatcaDTO.getUboName());
			existingUltimateBeneficialOwnership.setUboPan(fatcaDTO.getUboPan());
			existingUltimateBeneficialOwnership.setUboNation(fatcaDTO.getUboNation());
			existingUltimateBeneficialOwnership.setUboAdd1(fatcaDTO.getUboAdd1());
			existingUltimateBeneficialOwnership.setUboAdd2(fatcaDTO.getUboAdd2());
			existingUltimateBeneficialOwnership.setUboAdd3(fatcaDTO.getUboAdd3());
			existingUltimateBeneficialOwnership.setUboCity(fatcaDTO.getUboCity());
			existingUltimateBeneficialOwnership.setUboPin(fatcaDTO.getUboPin());
			existingUltimateBeneficialOwnership.setUboState(fatcaDTO.getUboState());
			existingUltimateBeneficialOwnership.setUboCntry(fatcaDTO.getUboCntry());
			existingUltimateBeneficialOwnership.setUboAddTy(fatcaDTO.getUboAddTy());
			existingUltimateBeneficialOwnership.setUboCtr(fatcaDTO.getUboCtr());
			existingUltimateBeneficialOwnership.setUboTin(fatcaDTO.getUboTin());
			existingUltimateBeneficialOwnership.setUboIdTy(fatcaDTO.getUboIdTy());
			existingUltimateBeneficialOwnership.setUboCob(fatcaDTO.getUboCob());
			existingUltimateBeneficialOwnership.setUboDob(fatcaDTO.getUboDob());
			existingUltimateBeneficialOwnership.setUboGender(fatcaDTO.getUboGender());
			existingUltimateBeneficialOwnership.setUboFrNam(fatcaDTO.getUboFrNam());
			existingUltimateBeneficialOwnership.setUboOcc(fatcaDTO.getUboOcc());
			existingUltimateBeneficialOwnership.setUboOccTy(fatcaDTO.getUboOccTy());
			existingUltimateBeneficialOwnership.setUboTel(fatcaDTO.getUboTel());
			existingUltimateBeneficialOwnership.setUboMobile(fatcaDTO.getUboMobile());
			existingUltimateBeneficialOwnership.setUboCode(fatcaDTO.getUboCode());
			existingUltimateBeneficialOwnership.setUboHolPc(fatcaDTO.getUboHolPc());
		} else {
			// PATCH: Only update if the field is non-null
			if (fatcaDTO.getUboAppl() != null)
				existingUltimateBeneficialOwnership.setUboAppl(fatcaDTO.getUboAppl());
			if (fatcaDTO.getUboCount() != null)
				existingUltimateBeneficialOwnership.setUboCount(fatcaDTO.getUboCount());
			if (fatcaDTO.getUboName() != null)
				existingUltimateBeneficialOwnership.setUboName(fatcaDTO.getUboName());
			if (fatcaDTO.getUboPan() != null)
				existingUltimateBeneficialOwnership.setUboPan(fatcaDTO.getUboPan());
			if (fatcaDTO.getUboNation() != null)
				existingUltimateBeneficialOwnership.setUboNation(fatcaDTO.getUboNation());
			if (fatcaDTO.getUboAdd1() != null)
				existingUltimateBeneficialOwnership.setUboAdd1(fatcaDTO.getUboAdd1());
			if (fatcaDTO.getUboAdd2() != null)
				existingUltimateBeneficialOwnership.setUboAdd2(fatcaDTO.getUboAdd2());
			if (fatcaDTO.getUboAdd3() != null)
				existingUltimateBeneficialOwnership.setUboAdd3(fatcaDTO.getUboAdd3());
			if (fatcaDTO.getUboCity() != null)
				existingUltimateBeneficialOwnership.setUboCity(fatcaDTO.getUboCity());
			if (fatcaDTO.getUboPin() != null)
				existingUltimateBeneficialOwnership.setUboPin(fatcaDTO.getUboPin());
			if (fatcaDTO.getUboState() != null)
				existingUltimateBeneficialOwnership.setUboState(fatcaDTO.getUboState());
			if (fatcaDTO.getUboCntry() != null)
				existingUltimateBeneficialOwnership.setUboCntry(fatcaDTO.getUboCntry());
			if (fatcaDTO.getUboAddTy() != null)
				existingUltimateBeneficialOwnership.setUboAddTy(fatcaDTO.getUboAddTy());
			if (fatcaDTO.getUboCtr() != null)
				existingUltimateBeneficialOwnership.setUboCtr(fatcaDTO.getUboCtr());
			if (fatcaDTO.getUboTin() != null)
				existingUltimateBeneficialOwnership.setUboTin(fatcaDTO.getUboTin());
			if (fatcaDTO.getUboIdTy() != null)
				existingUltimateBeneficialOwnership.setUboIdTy(fatcaDTO.getUboIdTy());
			if (fatcaDTO.getUboCob() != null)
				existingUltimateBeneficialOwnership.setUboCob(fatcaDTO.getUboCob());
			if (fatcaDTO.getUboDob() != null)
				existingUltimateBeneficialOwnership.setUboDob(fatcaDTO.getUboDob());
			if (fatcaDTO.getUboGender() != null)
				existingUltimateBeneficialOwnership.setUboGender(fatcaDTO.getUboGender());
			if (fatcaDTO.getUboFrNam() != null)
				existingUltimateBeneficialOwnership.setUboFrNam(fatcaDTO.getUboFrNam());
			if (fatcaDTO.getUboOcc() != null)
				existingUltimateBeneficialOwnership.setUboOcc(fatcaDTO.getUboOcc());
			if (fatcaDTO.getUboOccTy() != null)
				existingUltimateBeneficialOwnership.setUboOccTy(fatcaDTO.getUboOccTy());
			if (fatcaDTO.getUboTel() != null)
				existingUltimateBeneficialOwnership.setUboTel(fatcaDTO.getUboTel());
			if (fatcaDTO.getUboMobile() != null)
				existingUltimateBeneficialOwnership.setUboMobile(fatcaDTO.getUboMobile());
			if (fatcaDTO.getUboCode() != null)
				existingUltimateBeneficialOwnership.setUboCode(fatcaDTO.getUboCode());
			if (fatcaDTO.getUboHolPc() != null)
				existingUltimateBeneficialOwnership.setUboHolPc(fatcaDTO.getUboHolPc());
		}

		return existingUltimateBeneficialOwnership;
	}

	private ElleventhAdditionalFlagsAndIdentifiers mapAdditionalFlagsAndIdentifiers(
			ElleventhAdditionalFlagsAndIdentifiers existingAdditionalFlagsAndIdentifiers, FatcaDTO fatcaDTO,
			boolean isPatch) {
		if (existingAdditionalFlagsAndIdentifiers == null) {
			existingAdditionalFlagsAndIdentifiers = new ElleventhAdditionalFlagsAndIdentifiers(); // Create a new
																									// instance if null
		}

		if (!isPatch) {
			// PUT: Set all fields, even if null
			existingAdditionalFlagsAndIdentifiers.setSdfFlag(fatcaDTO.getSdfFlag());
			existingAdditionalFlagsAndIdentifiers.setUboDf(fatcaDTO.getUboDf());
			existingAdditionalFlagsAndIdentifiers.setAadhaarRp(fatcaDTO.getAadhaarRp());
			existingAdditionalFlagsAndIdentifiers.setNewChange(fatcaDTO.getNewChange());
			existingAdditionalFlagsAndIdentifiers.setLogName(fatcaDTO.getLogName());
			existingAdditionalFlagsAndIdentifiers.setFiller1(fatcaDTO.getFiller1());
			existingAdditionalFlagsAndIdentifiers.setFiller2(fatcaDTO.getFiller2());
		} else {
			// PATCH: Only update if the field is non-null
			if (fatcaDTO.getSdfFlag() != null)
				existingAdditionalFlagsAndIdentifiers.setSdfFlag(fatcaDTO.getSdfFlag());
			if (fatcaDTO.getUboDf() != null)
				existingAdditionalFlagsAndIdentifiers.setUboDf(fatcaDTO.getUboDf());
			if (fatcaDTO.getAadhaarRp() != null)
				existingAdditionalFlagsAndIdentifiers.setAadhaarRp(fatcaDTO.getAadhaarRp());
			if (fatcaDTO.getNewChange() != null)
				existingAdditionalFlagsAndIdentifiers.setNewChange(fatcaDTO.getNewChange());
			if (fatcaDTO.getLogName() != null)
				existingAdditionalFlagsAndIdentifiers.setLogName(fatcaDTO.getLogName());
			if (fatcaDTO.getFiller1() != null)
				existingAdditionalFlagsAndIdentifiers.setFiller1(fatcaDTO.getFiller1());
			if (fatcaDTO.getFiller2() != null)
				existingAdditionalFlagsAndIdentifiers.setFiller2(fatcaDTO.getFiller2());
		}

		return existingAdditionalFlagsAndIdentifiers;
	}

}
