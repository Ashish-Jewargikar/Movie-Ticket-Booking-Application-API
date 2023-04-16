package com.example.MovieTicket_Booking_Application.Service;

import com.example.MovieTicket_Booking_Application.Convertor.ShowConvertors;
import com.example.MovieTicket_Booking_Application.DTO.RequestDTO.ShowEntryDto;
import com.example.MovieTicket_Booking_Application.Entity.*;
import com.example.MovieTicket_Booking_Application.Enum.SeatType;
import com.example.MovieTicket_Booking_Application.Repository.MovieRepository;
import com.example.MovieTicket_Booking_Application.Repository.ShowRepository;
import com.example.MovieTicket_Booking_Application.Repository.TheaterRepository;
import com.example.MovieTicket_Booking_Application.Repository.TheaterSeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class ShowService {
    @Autowired
    MovieRepository movieRepository;

    @Autowired
    TheaterRepository theaterRepository;

    @Autowired
    ShowRepository showRepository;

    public String addShow(ShowEntryDto showEntryDto){
        ShowEntity showEntity = ShowConvertors.convertEntryToEntity(showEntryDto);

        int movieId = showEntryDto.getMovieId();
        int theaterId = showEntryDto.getTheaterId();

        MovieEntity movieEntity = movieRepository.findById(movieId).get();
        TheaterEntity theaterEntity = theaterRepository.findById(theaterId).get();

        showEntity.setMovieEntity(movieEntity);
        showEntity.setTheaterEntity(theaterEntity);

        List<ShowSeatEntity> seatEntityList = createShowSeatEntity(showEntryDto,showEntity);
        showEntity.setListOfShowSeats(seatEntityList);

        showEntity = showRepository.save(showEntity);
        movieEntity.getShowEntityList().add(showEntity);
        theaterEntity.getShowEntityList().add(showEntity);
        movieRepository.save(movieEntity);
        theaterRepository.save(theaterEntity);
        return "The show has been added successfully";

    }

    private List<ShowSeatEntity> createShowSeatEntity(ShowEntryDto showEntryDto, ShowEntity showEntity) {

        TheaterEntity theaterEntity = showEntity.getTheaterEntity();
        List<TheaterSeatEntity> theaterSeatEntities = theaterEntity.getTheaterSeatEntityList();
        List<ShowSeatEntity> showSeatEntities = new ArrayList<>();

        for(TheaterSeatEntity theaterSeatEntity : theaterSeatEntities){

            ShowSeatEntity showSeatEntity = new ShowSeatEntity();

            showSeatEntity.setSeatNo(theaterSeatEntity.getSeatNo());
            showSeatEntity.setSeatType(theaterSeatEntity.getSeatType());

            if(theaterSeatEntity.getSeatType().equals(SeatType.CLASSIC))
                showSeatEntity.setPrice(showEntryDto.getClassicSeatPrice());

            else
                showSeatEntity.setPrice(showEntryDto.getPremiumSeatPrice());

            showSeatEntity.setBooked(false);
            showSeatEntity.setShowEntity(showEntity);

            showSeatEntities.add(showSeatEntity);
        }

        return  showSeatEntities;
    }
}
