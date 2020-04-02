package com.example.codeclan.coursetracker.repositories;


import com.example.codeclan.coursetracker.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    // Get all bookings for a given date

    // What do we want - List<Booking>

    List<Booking> findByDateIgnoreCase(String date);
}
