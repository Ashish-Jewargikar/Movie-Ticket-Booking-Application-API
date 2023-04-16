package com.example.MovieTicket_Booking_Application.Convertor;

import com.example.MovieTicket_Booking_Application.DTO.RequestDTO.TheaterEntryDto;
import com.example.MovieTicket_Booking_Application.Entity.TheaterEntity;

public class TheaterConverters {
    public static TheaterEntity convertDtoToEntity(TheaterEntryDto theaterEntryDto){
     return TheaterEntity.builder().location(theaterEntryDto.getLocation()).name(theaterEntryDto.getName()).build();
    }
}
