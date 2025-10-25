package com.melvin.School.Management.System.Repository;


import com.melvin.School.Management.System.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Student Repository Interface
 * 
 * This repository interface provides data access operations for Student entities.
 * It extends JpaRepository to inherit standard CRUD operations and additional
 * JPA-specific methods.
 * 
 * Inherited Operations:
 * - save(Student) - Create or update a student
 * - findById(Long) - Find student by ID
 * - findAll() - Retrieve all students
 * - deleteById(Long) - Delete student by ID
 * - count() - Count total students
 * - existsById(Long) - Check if student exists
 * 
 * Custom query methods can be added here using Spring Data JPA conventions
 * or @Query annotations.
 * 
 * @author Melvin Chibanda
 * @version 1.0
 * @since 2024
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
