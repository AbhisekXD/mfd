package com.cyfrifpro.payloads;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DocumentDTO {

    @NotBlank(message = "Document name is required")
    private String name;

    private boolean checked;

    private byte[] file;

}
