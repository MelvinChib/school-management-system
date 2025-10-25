package com.melvin.School.Management.System.Service;

import com.melvin.School.Management.System.Dto.TeacherDTO;

import java.util.List;

/**
 * Teacher Service Interface
 * 
 * This service interface defines the business logic operations for managing teachers
 * in the school management system. It provides an abstraction layer between
 * the controller and repository layers.
 * 
 * Operations:
 * - Create new teachers
 * - Retrieve teacher information
 * - Update existing teachers
 * - Delete teachers
 * - List all teachers
 * 
 * All operations work with TeacherDTO objects to maintain separation
 * between the service layer and data persistence layer.
 * 
 * @author Melvin Chibanda
 * @version 1.0
 * @since 2024
 */
public interface TeacherService {

    /**
     * Creates a new teacher in the system.
     * 
     * @param teacherDTO the teacher data to create
     * @return the created teacher with generated ID
     * @throws IllegalArgumentException if teacherDTO is null or invalid
     */
    TeacherDTO createTeacher(TeacherDTO teacherDTO);
    
    /**
     * Retrieves a teacher by their unique identifier.
     * 
     * @param id the unique identifier of the teacher
     * @return the teacher data if found
     * @throws EntityNotFoundException if teacher with given ID doesn't exist
     */
    TeacherDTO getTeacherById(Long id);
    
    /**
     * Retrieves all teachers in the system.
     * 
     * @return list of all teachers, empty list if no teachers exist
     */
    List<TeacherDTO> getAllTeachers();
    
    /**
     * Updates an existing teacher's information.
     * 
     * @param id the unique identifier of the teacher to update
     * @param teacherDTO the updated teacher data
     * @return the updated teacher information
     * @throws EntityNotFoundException if teacher with given ID doesn't exist
     * @throws IllegalArgumentException if teacherDTO is null or invalid
     */
    TeacherDTO updateTeacher(Long id, TeacherDTO teacherDTO);
    
    /**
     * Deletes a teacher from the system.
     * 
     * @param id the unique identifier of the teacher to delete
     * @throws EntityNotFoundException if teacher with given ID doesn't exist
     */
    void deleteTeacher(Long id);
}
