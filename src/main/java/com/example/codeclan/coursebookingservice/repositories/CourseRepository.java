package com.example.codeclan.coursebookingservice.repositories;

import com.example.codeclan.coursebookingservice.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findByRating(int rating);

    List<Course> findByBookingsCustomerId(Long id);
}
