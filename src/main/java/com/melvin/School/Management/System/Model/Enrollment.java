package com.melvin.School.Management.System.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * Enrollment Entity
 * 
 * Represents an enrollment record in the school management system.
 * This entity tracks when a student enrolls in a specific course,
 * providing an audit trail of enrollment activities.
 * 
 * Database Table: enrollments
 * 
 * Relationships:
 * - Many-to-One with Student (multiple enrollments per student)
 * - Many-to-One with Course (multiple enrollments per course)
 * 
 * @author Melvin Chibanda
 * @version 1.0
 * @since 2024
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "enrollments")
public class Enrollment {

    /**
     * Unique identifier for the enrollment record.
     * Auto-generated using database identity strategy.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Student who is enrolled.
     * Many-to-One relationship with Student entity.
     * Required field, cannot be null.
     */
    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    /**
     * Course in which the student is enrolled.
     * Many-to-One relationship with Course entity.
     * Required field, cannot be null.
     */
    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    /**
     * Date when the enrollment was created.
     * Defaults to current date when the enrollment is created.
     */
    private LocalDate enrollmentDate = LocalDate.now();
}
