package com.melvin.School.Management.System.Dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Student Data Transfer Object (DTO)
 * 
 * This DTO is used for transferring student data between different layers
 * of the application (Controller, Service, Repository). It includes validation
 * annotations to ensure data integrity.
 * 
 * Used for:
 * - API request/response payloads
 * - Data validation
 * - Mapping between entity and external representation
 * 
 * @author Melvin Chibanda
 * @version 1.0
 * @since 2024
 */
@Data
public class StudentDTO {

    /**
     * Unique identifier for the student.
     * Null for new students, populated for existing students.
     */
    private Long id;

    /**
     * Student's first name.
     * Must be between 2 and 30 characters and cannot be blank.
     */
    @NotBlank(message = "First name is mandatory")
    @Size(min = 2, max = 30, message = "First name must be between 2 and 30 characters")
    private String firstName;

    /**
     * Student's last name.
     * Must be between 2 and 30 characters and cannot be blank.
     */
    @NotBlank(message = "Last name is mandatory")
    @Size(min = 2, max = 30, message = "Last name must be between 2 and 30 characters")
    private String lastName;

    /**
     * Student's email address.
     * Must be a valid email format and cannot be blank.
     */
    @NotBlank(message = "Email is mandatory")
    @Email(message = "Email should be valid")
    private String email;

    /**
     * List of course IDs that the student is enrolled in.
     * Used for managing student-course relationships.
     */
    private List<Long> courseIds;
}
