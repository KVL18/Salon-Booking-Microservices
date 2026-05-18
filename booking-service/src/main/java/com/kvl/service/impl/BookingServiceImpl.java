package com.kvl.service.impl;


import com.kvl.domain.BookingStatus;
import com.kvl.dto.BookingRequest;
import com.kvl.dto.SalonDTO;
import com.kvl.dto.ServiceDTO;
import com.kvl.dto.UserDTO;
import com.kvl.model.Booking;
import com.kvl.model.SalonReport;
import com.kvl.repository.BookingRepository;
import com.kvl.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;


    @Override
    public Booking createBooking(BookingRequest booking, UserDTO user,
                                 SalonDTO salon, Set<ServiceDTO> servicesDTOSet) throws Exception {
         int totaltDuration = servicesDTOSet.stream().mapToInt(ServiceDTO::getDuration)
                 .sum();

        LocalDateTime bookingStartTime = booking.getStartTime();
        LocalDateTime bookingEndTime = bookingStartTime.plusMinutes(totaltDuration);

        Boolean isSlotAvailable = isTimeSlotAvailable(salon,bookingStartTime,bookingEndTime);
        int totalPrice = servicesDTOSet.stream()
                .mapToInt(ServiceDTO::getPrice).sum();

        Set<Long>idList = servicesDTOSet.stream().map(ServiceDTO::getId)
                .collect(Collectors.toSet());

        Booking newBooking = new Booking();
        newBooking.setCustomerId(user.getId());
        newBooking.setSalonId(salon.getId());
        newBooking.setServiceIds(idList);
        newBooking.setStatus(BookingStatus.PENDING);
        newBooking.setStartTime(bookingStartTime);
        newBooking.setEndTime(bookingEndTime);
        newBooking.setTotalPrice(totalPrice);

        return bookingRepository.save(newBooking);


    }

    public Boolean isTimeSlotAvailable(SalonDTO salonDTO,
                                       LocalDateTime bookingStartTime,
                                       LocalDateTime bookingEndTime) throws Exception {
        List<Booking> existingBookings = getBookingsBySalon(salonDTO.getId());
        LocalDateTime salonOpenTime = salonDTO.getOpenTime()
                .atDate(bookingStartTime.toLocalDate());
        LocalDateTime salonCloseTime = salonDTO.getCloseTime().atDate(bookingStartTime.toLocalDate());

        if(bookingStartTime.isBefore(salonOpenTime)
                || bookingEndTime.isAfter(salonCloseTime)){
            throw  new Exception("Booking time must be within salon working hours");
        }
        for(Booking existingBooking : existingBookings){
            LocalDateTime existingBookingStartTime = existingBooking.getStartTime();
            LocalDateTime existingBookingEndTime = existingBooking.getEndTime();


            boolean isOverlapping =
                    (bookingStartTime.isBefore(existingBookingEndTime)
                            || bookingStartTime.isEqual(existingBookingEndTime))
                            &&
                            (bookingEndTime.isAfter(existingBookingStartTime)
                                    || bookingEndTime.isEqual(existingBookingStartTime));
            if (isOverlapping) {
                throw new Exception("Time slot is already booked");
            }
        }

        return true;


    }



    @Override
    public List<Booking> getBookingsByCustomer(Long customerId) {
         return bookingRepository.findByCustomerId(customerId);
    }

    @Override
    public List<Booking> getBookingsBySalon(Long salonId) {
        return bookingRepository.findBySalonId(salonId);
    }

    @Override
    public Booking getBookingsById(Long id) throws Exception {
        Booking booking = bookingRepository.findById(id).orElse(null);
        if(booking==null){
            throw  new Exception("bookinh not found");
        }
        return  booking;
    }

    @Override
    public Booking updateBooking(Long bookingId, BookingStatus status) throws Exception {
        Booking booking = getBookingsById(bookingId);
        booking.setStatus(status);
        return  bookingRepository.save(booking);
    }

    @Override
    public List<Booking> getBookingsByDate(LocalDate date, Long salonId) {
            List<Booking>allBooking = getBookingsBySalon(salonId);
            if(date == null){
                return allBooking;
            }
           return  allBooking.stream()
                    .filter(booking -> isSameDate(booking.getStartTime(),date) ||
                            isSameDate(booking.getEndTime(),date))
                    .collect(Collectors.toList());

    }

    private boolean isSameDate(LocalDateTime dateTime , LocalDate date){
        return dateTime.toLocalDate().isEqual(date);
    }

    @Override
    public SalonReport getSalonReport(Long salonId) {
        List<Booking> bookings = getBookingsBySalon(salonId);
        int totalEarnings = bookings.stream().mapToInt(Booking::getTotalPrice).sum();
        Integer totalBooking = bookings.size();
        List<Booking> cancelledBookings = bookings.stream().
                filter(booking -> booking.getStatus().equals(BookingStatus.CANCLE))
                .collect(Collectors.toList());
        Double totalRefund = cancelledBookings.stream().mapToDouble(
                Booking::getTotalPrice
        ).sum();

        SalonReport report = new SalonReport();
        report.setSalonId(salonId);
        report.setCancelBookings(cancelledBookings.size());
        report.setTotalBookings(totalBooking);
        report.setTotalEarnings(totalEarnings);
        report.setTotalRefunds(totalRefund);
        report.setTotalBookings(totalBooking);

        return  report;
    }
}
