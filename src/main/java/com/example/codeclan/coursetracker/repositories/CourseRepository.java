package com.example.codeclan.coursetracker.repositories;


import com.example.codeclan.coursetracker.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    // Get all courses with a given rating

    // What do we want - List<Course>

    // What do we have - int rating

    List<Course> findByRating(int rating);

    // Get all courses for a given customer

    // What do we want - List<Course>

    List<Course> findByBookingsCustomerName(String customerName);
}
