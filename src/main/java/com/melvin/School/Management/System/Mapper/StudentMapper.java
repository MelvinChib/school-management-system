package com.melvin.School.Management.System.Mapper;


import com.melvin.School.Management.System.Dto.StudentDTO;
import com.melvin.School.Management.System.Model.Course;
import com.melvin.School.Management.System.Model.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Student Mapper Interface
 * 
 * This mapper interface uses MapStruct to provide automatic mapping between
 * Student entity and StudentDTO. MapStruct generates the implementation
 * at compile time, providing type-safe and performant mapping.
 * 
 * Configuration:
 * - componentModel = "spring" - Generates Spring-managed bean
 * - Provides static INSTANCE for direct access if needed
 * 
 * Mapping Methods:
 * - toDTO(Student) - Converts Student entity to StudentDTO
 * - toEntity(StudentDTO) - Converts StudentDTO to Student entity
 * 
 * MapStruct automatically maps fields with matching names and types.
 * Custom mapping logic can be added using @Mapping annotations.
 * 
 * @author Melvin Chibanda
 * @version 1.0
 * @since 2024
 */
@Mapper(componentModel = "spring")
public interface StudentMapper {
    
    /**
     * Static instance for direct mapper access.
     * Prefer dependency injection in Spring applications.
     */
    StudentMapper INSTANCE = org.mapstruct.factory.Mappers.getMapper(StudentMapper.class);

    /**
     * Converts Student entity to StudentDTO.
     * 
     * @param student the Student entity to convert
     * @return StudentDTO representation of the student
     */
    @Mapping(target = "courseIds", source = "courses")
    StudentDTO toDTO(Student student);
    
    /**
     * Converts StudentDTO to Student entity.
     * 
     * @param studentDTO the StudentDTO to convert
     * @return Student entity representation
     */
    @Mapping(target = "courses", ignore = true)
    Student toEntity(StudentDTO studentDTO);

    /**
     * Maps a Course entity to its ID.
     */
    default Long mapCourseToId(Course course) {
        return course != null ? course.getId() : null;
    }

    /**
     * Maps a list of course IDs to Course entities.
     */
    default List<Course> mapIdsToCourses(List<Long> courseIds) {
        if (courseIds == null) return null;
        return courseIds.stream().map(id -> {
            Course c = new Course();
            c.setId(id);
            return c;
        }).collect(Collectors.toList());
    }
}
