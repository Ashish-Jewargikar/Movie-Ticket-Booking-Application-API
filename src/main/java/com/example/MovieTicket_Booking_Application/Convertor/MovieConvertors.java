package com.example.MovieTicket_Booking_Application.Convertor;

import com.example.MovieTicket_Booking_Application.DTO.RequestDTO.MovieEntryDto;
import com.example.MovieTicket_Booking_Application.Entity.MovieEntity;

public class MovieConvertors {
    public static MovieEntity convertEntryDtoToEntity(MovieEntryDto movieEntryDto){
        MovieEntity movieEntity = MovieEntity.builder()
                .movieName(movieEntryDto.getMovieName())
                .duration(movieEntryDto.getDuration())
                .genre(movieEntryDto.getGenre())
                .language(movieEntryDto.getLanguage())
                .ratings(movieEntryDto.getRatings())
                .build();
        return movieEntity;
    }
}
