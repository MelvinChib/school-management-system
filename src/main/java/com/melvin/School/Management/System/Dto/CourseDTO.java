package com.melvin.School.Management.System.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

/**
 * Course Data Transfer Object (DTO)
 * 
 * This DTO is used for transferring course data between different layers
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
public class CourseDTO {

    /**
     * Unique identifier for the course.
     * Null for new courses, populated for existing courses.
     */
    private Long id;

    /**
     * Course name.
     * Must be between 2 and 50 characters and cannot be blank.
     */
    @NotBlank(message = "Course name is mandatory")
    @Size(min = 2, max = 50, message = "Course name must be between 2 and 50 characters")
    private String name;

    /**
     * Course description.
     * Optional field with maximum length of 200 characters.
     */
    @Size(max = 200, message = "Description must not exceed 200 characters")
    private String description;

    /**
     * ID of the teacher assigned to this course.
     * Used for managing teacher-course relationships.
     */
    private Long teacherId;
    
    /**
     * List of student IDs enrolled in this course.
     * Used for managing student-course relationships.
     */
    private List<Long> studentIds;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public List<Long> getStudentIds() {
        return studentIds;
    }

    public void setStudentIds(List<Long> studentIds) {
        this.studentIds = studentIds;
    }
}
