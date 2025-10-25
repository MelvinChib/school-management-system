package com.melvin.School.Management.System.Repository;


import com.melvin.School.Management.System.Model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Teacher Repository Interface
 * 
 * This repository interface provides data access operations for Teacher entities.
 * It extends JpaRepository to inherit standard CRUD operations and additional
 * JPA-specific methods.
 * 
 * Inherited Operations:
 * - save(Teacher) - Create or update a teacher
 * - findById(Long) - Find teacher by ID
 * - findAll() - Retrieve all teachers
 * - deleteById(Long) - Delete teacher by ID
 * - count() - Count total teachers
 * - existsById(Long) - Check if teacher exists
 * 
 * Custom query methods can be added here using Spring Data JPA conventions
 * or @Query annotations.
 * 
 * @author Melvin Chibanda
 * @version 1.0
 * @since 2024
 */
@Repository
public interface TeacherRepository  extends JpaRepository<Teacher, Long> {
}
