package com.example.codeclan.coursebookingservice.controllers;

import com.example.codeclan.coursebookingservice.models.Course;
import com.example.codeclan.coursebookingservice.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    CourseRepository courseRepository;

    @GetMapping(value = "/courses")
    public ResponseEntity<List<Course>> findCoursesByRatingOrCustomer(
            @RequestParam (required=false, name="rating") Integer rating,
            @RequestParam (required=false, name="id") Long id) {

        if(rating != null){
            List<Course> foundCourse = courseRepository.findByRating(rating);
            return new ResponseEntity<>(foundCourse, HttpStatus.OK);
        }

        if(id != null){
            List<Course> foundCourse = courseRepository.findByBookingsCustomerId(id);
            return new ResponseEntity<>(foundCourse, HttpStatus.OK);
        }

        return new ResponseEntity<>(courseRepository.findAll(), HttpStatus.OK);
    }

}
