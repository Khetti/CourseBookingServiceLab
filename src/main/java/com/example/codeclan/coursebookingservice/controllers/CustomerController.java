package com.example.codeclan.coursebookingservice.controllers;
import com.example.codeclan.coursebookingservice.models.Customer;
import com.example.codeclan.coursebookingservice.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping(value="/customers")
    public ResponseEntity<List<Customer>> findCustomersByCourse(@RequestParam (required=false, name="id") Long id,
                                                                @RequestParam(required= false, name="town") String town,
                                                                @RequestParam(required=false, name="age") Integer age) {

        if(id != null && town != null && age != null){
            List<Customer> foundCustomer = customerRepository.findByTownIgnoreCaseAndBookingsCourseIdAndAgeGreaterThan(town, id, age);
            return new ResponseEntity<>(foundCustomer, HttpStatus.OK);
        }

        if(id != null && town != null){
            List<Customer> foundCustomer = customerRepository.findByTownIgnoreCaseAndBookingsCourseId(town, id);
            return new ResponseEntity<>(foundCustomer, HttpStatus.OK);
        }

        if(id != null) {
            List<Customer> foundCustomer = customerRepository.findByBookingsCourseId(id);
            return new ResponseEntity<>(foundCustomer, HttpStatus.OK);
        }

        return new ResponseEntity<>(customerRepository.findAll(), HttpStatus.OK);

    }

}
