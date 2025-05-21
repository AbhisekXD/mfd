package com.cyfrifpro.payloads;

import java.util.List;

import com.cyfrifpro.model.enums.RoleEnum;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
	
    private Long userId;

    @Size(min = 1, max = 20, message = "First Name must be between 1 and 20 characters long")
    @Pattern(regexp = "^[a-zA-Z]*$", message = "First Name must not contain numbers or special characters")
    private String firstName;

    @Size(min = 1, max = 20, message = "Last Name must be between 1 and 20 characters long")
    @Pattern(regexp = "^[a-zA-Z]*$", message = "Last Name must not contain numbers or special characters")
    private String lastName;

    @Pattern(regexp = "^[0-9]*$", message = "Mobile Number must contain only numbers") // Numeric check
    @Size(min = 10, max = 10, message = "Mobile Number must be exactly 10 digits long") // Length check
    private String contactNumber;

    @Email(message = "Email should be valid")
    @NotBlank(message = "Email is mandatory")
    @Column(unique = true, nullable = false)
    private String email;

    @Size(min = 4, max = 100, message = "Password must be between 4 and 100 characters long")
    @NotBlank(message = "Password is mandatory")
    private String password;

    private Long roleId;

    private RoleEnum roleName;

    //private LocalDateTime createdAt;
    
    private List<UserDTO> subordinates;

    // Getters and setters (if required, but Lombok provides them)
}
