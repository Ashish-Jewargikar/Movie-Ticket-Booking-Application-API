package com.example.MovieTicket_Booking_Application.DTO.RequestDTO;


import lombok.Data;

@Data
public class TheaterEntryDto {

    //Attributes that we require
    private String name;
    private String location;

    private int classicSeatsCount;

    private int premiumSeatsCount;
}
