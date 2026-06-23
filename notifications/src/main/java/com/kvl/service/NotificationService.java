package com.kvl.service;


import com.kvl.model.Notification;
import com.kvl.payload.dto.NotificationDTO;

import java.util.List;

public interface NotificationService {


    NotificationDTO createNotification(Notification notification);
    List<Notification> getAllNotificationsByUserId(Long userId);

    List<Notification>getAllNotificationsBySalonId(Long salonId);

    Notification markNotificationAsRead(Long notificationId);

}
