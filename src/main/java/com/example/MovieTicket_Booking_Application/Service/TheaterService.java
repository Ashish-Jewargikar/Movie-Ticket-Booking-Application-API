package com.example.MovieTicket_Booking_Application.Service;

import com.example.MovieTicket_Booking_Application.Convertor.TheaterConverters;
import com.example.MovieTicket_Booking_Application.DTO.RequestDTO.TheaterEntryDto;
import com.example.MovieTicket_Booking_Application.Entity.TheaterEntity;
import com.example.MovieTicket_Booking_Application.Entity.TheaterSeatEntity;
import com.example.MovieTicket_Booking_Application.Enum.SeatType;
import com.example.MovieTicket_Booking_Application.Repository.TheaterRepository;
import com.example.MovieTicket_Booking_Application.Repository.TheaterSeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TheaterService {

    @Autowired
    TheaterRepository theaterRepository;

    @Autowired
    TheaterSeatRepository theaterSeatRepository;

    public String addTheater(TheaterEntryDto theaterEntryDto) throws Exception{

        if(theaterEntryDto.getLocation()==null || theaterEntryDto.getName()==null){
            throw new Exception("Name or Location not Found");
        }
        TheaterEntity theaterEntity = TheaterConverters.convertDtoToEntity(theaterEntryDto);
        List<TheaterSeatEntity> theaterSeatEntities = createTheaterSeats(theaterEntryDto,theaterEntity);
        theaterEntity.setTheaterSeatEntityList(theaterSeatEntities);
        theaterRepository.save(theaterEntity);
        return "Theatre Added";
    }

    private List<TheaterSeatEntity> createTheaterSeats(TheaterEntryDto theaterEntryDto,TheaterEntity theaterEntity) {
     int classicSeats = theaterEntryDto.getClassicSeatsCount();
     int premiumSeats = theaterEntryDto.getPremiumSeatsCount();

     List<TheaterSeatEntity> theaterSeatEntityList = new ArrayList<>();
     for(int count = 1;count<=classicSeats;count++){
         TheaterSeatEntity theaterSeatEntity = TheaterSeatEntity.builder()
                 .seatType(SeatType.CLASSIC)
                 .seatNo(count+"C")
                 .theaterEntity(theaterEntity)
                 .build();
         theaterSeatEntityList.add(theaterSeatEntity);
     }

     for(int count=1;count<=premiumSeats;count++){
         TheaterSeatEntity theaterSeatEntity = TheaterSeatEntity.builder()
                 .seatType(SeatType.PREMIUM)
                 .seatNo(count+"P")
                 .theaterEntity(theaterEntity)
                 .build();
         theaterSeatEntityList.add(theaterSeatEntity);
     }
     return theaterSeatEntityList;
    }
}
