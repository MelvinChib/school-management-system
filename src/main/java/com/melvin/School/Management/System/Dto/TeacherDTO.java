package com.melvin.School.Management.System.Dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

/**
 * Teacher Data Transfer Object (DTO)
 * 
 * This DTO is used for transferring teacher data between different layers
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
public class TeacherDTO {

    /**
     * Unique identifier for the teacher.
     * Null for new teachers, populated for existing teachers.
     */
    private Long id;

    /**
     * Teacher's first name.
     * Must be between 2 and 30 characters and cannot be blank.
     */
    @NotBlank(message = "First name is mandatory")
    @Size(min = 2, max = 30, message = "First name must be between 2 and 30 characters")
    private String firstName;

    /**
     * Teacher's last name.
     * Must be between 2 and 30 characters and cannot be blank.
     */
    @NotBlank(message = "Last name is mandatory")
    @Size(min = 2, max = 30, message = "Last name must be between 2 and 30 characters")
    private String lastName;

    /**
     * Teacher's email address.
     * Cannot be blank. Email format validation should be added.
     */
    @NotBlank(message = "Email is mandatory")
    private String email;

    /**
     * List of course IDs that the teacher is assigned to teach.
     * Used for managing teacher-course relationships.
     */
    private List<Long> courseIds;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Long> getCourseIds() {
        return courseIds;
    }

    public void setCourseIds(List<Long> courseIds) {
        this.courseIds = courseIds;
    }
}
