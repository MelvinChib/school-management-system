package com.melvin.School.Management.System.Repository;


import com.melvin.School.Management.System.Model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Course Repository Interface
 * 
 * This repository interface provides data access operations for Course entities.
 * It extends JpaRepository to inherit standard CRUD operations and additional
 * JPA-specific methods.
 * 
 * Inherited Operations:
 * - save(Course) - Create or update a course
 * - findById(Long) - Find course by ID
 * - findAll() - Retrieve all courses
 * - deleteById(Long) - Delete course by ID
 * - count() - Count total courses
 * - existsById(Long) - Check if course exists
 * 
 * Custom query methods can be added here using Spring Data JPA conventions
 * or @Query annotations.
 * 
 * @author Melvin Chibanda
 * @version 1.0
 * @since 2024
 */
@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}
