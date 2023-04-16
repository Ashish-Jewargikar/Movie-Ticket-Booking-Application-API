package com.example.MovieTicket_Booking_Application.DTO.RequestDTO;

import com.example.MovieTicket_Booking_Application.Enum.Genre;
import com.example.MovieTicket_Booking_Application.Enum.Language;
import lombok.Data;

@Data
public class MovieEntryDto {

    private String movieName;

    private double ratings;

    private int duration;

    private Language language;

    private Genre genre;

}
