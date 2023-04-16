package com.example.MovieTicket_Booking_Application.Service;

import com.example.MovieTicket_Booking_Application.Convertor.UserConvertors;
import com.example.MovieTicket_Booking_Application.DTO.RequestDTO.UserEntryDto;
import com.example.MovieTicket_Booking_Application.Entity.UserEntity;
import com.example.MovieTicket_Booking_Application.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public String addUser(UserEntryDto userEntryDto) throws Exception,NullPointerException{
        UserEntity userEntity = UserConvertors.convertDtoEntity(userEntryDto);
        userRepository.save(userEntity);
        return "User added";
    }
}
