package com.kvl.controller;


import com.kvl.domain.BookingStatus;
import com.kvl.domain.PaymentMethod;
import com.kvl.dto.*;
import com.kvl.mapper.BookingMapper;
import com.kvl.model.Booking;
import com.kvl.model.SalonReport;
import com.kvl.service.BookingService;
import com.kvl.service.client.PaymentFeignClient;
import com.kvl.service.client.SalonFeignClient;
import com.kvl.service.client.ServiceOfferingFeignClient;
import com.kvl.service.client.UserFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/bookings")
public class BookingController {

    private final BookingService bookingService;
    private final SalonFeignClient salonFeignClient;
    private final UserFeignClient userFeignClient;
    private final ServiceOfferingFeignClient serviceOfferingFeignClient;
    private final PaymentFeignClient paymentFeignClient;


    @PostMapping
    public ResponseEntity<PaymentLinkResponse> createBooking(
            @RequestParam Long salonId,
            @RequestParam PaymentMethod paymentMethod,
            @RequestBody BookingRequest bookingRequest,
            @RequestHeader("Authorization") String jwt
            ) throws Exception {
        UserDTO user = userFeignClient.getUserProfile(jwt).getBody();

        SalonDTO salon = salonFeignClient.getSalonById(salonId).getBody();

        Set<ServiceDTO> serviceDTOSet = serviceOfferingFeignClient.getServicesIds(
                bookingRequest.getServicesIds()
        ).getBody();

        if(serviceDTOSet.isEmpty()){
            throw new Exception("service not found");
        }

        Booking booking = bookingService.createBooking(bookingRequest,
                user,salon,
                serviceDTOSet);

        BookingDTO bookingDTO = BookingMapper.toDTO(booking);

        PaymentLinkResponse res = paymentFeignClient.createPaymentLink(
                bookingDTO, paymentMethod, jwt
                ).getBody();

        return ResponseEntity.ok(res);

    }

    @GetMapping("/customer")
    public ResponseEntity<Set<BookingDTO>> getBookingsByCustomer(
            @RequestHeader("Authorization") String jwt
    ) throws Exception {
        UserDTO user = userFeignClient.getUserProfile(jwt).getBody();
        if(user==null && user.getId()==null){
            throw  new Exception("user not found from jwt token");
        }
        List<Booking> bookings = bookingService.getBookingsByCustomer(user.getId());
        return ResponseEntity.ok(getBookingDTOs(bookings));
    }

    @GetMapping("/salon")
    public ResponseEntity<Set<BookingDTO>> getBookingsBySalon(
            @RequestHeader("Authorization") String jwt
    ) throws Exception {
        SalonDTO salonDTO = salonFeignClient.getSalonByOwnerId(jwt).getBody();
        List<Booking> bookings = bookingService.getBookingsBySalon(salonDTO.getId());
        return ResponseEntity.ok(getBookingDTOs(bookings));
    }



    private Set<BookingDTO> getBookingDTOs(List<Booking> bookings){
        return bookings.stream().map(booking->{
            return BookingMapper.toDTO(booking);
        }).collect(Collectors.toSet());
    }

    @GetMapping("/{bookingId}")
    public ResponseEntity<BookingDTO> getBookingsById(
            @PathVariable Long bookingId
    ) throws Exception {
        Booking booking = bookingService.getBookingsById(bookingId);
        return ResponseEntity.ok(BookingMapper.toDTO(booking));
    }

    @PutMapping("/{bookingId}/status")
    public ResponseEntity<BookingDTO> updateBookingStatus(
            @PathVariable Long bookingId,
            @RequestParam BookingStatus status
            ) throws Exception {
        Booking booking = bookingService.updateBooking(bookingId,status);
        return ResponseEntity.ok(BookingMapper.toDTO(booking));
    }

    @GetMapping("/slots/salon/{salonId}/date/{date}")
    public ResponseEntity<List<BookingSlotDTO>> getBookedSlot(
            @PathVariable Long salonId,
            @RequestParam (required = false)LocalDate date
            ) throws Exception {
        List<Booking> bookings = bookingService.getBookingsByDate(date,salonId);

        List<BookingSlotDTO> slotsDTO = bookings.stream()
                .map(booking -> {
                    BookingSlotDTO slotDTO = new BookingSlotDTO();
                    slotDTO.setEndTime(booking.getEndTime());
                    slotDTO.setStartTime(booking.getStartTime());
                    return slotDTO;
                }).collect(Collectors.toList());
        return ResponseEntity.ok(slotsDTO);
    }

    @GetMapping("/report")
    public ResponseEntity<SalonReport> getSalonReport(
       @RequestHeader("Authorization") String jwt
    ) throws Exception {
        SalonDTO salonDTO = salonFeignClient.getSalonByOwnerId(jwt).getBody();
        SalonReport report = bookingService.getSalonReport(salonDTO.getId());
        return ResponseEntity.ok(report);
    }





}
