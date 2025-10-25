package com.melvin.School.Management.System.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * Teacher Entity
 * 
 * Represents a teacher in the school management system.
 * This entity stores teacher information and maintains relationships
 * with courses they teach.
 * 
 * Database Table: teachers
 * 
 * Relationships:
 * - One-to-Many with Course (a teacher can teach multiple courses)
 * 
 * @author Melvin Chibanda
 * @version 1.0
 * @since 2024
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "teachers")
public class Teacher {

    /**
     * Unique identifier for the teacher.
     * Auto-generated using database identity strategy.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Teacher's first name.
     * Required field, cannot be null.
     */
    @Column(name = "first_name", nullable = false)
    private String firstName;

    /**
     * Teacher's last name.
     * Required field, cannot be null.
     */
    @Column(name = "last_name", nullable = false)
    private String lastName;

    /**
     * Teacher's email address.
     * Required field, must be unique across all teachers.
     */
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    /**
     * List of courses taught by this teacher.
     * One-to-Many relationship with Course entity.
     * Cascades all operations to related courses.
     */
    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
    private List<Course> courses = new ArrayList<>();

    public void setEmail(String email) {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public void setLastName(String lastName) {
    }
}
