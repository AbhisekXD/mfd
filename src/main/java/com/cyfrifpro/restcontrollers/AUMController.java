package com.cyfrifpro.restcontrollers;

import com.cyfrifpro.model.client.AUMData;
import com.cyfrifpro.services.impl.AUMService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/files")
public class AUMController {

	@Autowired
	private AUMService aumService;

	@PostMapping("/upload")
	public ResponseEntity<?> uploadExcelFile(@RequestParam MultipartFile file) {
		if (file.isEmpty()) {
			return ResponseEntity.badRequest().body("Error: Uploaded file is empty.");
		}

		try {
			aumService.processExcelFile(file);

			return ResponseEntity.ok("File processed and data saved successfully.");

		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().body("Error processing the uploaded file: " + e.getMessage());
		}
	}

	@GetMapping("/all")
	public ResponseEntity<List<AUMData>> getAllData() {
		List<AUMData> allData = aumService.getAllAumData();
		return ResponseEntity.ok(allData);
	}

	@GetMapping("/email")
	public ResponseEntity<?> getDataByEmail(@RequestParam String email) {
		List<AUMData> dataByEmail = aumService.getAumDataByEmail(email);
		if (dataByEmail.isEmpty()) {
			return ResponseEntity.status(404).body("No data found for the given email.");
		}
		return ResponseEntity.ok(dataByEmail);
	}

	@GetMapping("/assets-cost-units-zero")
	public ResponseEntity<List<AUMData>> getDataWhereAssetsCostUnitsAreZero() {
		List<AUMData> filteredData = aumService.getDataWhereAssetsCostUnitsAreZero();
		return ResponseEntity.ok(filteredData);
	}

	@GetMapping("/assets-cost-units-nonzero")
	public ResponseEntity<List<AUMData>> getDataWhereAssetsCostUnitsAreNonZero() {
		List<AUMData> filteredData = aumService.getDataWhereAssetsCostUnitsAreNonZero();
		return ResponseEntity.ok(filteredData);
	}

	// Controller endpoint to find by brokDlrCode (ARN number)
    @GetMapping("/find-by-arn/{arnNumber}")
    public ResponseEntity<List<AUMData>> findByARNNumber(@PathVariable String arnNumber) {
        List<AUMData> aumDataList = aumService.findByBrokDlrCode(arnNumber);

        if (aumDataList.isEmpty()) {
            return ResponseEntity.noContent().build(); // No data found
        } else {
            return ResponseEntity.ok(aumDataList); // Return the list of AUMData
        }
    }
}
