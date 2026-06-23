package com.kvl.service.impl;

import com.kvl.mapper.NotificationMapper;
import com.kvl.model.Notification;
import com.kvl.payload.dto.BookingDTO;
import com.kvl.payload.dto.NotificationDTO;
import com.kvl.repository.NotificationRepository;
import com.kvl.service.NotificationService;
import com.kvl.service.client.BookingFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository notificationRepository;
    private final BookingFeignClient bookingFeignClient;

    @Override
    public NotificationDTO createNotification(Notification notification) throws Exception {
        Notification savedNotification = notificationRepository.save(notification);

        BookingDTO bookingDTO =bookingFeignClient.getBookingsById
                (savedNotification.getBookingId()).getBody();

        NotificationDTO notificationDTO = NotificationMapper.toDTO(
                savedNotification,bookingDTO
        );
        return notificationDTO;
    }

    @Override
    public List<Notification> getAllNotificationsByUserId(Long userId) {
        return  notificationRepository.findByUserId(userId);
    }

    @Override
    public List<Notification> getAllNotificationsBySalonId(Long salonId) {
        return notificationRepository.findBySalonId(salonId);
    }

    @Override
    public Notification markNotificationAsRead(Long notificationId) throws Exception {
        return  notificationRepository.findById(notificationId).map(
                notification -> {
                    notification.setIsRead(true);
                    return notificationRepository.save(notification);
                }
        ).orElseThrow( ()->new Exception("Notification not found"));

    }
}
