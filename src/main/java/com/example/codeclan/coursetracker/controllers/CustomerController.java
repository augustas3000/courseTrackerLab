package com.example.codeclan.coursetracker.controllers;


import com.example.codeclan.coursetracker.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/customers")
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    // /customers
    // /customers?courseName=Java
    // /customers?town=Glasgow&courseName=Java
    // /customers?age=30&town=Glasgow&courseName=Java

    // do the all restful routes

    @GetMapping
    public ResponseEntity findCustomerQueryString(
            @RequestParam(required = false, name = "courseName") String courseName,
            @RequestParam(required = false, name = "town") String town,
            @RequestParam(required = false, name = "age") Integer age
    )
    {
        if (age != null && town != null && courseName != null){
            return new ResponseEntity<>(customerRepository.findByAgeGreaterThanAndTownIgnoreCaseAndBookingsCourseNameIgnoreCase(age, town, courseName), HttpStatus.OK);
        }

        if (town != null && courseName != null){
            return new ResponseEntity<>(customerRepository.findByTownIgnoreCaseAndBookingsCourseNameIgnoreCase(town, courseName), HttpStatus.OK);
        }
        if (courseName != null) {
            return new ResponseEntity<>(customerRepository.findByBookingsCourseNameIgnoreCase(courseName), HttpStatus.OK);
        }

        return new ResponseEntity<>(customerRepository.findAll(), HttpStatus.OK);
    }
}
