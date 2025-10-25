package com.melvin.School.Management.System.Mapper;


import com.melvin.School.Management.System.Dto.CourseDTO;
import com.melvin.School.Management.System.Model.Course;
import com.melvin.School.Management.System.Model.Student;
import com.melvin.School.Management.System.Model.Teacher;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Course Mapper Interface
 * 
 * This mapper interface uses MapStruct to provide automatic mapping between
 * Course entity and CourseDTO. MapStruct generates the implementation
 * at compile time, providing type-safe and performant mapping.
 * 
 * Configuration:
 * - componentModel = "spring" - Generates Spring-managed bean
 * - Provides static INSTANCE for direct access if needed
 * 
 * Mapping Methods:
 * - toDTO(Course) - Converts Course entity to CourseDTO
 * - toEntity(CourseDTO) - Converts CourseDTO to Course entity
 * 
 * Note: Additional mapping configuration may be needed for handling
 * teacher and student relationships between entity and DTO.
 * 
 * @author Melvin Chibanda
 * @version 1.0
 * @since 2024
 */
@Mapper(componentModel = "spring")
public interface CourseMapper {

    /**
     * Static instance for direct mapper access.
     * Prefer dependency injection in Spring applications.
     */
    CourseMapper INSTANCE = org.mapstruct.factory.Mappers.getMapper(CourseMapper.class);

    /**
     * Converts Course entity to CourseDTO.
     * 
     * @param course the Course entity to convert
     * @return CourseDTO representation of the course
     */
    @Mapping(target = "teacherId", source = "teacher")
    @Mapping(target = "studentIds", source = "students")
    CourseDTO toDTO(Course course);
    
    /**
     * Converts CourseDTO to Course entity.
     * 
     * @param courseDTO the CourseDTO to convert
     * @return Course entity representation
     */
    @Mapping(target = "teacher", ignore = true)
    @Mapping(target = "students", ignore = true)
    Course toEntity(CourseDTO courseDTO);

    /**
     * Maps a Teacher entity to its ID.
     */
    default Long mapTeacherToId(Teacher teacher) {
        return teacher != null ? teacher.getId() : null;
    }

    /**
     * Maps a Student entity to its ID.
     */
    default Long mapStudentToId(Student student) {
        return student != null ? student.getId() : null;
    }

    /**
     * Maps a list of students to their IDs.
     */
    default List<Long> mapStudentsToIds(List<Student> students) {
        if (students == null) return null;
        return students.stream()
                .map(this::mapStudentToId)
                .collect(Collectors.toList());
    }
}
