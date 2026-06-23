package com.kvl.mapper;

import com.kvl.dto.BookingDTO;
import com.kvl.model.Booking;

public class BookingMapper {

    public static BookingDTO toDTO(Booking booking){

        BookingDTO bookingDTO = new BookingDTO();

        bookingDTO.setId(booking.getId());
        bookingDTO.setCustomerId(booking.getCustomerId());
        bookingDTO.setStatus(booking.getStatus());
        bookingDTO.setEndTime(booking.getEndTime());
        bookingDTO.setStartTime(booking.getStartTime());
        bookingDTO.setServiceIds(booking.getServiceIds());
        bookingDTO.setSalonId(booking.getSalonId());
        bookingDTO.setTotalPrice(booking.getTotalPrice());


        return bookingDTO;
    }
}