package com.example.codeclan.coursetracker.repositories;


import com.example.codeclan.coursetracker.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

        // Get all customers for a given course

        // What we want - List<Customer>

        //

        List<Customer> findByBookingsCourseNameIgnoreCase(String courseName);


        // Get all customers in a given town for a given course

        List<Customer> findByTownIgnoreCaseAndBookingsCourseNameIgnoreCase(String town, String CourseName);

        // Get all customers over a certain age in a given town for a given course

        List<Customer> findByAgeGreaterThanAndTownIgnoreCaseAndBookingsCourseNameIgnoreCase(int age, String town, String CourseName);

}
