package com.melvin.School.Management.System.Mapper;


import com.melvin.School.Management.System.Dto.TeacherDTO;
import com.melvin.School.Management.System.Model.Course;
import com.melvin.School.Management.System.Model.Teacher;
import org.mapstruct.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Teacher Mapper Interface
 * 
 * This mapper interface uses MapStruct to provide automatic mapping between
 * Teacher entity and TeacherDTO. It includes custom mapping logic for handling
 * the relationship between teachers and courses.
 * 
 * Configuration:
 * - componentModel = "spring" - Generates Spring-managed bean
 * - Provides static INSTANCE for direct access if needed
 * 
 * Mapping Features:
 * - Converts Course entities to course IDs in DTO
 * - Ignores courses collection when converting from DTO to entity
 * - Provides utility methods for course-ID conversions
 * 
 * @author Melvin Chibanda
 * @version 1.0
 * @since 2024
 */
@Mapper(componentModel = "spring")
public interface TeacherMapper {

    /**
     * Static instance for direct mapper access.
     * Prefer dependency injection in Spring applications.
     */
    TeacherMapper INSTANCE = org.mapstruct.factory.Mappers.getMapper(TeacherMapper.class);

    /**
     * Converts Teacher entity to TeacherDTO.
     * Maps the courses collection to courseIds list.
     * 
     * @param teacher the Teacher entity to convert
     * @return TeacherDTO representation with course IDs
     */
    @Mapping(target = "courseIds", source = "courses")
    TeacherDTO toDTO(Teacher teacher);

    /**
     * Converts TeacherDTO to Teacher entity.
     * Ignores the courses collection as it should be managed separately.
     * 
     * @param teacherDTO the TeacherDTO to convert
     * @return Teacher entity representation
     */
    @Mapping(target = "courses", ignore = true)
    Teacher toEntity(TeacherDTO teacherDTO);

    /**
     * Maps a Course entity to its ID.
     * Used by MapStruct for automatic course-to-ID conversion.
     * 
     * @param course the Course entity
     * @return the course ID, or null if course is null
     */
    default Long mapCourseToId(com.melvin.School.Management.System.Model.Course course) {
        return course != null ? course.getId() : null;
    }

    /**
     * Maps a list of course IDs to Course entities.
     * Creates Course entities with only ID populated.
     * 
     * @param courseIds list of course IDs
     * @return list of Course entities with IDs set
     */
    @Named("idsToCourses")
    default List<Course> mapIdsToCourses(List<Long> courseIds) {
        if (courseIds == null) return null;
        return courseIds.stream().map(id -> {
            Course c = new Course();
            c.setId(id);
            return c;
        }).collect(Collectors.toList());
    }
}
