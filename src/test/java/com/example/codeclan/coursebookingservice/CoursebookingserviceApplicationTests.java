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
	public void canGetAllCourses() {
		List<Course> found = courseRepository.findAll();
		assertEquals(4, found.size());
	}

	@Test
	public void canGetAllCoursesByRating() {
		List<Course> found = courseRepository.findByRating(4);
		assertEquals(2, found.size());
	}

	@Test
	public void canGetAllCoursesByCustomer() {
		List<Course> found = courseRepository.findByBookingsCustomerId(1L);
		assertEquals(3, found.size());
	}

	@Test
	public void canGetAllCustomersByCourse() {
		List<Customer> found = customerRepository.findByBookingsCourseId(1L);
		assertEquals(4, found.size());
	}

	@Test
	public void canGetBookingsByDate(){
		List<Booking> found = bookingRepository.findByDate("14/02/2020");
		assertEquals(3, found.size());
	}

	@Test
	public void canGetCustomersByTownAndCourse(){
		List<Customer> found = customerRepository.findByTownIgnoreCaseAndBookingsCourseId("Cumbernauld", 4L);
		assertEquals(2, found.size());
	}

	@Test
	public void canGetCustomersByTownAndCourseOverACertainAge(){
		List<Customer> found = customerRepository.findByTownIgnoreCaseAndBookingsCourseIdAndAgeGreaterThan("Cumbernauld", 4L, 29);
		assertEquals(1, found.size());
	}

}
