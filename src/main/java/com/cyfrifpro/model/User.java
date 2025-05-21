package com.cyfrifpro.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.cyfrifpro.model.distributor.DistributorDetails;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreRemove;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;

	@Size(min = 1, max = 20, message = "First Name must be between 1 and 30 characters long")
	@Pattern(regexp = "^[a-zA-Z]*$", message = "First Name must not contain numbers or special characters")
	private String firstName;

	@Size(min = 1, max = 20, message = "Last Name must be between 1 and 30 characters long")
	@Pattern(regexp = "^[a-zA-Z]*$", message = "Last Name must not contain numbers or special characters")
	private String lastName;

	@Pattern(regexp = "^[0-9]*$", message = "Mobile Number must contain only numbers") // Numeric check
	@Size(min = 10, max = 10, message = "Mobile Number must be exactly 10 digits long") // Length check
	private String contactNumber;

	@Email(message = "Email should be valid")
	@NotBlank(message = "Email is mandatory")
	@Column(unique = true, nullable = false)
	private String email;

	private String password;

	@ManyToOne
	@JoinColumn(name = "created_by_user_id", referencedColumnName = "userId")
	@JsonIgnore
	private User createdBy;

	@OneToMany(mappedBy = "createdBy", fetch = FetchType.LAZY) // Assuming 'createdBy' is the field in the User class
																// mapped to subordinates
	@JsonManagedReference // Manages the subordinates' serialization to prevent infinite recursion
	private List<User> subordinates;

	@JsonBackReference
	@OneToMany(mappedBy = "createdBy", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<User> children = new ArrayList<>();

	@OneToMany(mappedBy = "id") // Assumes that 'userId' is the field in Distributor class mapped to User
	private List<DistributorDetails> distributors;

	@ManyToOne
	@JoinColumn(name = "role_id", nullable = true) // Maps the foreign key column in the database
	private Role role;

	@Column(name = "created_at", updatable = false)
	private LocalDateTime createdAt;

	@Column(name = "updated_at")
	private LocalDateTime updatedAt;

	@Column(name = "deleted_at")
	private LocalDateTime deletedAt;

	// This method is annotated with @PrePersist and is executed before an entity is
	// persisted (saved) to the database.
	@PrePersist
	protected void onCreate() {
		// Sets the 'createdAt' field to the current date and time when the entity is
		// first created.
		this.createdAt = LocalDateTime.now();
	}

	// This method is annotated with @PreUpdate and is executed before an entity is
	// updated in the database.
	@PreUpdate
	protected void onUpdate() {
		// Sets the 'updatedAt' field to the current date and time whenever the entity
		// is updated.
		this.updatedAt = LocalDateTime.now();
	}

	// This method is annotated with @PreRemove and is executed before an entity is
	// removed (deleted) from the database.
	@PreRemove
	protected void onDelete() {
		// Sets the 'deletedAt' field to the current date and time when the entity is
		// deleted.
		this.deletedAt = LocalDateTime.now();
	}

}
