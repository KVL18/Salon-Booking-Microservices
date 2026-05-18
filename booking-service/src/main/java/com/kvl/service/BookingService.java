package com.kvl.service;

import com.kvl.domain.BookingStatus;
import com.kvl.dto.BookingRequest;
import com.kvl.dto.SalonDTO;
import com.kvl.dto.ServiceDTO;
import com.kvl.dto.UserDTO;
import com.kvl.model.Booking;
import com.kvl.model.SalonReport;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface BookingService {

    Booking createBooking(BookingRequest booking, UserDTO user, SalonDTO salon,
                          Set<ServiceDTO>servicesDTOSet) throws Exception;

    List<Booking> getBookingsByCustomer(Long customerId);

    List<Booking> getBookingsBySalon(Long salonId);
    Booking getBookingsById(Long id) throws Exception;
    Booking updateBooking(Long BookingId , BookingStatus status) throws Exception;

    List<Booking>getBookingsByDate(LocalDate date, Long salonId);

    SalonReport getSalonReport(Long salonId);


}
