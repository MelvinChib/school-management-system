package com.melvin.School.Management.System.Service;

import com.melvin.School.Management.System.Dto.StudentDTO;

import java.util.List;

/**
 * Student Service Interface
 * 
 * This service interface defines the business logic operations for managing students
 * in the school management system. It provides an abstraction layer between
 * the controller and repository layers.
 * 
 * Operations:
 * - Create new students
 * - Retrieve student information
 * - Update existing students
 * - Delete students
 * - List all students
 * 
 * All operations work with StudentDTO objects to maintain separation
 * between the service layer and data persistence layer.
 * 
 * @author Melvin Chibanda
 * @version 1.0
 * @since 2024
 */
public interface StudentService {

    /**
     * Creates a new student in the system.
     * 
     * @param studentDTO the student data to create
     * @return the created student with generated ID
     * @throws IllegalArgumentException if studentDTO is null or invalid
     */
    StudentDTO createStudent(StudentDTO studentDTO);
    
    /**
     * Retrieves a student by their unique identifier.
     * 
     * @param id the unique identifier of the student
     * @return the student data if found
     * @throws RuntimeException if student with given ID doesn't exist
     */
    StudentDTO getStudentById(Long id);
    
    /**
     * Retrieves all students in the system.
     * 
     * @return list of all students, empty list if no students exist
     */
    List<StudentDTO> getAllStudents();
    
    /**
     * Updates an existing student's information.
     * 
     * @param id the unique identifier of the student to update
     * @param studentDTO the updated student data
     * @return the updated student information
     * @throws RuntimeException if student with given ID doesn't exist
     * @throws IllegalArgumentException if studentDTO is null or invalid
     */
    StudentDTO updateStudent(Long id, StudentDTO studentDTO);
    
    /**
     * Deletes a student from the system.
     * 
     * @param id the unique identifier of the student to delete
     * @throws RuntimeException if student with given ID doesn't exist
     */
    void deleteStudent(Long id);
}