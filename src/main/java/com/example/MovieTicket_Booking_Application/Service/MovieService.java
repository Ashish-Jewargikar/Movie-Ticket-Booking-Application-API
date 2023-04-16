package com.example.MovieTicket_Booking_Application.Service;

import com.example.MovieTicket_Booking_Application.Convertor.MovieConvertors;
import com.example.MovieTicket_Booking_Application.DTO.RequestDTO.MovieEntryDto;
import com.example.MovieTicket_Booking_Application.Entity.MovieEntity;
import com.example.MovieTicket_Booking_Application.Repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public String addMovie(MovieEntryDto movieEntryDto)throws Exception {


        MovieEntity movieEntity = MovieConvertors.convertEntryDtoToEntity(movieEntryDto);

        movieRepository.save(movieEntity);

        return "Movie Added successfully";
    }
    }
