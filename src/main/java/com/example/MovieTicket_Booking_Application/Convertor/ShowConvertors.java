package com.example.MovieTicket_Booking_Application.Convertor;

import com.example.MovieTicket_Booking_Application.DTO.RequestDTO.ShowEntryDto;
import com.example.MovieTicket_Booking_Application.Entity.ShowEntity;

public class ShowConvertors {
    public static ShowEntity convertEntryToEntity(ShowEntryDto showEntryDto){
        ShowEntity showEntity = ShowEntity.builder()
                .showDate(showEntryDto.getLocalDate())
                .showType(showEntryDto.getShowType())
                .showTime(showEntryDto.getLocalTime())
                .build();
        return showEntity;
    }
}
