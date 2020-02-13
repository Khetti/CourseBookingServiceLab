package com.example.codeclan.coursebookingservice;

import com.example.codeclan.coursebookingservice.models.Booking;
import com.example.codeclan.coursebookingservice.models.Course;
import com.example.codeclan.coursebookingservice.models.Customer;
import com.example.codeclan.coursebookingservice.repositories.BookingRepository;
import com.example.codeclan.coursebookingservice.repositories.CourseRepository;
import com.example.codeclan.coursebookingservice.repositories.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CoursebookingserviceApplicationTests {

	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private BookingRepository bookingRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void canGetCourseByName() {
		Course course = new Course("Professional Software Development", "Glasgow", 5);
		courseRepository.save(course);
		Customer customer = new Customer("Greg", "Kirky", 21 );
		customerRepository.save(customer);
		Booking booking = new Booking("14-02-2020", customer, course);
		bookingRepository.save(booking);

	}

}
