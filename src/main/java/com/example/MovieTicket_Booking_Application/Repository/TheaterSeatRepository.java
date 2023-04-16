package com.example.MovieTicket_Booking_Application.Repository;
import com.example.MovieTicket_Booking_Application.Entity.TheaterSeatEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheaterSeatRepository extends JpaRepository<TheaterSeatEntity,Integer> {
}
