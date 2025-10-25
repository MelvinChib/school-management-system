package com.melvin.School.Management.System.Service;

import com.melvin.School.Management.System.Dto.CourseDTO;

import java.util.List;

/**
 * Course Service Interface
 * 
 * This service interface defines the business logic operations for managing courses
 * in the school management system. It provides an abstraction layer between
 * the controller and repository layers.
 * 
 * Operations:
 * - Create new courses
 * - Retrieve course information
 * - Update existing courses
 * - Delete courses
 * - List all courses
 * 
 * All operations work with CourseDTO objects to maintain separation
 * between the service layer and data persistence layer.
 * 
 * @author Melvin Chibanda
 * @version 1.0
 * @since 2024
 */
public interface CourseService {

    /**
     * Creates a new course in the system.
     * 
     * @param courseDTO the course data to create
     * @return the created course with generated ID
     * @throws IllegalArgumentException if courseDTO is null or invalid
     */
    CourseDTO createCourse(CourseDTO courseDTO);
    
    /**
     * Retrieves a course by its unique identifier.
     * 
     * @param id the unique identifier of the course
     * @return the course data if found
     * @throws RuntimeException if course with given ID doesn't exist
     */
    CourseDTO getCourseById(Long id);
    
    /**
     * Retrieves all courses in the system.
     * 
     * @return list of all courses, empty list if no courses exist
     */
    List<CourseDTO> getAllCourses();
    
    /**
     * Updates an existing course's information.
     * 
     * @param id the unique identifier of the course to update
     * @param courseDTO the updated course data
     * @return the updated course information
     * @throws RuntimeException if course with given ID doesn't exist
     * @throws IllegalArgumentException if courseDTO is null or invalid
     */
    CourseDTO updateCourse(Long id, CourseDTO courseDTO);
    
    /**
     * Deletes a course from the system.
     * 
     * @param id the unique identifier of the course to delete
     * @throws RuntimeException if course with given ID doesn't exist
     */
    void deleteCourse(Long id);
}