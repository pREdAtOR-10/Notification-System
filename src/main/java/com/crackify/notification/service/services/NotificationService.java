package com.crackify.notification.service.services;

import com.crackify.notification.service.models.Notification;
import com.crackify.notification.service.models.NotificationChannel;
import com.crackify.notification.service.models.NotificationRequest;
import com.crackify.notification.service.queue.NotificationQueue;

import java.util.List;

public class NotificationService {

    NotificationQueue queue;

    public NotificationService(NotificationQueue queue) {
        this.queue = queue;
    }

    public void sendNotification(NotificationRequest notificationRequest) {
        String userId = notificationRequest.getUserId();
        String message = notificationRequest.getMessage();
        List<NotificationChannel> channels = notificationRequest.getChannels();
        if(!channels.isEmpty()){
            for(NotificationChannel channel: channels){
                queue.enqueue(new Notification("1",userId, message, channel));
            }
        }

    }
}
