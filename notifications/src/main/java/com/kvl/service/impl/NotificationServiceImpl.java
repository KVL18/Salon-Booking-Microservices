package com.kvl.service.impl;

import com.kvl.model.Notification;
import com.kvl.payload.dto.NotificationDTO;
import com.kvl.repository.NotificationRepository;
import com.kvl.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository notificationRepository;

    @Override
    public NotificationDTO createNotification(Notification notification) {
        return null;
    }

    @Override
    public List<Notification> getAllNotificationsByUserId(Long userId) {
        return List.of();
    }

    @Override
    public List<Notification> getAllNotificationsBySalonId(Long salonId) {
        return List.of();
    }

    @Override
    public Notification markNotificationAsRead(Long notificationId) {
        return null;
    }
}
