package com.example.codeclan.coursebookingservice.repositories;

import com.example.codeclan.coursebookingservice.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}
