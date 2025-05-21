package com.cyfrifpro.payloads;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseParameter {
	
	@JsonProperty("Status") // Ensure this maps to the "Status" field from the JSON response
    private String status;

    @JsonProperty("Remarks") // Ensure this maps to the "Remarks" field from the JSON response
    private String remarks;

    @JsonProperty("Filler1") // Ensure this maps to the "Filler1" field from the JSON response
    private String filler1;

    @JsonProperty("Filler2") // Ensure this maps to the "Filler2" field from the JSON response
    private String filler2;
}
