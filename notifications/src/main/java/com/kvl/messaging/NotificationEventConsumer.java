package com.kvl.messaging;


import com.kvl.model.Notification;
import com.kvl.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class NotificationEventConsumer {

    private  final NotificationService notificationService;


    @RabbitListener(queues = "notification-queue")
    public void  sentNotificationEventConsumer(Notification notification) throws Exception {
        notificationService.createNotification(notification);
    }

}
