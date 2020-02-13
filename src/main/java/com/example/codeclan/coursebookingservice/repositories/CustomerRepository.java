package com.example.codeclan.coursebookingservice.repositories;

import com.example.codeclan.coursebookingservice.models.Course;
import com.example.codeclan.coursebookingservice.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findByBookingsCourseId(Long courseId);

    List<Customer> findByTownIgnoreCaseAndBookingsCourseId(String town, long courseId);

    List<Customer> findByTownIgnoreCaseAndBookingsCourseIdAndAgeGreaterThan(String town, Long courseId, Integer age);
}
