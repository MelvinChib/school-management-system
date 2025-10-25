package com.melvin.School.Management.System.Service;


import com.melvin.School.Management.System.Dto.TeacherDTO;
import com.melvin.School.Management.System.Mapper.TeacherMapper;
import com.melvin.School.Management.System.Model.Teacher;
import com.melvin.School.Management.System.Repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Teacher Service Implementation
 * 
 * This class implements the TeacherService interface and provides concrete
 * implementations for all teacher-related business operations. It acts as
 * the service layer between controllers and repositories.
 * 
 * Responsibilities:
 * - Implements business logic for teacher operations
 * - Handles data transformation between DTOs and entities
 * - Manages transactions and error handling
 * - Validates business rules
 * 
 * Dependencies:
 * - TeacherRepository: For data persistence operations
 * - TeacherMapper: For entity-DTO conversions
 * 
 * @author Melvin Chibanda
 * @version 1.0
 * @since 2024
 */
@Service
public class TeacherServiceImpl implements TeacherService {

    /**
     * Repository for teacher data access operations.
     */
    private final TeacherRepository teacherRepository;
    
    /**
     * Mapper for converting between Teacher entities and TeacherDTOs.
     */
    private final TeacherMapper teacherMapper;

    /**
     * Constructor for dependency injection.
     * 
     * @param teacherRepository the teacher repository
     * @param teacherMapper the teacher mapper
     */
    public TeacherServiceImpl(TeacherRepository teacherRepository, TeacherMapper teacherMapper) {
        this.teacherRepository = teacherRepository;
        this.teacherMapper = teacherMapper;
    }

    /**
     * Creates a new teacher in the system.
     * Converts DTO to entity, saves to database, and returns the saved teacher as DTO.
     * 
     * @param teacherDTO the teacher data to create
     * @return the created teacher with generated ID
     * @throws IllegalArgumentException if teacherDTO is null or invalid
     */
    @Override
    public TeacherDTO createTeacher(TeacherDTO teacherDTO) {
        if (teacherDTO == null) {
            throw new IllegalArgumentException("TeacherDTO cannot be null");
        }
        
        Teacher teacher = teacherMapper.toEntity(teacherDTO);
        Teacher savedTeacher = teacherRepository.save(teacher);
        return teacherMapper.toDTO(savedTeacher);
    }

    /**
     * Retrieves a teacher by their unique identifier.
     * 
     * @param id the unique identifier of the teacher
     * @return the teacher data if found
     * @throws RuntimeException if teacher with given ID doesn't exist
     */
    @Override
    public TeacherDTO getTeacherById(Long id) {
        Teacher teacher = teacherRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Teacher not found with id: " + id));
        return teacherMapper.toDTO(teacher);
    }

    /**
     * Retrieves all teachers in the system.
     * 
     * @return list of all teachers, empty list if no teachers exist
     */
    @Override
    public List<TeacherDTO> getAllTeachers() {
        List<Teacher> teachers = teacherRepository.findAll();
        return teachers.stream()
                .map(teacherMapper::toDTO)
                .collect(Collectors.toList());
    }

    /**
     * Updates an existing teacher's information.
     * 
     * @param id the unique identifier of the teacher to update
     * @param teacherDTO the updated teacher data
     * @return the updated teacher information
     * @throws RuntimeException if teacher with given ID doesn't exist
     * @throws IllegalArgumentException if teacherDTO is null or invalid
     */
    @Override
    public TeacherDTO updateTeacher(Long id, TeacherDTO teacherDTO) {
        if (teacherDTO == null) {
            throw new IllegalArgumentException("TeacherDTO cannot be null");
        }
        
        Teacher existingTeacher = teacherRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Teacher not found with id: " + id));
        
        // Update fields
        existingTeacher.setFirstName(teacherDTO.getFirstName());
        existingTeacher.setLastName(teacherDTO.getLastName());
        existingTeacher.setEmail(teacherDTO.getEmail());
        
        Teacher updatedTeacher = teacherRepository.save(existingTeacher);
        return teacherMapper.toDTO(updatedTeacher);
    }

    /**
     * Deletes a teacher from the system.
     * 
     * @param id the unique identifier of the teacher to delete
     * @throws RuntimeException if teacher with given ID doesn't exist
     */
    @Override
    public void deleteTeacher(Long id) {
        if (!teacherRepository.existsById(id)) {
            throw new RuntimeException("Teacher not found with id: " + id);
        }
        teacherRepository.deleteById(id);
    }
}
