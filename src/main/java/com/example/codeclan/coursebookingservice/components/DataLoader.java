package com.example.codeclan.coursebookingservice.components;

import com.example.codeclan.coursebookingservice.models.Booking;
import com.example.codeclan.coursebookingservice.models.Course;
import com.example.codeclan.coursebookingservice.models.Customer;
import com.example.codeclan.coursebookingservice.repositories.BookingRepository;
import com.example.codeclan.coursebookingservice.repositories.CourseRepository;
import com.example.codeclan.coursebookingservice.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public void run(ApplicationArguments args) {

        bookingRepository.deleteAll();
        courseRepository.deleteAll();
        customerRepository.deleteAll();

        Course software = new Course("Professional Software Development", "Glasgow", 5);
        Course data = new Course("Data Analysis", "Glasgow", 4);
        Course web = new Course("Full-Stack Web Development", "Edinburgh", 3);
        Course python = new Course("Python for Developers", "Inverness", 4);

        courseRepository.save(software);
        courseRepository.save(data);
        courseRepository.save(web);
        courseRepository.save(python);

        Customer ellie = new Customer("Ellie", "Cumbernauld", 30);
        Customer greg = new Customer("Greg", "Kirky", 32);
        Customer sven = new Customer("Sven", "Cumbernauld", 22);
        Customer grant = new Customer("Grant", "Drygate", 26);
        Customer alan = new Customer("Alan", "Bridgeton", 33);

        customerRepository.save(ellie);
        customerRepository.save(greg);
        customerRepository.save(sven);
        customerRepository.save(grant);
        customerRepository.save(alan);

        Booking booking1 = new Booking("14/02/2020", ellie, software);
        Booking booking2 = new Booking("14/06/2020", ellie, data);
        Booking booking3 = new Booking("14/03/2020", ellie, python);
        Booking booking4 = new Booking("14/02/2020", greg, software);
        Booking booking5 = new Booking("06/07/2020", greg, web);
        Booking booking6 = new Booking("21/02/2020", sven, software);
        Booking booking7 = new Booking("06/07/2020", grant, web);
        Booking booking8 = new Booking("14/02/2020", alan, software);
        Booking booking9 = new Booking("14/03/2020", sven, python);
        Booking booking10 = new Booking("13/08/2020", alan, web);

        bookingRepository.save(booking1);
        bookingRepository.save(booking2);
        bookingRepository.save(booking3);
        bookingRepository.save(booking4);
        bookingRepository.save(booking5);
        bookingRepository.save(booking6);
        bookingRepository.save(booking7);
        bookingRepository.save(booking8);
        bookingRepository.save(booking9);
        bookingRepository.save(booking10);

    }
}
