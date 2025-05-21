package com.cyfrifpro.services;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public interface AccountStatementToJsonService {

    /**
     * Converts a CSV file to JSON and saves the data into the database.
     * 
     * @param filePath The path to the CSV file.
     * @return A message indicating the result of the operation.
     * @throws IOException If there is an issue reading the file.
     * @throws IllegalAccessException If there is an issue accessing the fields of the Employee class.
     */
    String convertCsvToJsonAndSaveToDb(String filePath) throws IOException, IllegalAccessException;

	String convertCsvToJsonAndSaveToDb(MultipartFile file);
}