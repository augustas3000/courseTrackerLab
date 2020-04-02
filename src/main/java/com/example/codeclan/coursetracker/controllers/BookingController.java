package com.example.codeclan.coursetracker.controllers;


import com.example.codeclan.coursetracker.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "bookings")
public class BookingController {

    @Autowired
    BookingRepository bookingRepository;

    // /bookings?date=June

    @GetMapping
    public ResponseEntity findBookingQueryString(
            @RequestParam(required = false, name = "date") String date){
        if (date != null){
            return new ResponseEntity<>(bookingRepository.findByDate(date), HttpStatus.OK);
        }
        return new ResponseEntity<>(bookingRepository.findAll(), HttpStatus.OK);
    }

}
