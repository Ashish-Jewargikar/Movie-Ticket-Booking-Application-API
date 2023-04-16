package com.example.MovieTicket_Booking_Application.Convertor;

import com.example.MovieTicket_Booking_Application.DTO.RequestDTO.TicketEntryDto;
import com.example.MovieTicket_Booking_Application.Entity.TicketEntity;

public class TicketConvertors {
    public static TicketEntity convertEntryToEntity(TicketEntryDto ticketEntryDto){
        TicketEntity ticketEntity = new TicketEntity();
        return ticketEntity;
    }
}
