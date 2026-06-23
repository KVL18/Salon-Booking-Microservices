package com.kvl.payload.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class NotificationDTO {

    private Long id;
    private String description;
    private String type;
    private Boolean isRead=false;
    private long userId;
    private Long bookingId;
    private Long salonId;
    private LocalDateTime createdAt;
    private  BookingDTO booking;
}
