package com.cyfrifpro.services.impl;

import com.cyfrifpro.model.client.AUMData;
import com.cyfrifpro.repositories.AUMDataRepository;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class AUMService {

	@Autowired
	private AUMDataRepository aumDataRepository;

	public List<AUMData> processExcelFile(MultipartFile file) throws Exception {
		try (InputStream inputStream = file.getInputStream()) {
			// Parse the Excel file
			List<AUMData> aumDataList = parseExcelFile(inputStream);

			// Save parsed data to the database
			aumDataRepository.saveAll(aumDataList);

			return aumDataList;
		}
	}

	private List<AUMData> parseExcelFile(InputStream inputStream) throws Exception {
		List<AUMData> dataList = new ArrayList<>();
		try (Workbook workbook = WorkbookFactory.create(inputStream)) {
			Sheet sheet = workbook.getSheetAt(0);

			// Read the header row
			Row headerRow = sheet.getRow(0);
			if (headerRow == null) {
				throw new IllegalArgumentException("Error: Header row is missing in the Excel file.");
			}

			List<String> headers = new ArrayList<>();
			for (Cell cell : headerRow) {
				headers.add(cell.getStringCellValue().trim());
			}

			// Read data rows
			for (int i = 1; i <= sheet.getLastRowNum(); i++) { // Start from row 1 to skip the header
				Row row = sheet.getRow(i);
				if (row != null) {
					AUMData aumData = new AUMData();

					for (int j = 0; j < headers.size(); j++) {
						Cell cell = row.getCell(j);
						Object cellValue = getCellValue(cell);

						// Map cell values to entity fields
						switch (headers.get(j).toLowerCase()) {
						case "brok_dlr_code":
							aumData.setBrokDlrCode((String) cellValue);
							break;
						case "product":
							aumData.setProduct((String) cellValue);
							break;
						case "asset_date":
							aumData.setAssetDate(
									cellValue != null ? new SimpleDateFormat("dd-MMM-yyyy").parse(cellValue.toString())
											: null);
							break;
						case "folio":
							aumData.setFolio((String) cellValue);
							break;
						case "inv_name":
							aumData.setInvName((String) cellValue);
							break;
						case "scheme_name":
							aumData.setSchemeName((String) cellValue);
							break;
						case "cost value":
							aumData.setCostValue(cellValue != null ? Double.valueOf(cellValue.toString()) : null);
							break;
						case "closing_assets":
							aumData.setClosingAssets(cellValue != null ? Double.valueOf(cellValue.toString()) : null);
							break;
						case "city":
							aumData.setCity((String) cellValue);
							break;
						case "email_id":
							aumData.setEmailId((String) cellValue);
							break;
						case "tax_status":
							aumData.setTaxStatus((String) cellValue);
							break;
						case "units":
							aumData.setUnits(cellValue != null ? Double.valueOf(cellValue.toString()) : null);
							break;
						case "nav":
							aumData.setNav(cellValue != null ? Double.valueOf(cellValue.toString()) : null);
							break;
						case "inv_iin":
							aumData.setInvIin((String) cellValue);
							break;
						}
					}
					dataList.add(aumData);
				}
			}
		}
		return dataList;
	}

	private Object getCellValue(Cell cell) {
		if (cell == null)
			return null;

		switch (cell.getCellType()) {
		case STRING:
			return cell.getStringCellValue().trim();
		case NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
				return dateFormat.format(cell.getDateCellValue());
			} else {
				// Convert numeric values to String if needed
				return String.valueOf(cell.getNumericCellValue());
			}
		case BOOLEAN:
			return String.valueOf(cell.getBooleanCellValue());
		case FORMULA:
			return resolveFormulaCell(cell);
		default:
			return null;
		}
	}

	private Object resolveFormulaCell(Cell cell) {
		try {
			switch (cell.getCachedFormulaResultType()) {
			case NUMERIC:
				if (DateUtil.isCellDateFormatted(cell)) {
					SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
					return dateFormat.format(cell.getDateCellValue());
				} else {
					return cell.getNumericCellValue();
				}
			case STRING:
				return cell.getStringCellValue().trim();
			case BOOLEAN:
				return cell.getBooleanCellValue();
			default:
				return null;
			}
		} catch (Exception e) {
			return "Error resolving formula: " + e.getMessage();
		}
	}

	public List<AUMData> getAllAumData() {
		return aumDataRepository.findAll();
	}

	public List<AUMData> getAumDataByEmail(String email) {
		return aumDataRepository.findByEmailId(email);
	}
	
	public List<AUMData> getDataWhereAssetsCostUnitsAreZero() {
        return aumDataRepository.findByClosingAssetsAndCostValueAndUnits(0.0, 0.0, 0.0);
    }
	

	public List<AUMData> getDataWhereAssetsCostUnitsAreNonZero() {
	    return aumDataRepository.findByClosingAssetsNotAndCostValueNotAndUnitsNot(0.0, 0.0, 0.0);
	}

	// Service method to find AUM data by ARN number
	public List<AUMData> findByBrokDlrCode(String arnNumber) {
        return aumDataRepository.findByBrokDlrCode(arnNumber);
    }
}
