package com.melvin.School.Management.System.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * Course Entity
 * 
 * Represents a course in the school management system.
 * This entity stores course information and maintains relationships
 * with teachers and students.
 * 
 * Database Table: courses
 * 
 * Relationships:
 * - Many-to-One with Teacher (each course has one teacher)
 * - Many-to-Many with Student (through student_courses join table)
 * 
 * @author Melvin Chibanda
 * @version 1.0
 * @since 2024
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "courses")
public class Course {

    /**
     * Unique identifier for the course.
     * Auto-generated using database identity strategy.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Course name.
     * Required field, cannot be null.
     */
    @Column(name = "name", nullable = false)
    private String name;

    /**
     * Course description.
     * Optional field providing additional details about the course.
     */
    @Column(name = "description")
    private String description;

    /**
     * Teacher assigned to this course.
     * Many-to-One relationship with Teacher entity.
     * Required field, each course must have a teacher.
     */
    @ManyToOne
    @JoinColumn(name = "teacher_id", nullable = false)
    private Teacher teacher;

    /**
     * List of students enrolled in this course.
     * Many-to-Many relationship with Student entity.
     * Uses student_courses join table for mapping.
     */
    @ManyToMany
    @JoinTable(
        name = "student_courses",
        joinColumns = @JoinColumn(name = "course_id"),
        inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private List<Student> students = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
