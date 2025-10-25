package com.melvin.School.Management.System.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * Student Entity
 * 
 * Represents a student in the school management system.
 * This entity stores student information and maintains relationships
 * with courses through enrollments.
 * 
 * Database Table: students
 * 
 * Relationships:
 * - Many-to-Many with Course (through student_courses join table)
 * 
 * @author Melvin Chibanda
 * @version 1.0
 * @since 2024
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "students")
public class Student {

    /**
     * Unique identifier for the student.
     * Auto-generated using database identity strategy.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private java.lang.Long id;

    /**
     * Student's first name.
     * Required field, cannot be null.
     */
    @Column(name = "first_name", nullable = false)
    private String firstName;

    /**
     * Student's last name.
     * Required field, cannot be null.
     */
    @Column(name = "last_name", nullable = false)
    private String lastName;

    /**
     * Student's email address.
     * Required field, must be unique across all students.
     */
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    /**
     * List of courses the student is enrolled in.
     * Many-to-Many relationship with Course entity.
     * Uses student_courses join table for mapping.
     */
    @ManyToMany
    @JoinTable(
        name = "student_courses",
        joinColumns = @JoinColumn(name = "student_id"),
        inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private List<Course> courses = new ArrayList<>();


}
