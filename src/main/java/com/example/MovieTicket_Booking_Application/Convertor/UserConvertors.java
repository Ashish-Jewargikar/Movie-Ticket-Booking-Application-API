package com.example.MovieTicket_Booking_Application.Convertor;

import com.example.MovieTicket_Booking_Application.DTO.RequestDTO.UserEntryDto;
import com.example.MovieTicket_Booking_Application.Entity.UserEntity;

public class UserConvertors {
    public static UserEntity convertDtoEntity(UserEntryDto userEntryDto){
        UserEntity userEntity = UserEntity.builder()
                .age(userEntryDto.getAge())
                .address(userEntryDto.getAddress())
                .email(userEntryDto.getEmail())
                .mobNo(userEntryDto.getMobNo())
                .name(userEntryDto.getName())
                .build();
        return userEntity;
    }
}
