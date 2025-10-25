package com.melvin.School.Management.System.Repository;

import com.melvin.School.Management.System.Model.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Enrollment Repository Interface
 * 
 * This repository interface provides data access operations for Enrollment entities.
 * It extends JpaRepository to inherit standard CRUD operations and additional
 * JPA-specific methods.
 * 
 * Inherited Operations:
 * - save(Enrollment) - Create or update an enrollment
 * - findById(Long) - Find enrollment by ID
 * - findAll() - Retrieve all enrollments
 * - deleteById(Long) - Delete enrollment by ID
 * - count() - Count total enrollments
 * - existsById(Long) - Check if enrollment exists
 * 
 * Custom query methods can be added here using Spring Data JPA conventions
 * or @Query annotations for specific enrollment queries like:
 * - findByStudentId(Long studentId)
 * - findByCourseId(Long courseId)
 * - findByEnrollmentDate(LocalDate date)
 * 
 * @author Melvin Chibanda
 * @version 1.0
 * @since 2024
 */
@Repository
public interface EnrollementRepository extends JpaRepository <Enrollment, Long> {
}
