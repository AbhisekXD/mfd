package com.cyfrifpro.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cyfrifpro.model.AccountStatementHistory;
import com.cyfrifpro.repositories.AccountStatementRepo; // Updated import for AccountStatementRepo
import com.cyfrifpro.services.AccountStatementHistoryService;
import com.cyfrifpro.services.AccountStatementToJsonService; // Updated import for AccountStatementToJsonService
import com.cyfrifpro.services.impl.EmailAttachmentReaderService;

@RestController
@RequestMapping("/csv/upload")
public class AccountStatementUploadController { // Renamed class to AccountStatementUploadController

	@Autowired
	private AccountStatementToJsonService accountStatementToJsonService; // Updated service

	@Autowired
	private AccountStatementRepo accountStatementRepo; // Updated repository

	@Autowired
	private AccountStatementHistoryService accountStatementHistoryService;

	@Autowired
	private EmailAttachmentReaderService emailAttachmentReaderService;

	// Endpoint to upload the CSV file from frontend (MultipartFile)
	@PostMapping("/files")
	public ResponseEntity<String> uploadFile(@RequestParam MultipartFile file) {
		try {
			String result = accountStatementToJsonService.convertCsvToJsonAndSaveToDb(file); // Updated service method
																								// call
			return ResponseEntity.ok(result);
		} catch (Exception e) {
			return ResponseEntity.status(500).body("Error uploading file: " + e.getMessage());
		}
	}

	// Endpoint to process CSV file from a file path (using @RequestParam instead of
	// path variable)
	@PostMapping("/file-path")
	public ResponseEntity<String> uploadFilePath(@RequestParam String filePath) {
		try {
			String result = accountStatementToJsonService.convertCsvToJsonAndSaveToDb(filePath); // Updated service
																									// method call
			return ResponseEntity.ok(result);
		} catch (Exception e) {
			return ResponseEntity.status(500).body("Error reading file from path: " + e.getMessage());
		}
	}

	/*
	 * Cron Expression for 7:30 AM: The cron expression for running a task every day
	 * at 7:30 AM is 0 30 7 * * ?.
	 * 
	 * 0 – Second (at 0 seconds) 30 – Minute (at 30 minutes) 7 – Hour (at 7 AM) –
	 * Day of the month (every day) – Month (every month) ? – Day of the week (no
	 * specific day of the week)
	 * 
	 * @Scheduled(cron = "0 30 7 * * ?")
	 */
	@Scheduled(cron = "0 40 18 * * ?")
	@GetMapping("/read-email-attachment")
	public ResponseEntity<String> processEmailAttachment() {
		try {
			System.out.println("Scheduled task of mail attecheecd file reading is running...");
			MultipartFile attachment = emailAttachmentReaderService.fetchLatestEmailAttachment();
			String result = accountStatementToJsonService.convertCsvToJsonAndSaveToDb(attachment);
			return ResponseEntity.ok(result);
		} catch (Exception e) {
			return ResponseEntity.status(500).body("Error processing email attachment: " + e.getMessage());
		}
	}

	// Endpoint to view all saved AccountStatement records
	@GetMapping("/records")
	public ResponseEntity<?> getCsvRecords() {
		// Return the list of all AccountStatement records from the database
		return ResponseEntity.ok(accountStatementRepo.findAll()); // Updated repository method call
	}

	@GetMapping("/account-statement-history")
	public List<AccountStatementHistory> getAllHistory() {
		return accountStatementHistoryService.getAllHistory();
	}

//  // Task runs every 1 seconds
//  @Scheduled(fixedRate = 1000)
//  public void runTask() {
//      System.out.println("Scheduled task is running...");
//  }

}
