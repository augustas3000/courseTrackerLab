package com.example.codeclan.coursetracker;

import com.example.codeclan.coursetracker.models.Booking;
import com.example.codeclan.coursetracker.models.Course;
import com.example.codeclan.coursetracker.models.Customer;
import com.example.codeclan.coursetracker.repositories.BookingRepository;
import com.example.codeclan.coursetracker.repositories.CourseRepository;
import com.example.codeclan.coursetracker.repositories.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CoursetrackerApplicationTests {

	@Autowired
	BookingRepository bookingRepository;

	@Autowired
	CourseRepository courseRepository;

	@Autowired
	CustomerRepository customerRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void canFindCourseByRating(){
		List<Course> foundCourses;
		foundCourses = courseRepository.findByRating(4);
	}

	@Test
	public void canFindCustomersByCourse(){
		List<Customer> foundCustomers;
		foundCustomers = customerRepository.findByBookingsCourseNameIgnoreCase("Java");
	}

	@Test
	public void canFindCourseByCustomerName(){
		List<Course> foundCourses;
		foundCourses = courseRepository.findByBookingsCustomerName("Iain");
	}

	@Test
	public void canFindBookingByDate(){
		List<Booking> foundBookings;
		foundBookings = bookingRepository.findByDateIgnoreCase("June");
	}

	@Test
	public void canFindCustomerByTownAndCourse(){
		List<Customer> foundCustomers;
		foundCustomers = customerRepository.findByTownIgnoreCaseAndBookingsCourseNameIgnoreCase("Glasgow", "Python");
	}

	@Test
	public void canFindCustomerByAgeGreaterThanAndBookingCourseName(){
		List<Customer> foundCustomer;
		foundCustomer = customerRepository.findByAgeGreaterThanAndTownIgnoreCaseAndBookingsCourseNameIgnoreCase(30, "Glasgow", "Python");
	}
}
