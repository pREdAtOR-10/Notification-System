package com.crackify.notification.service.services;

import com.crackify.notification.service.factory.NotificationSenderFactory;
import com.crackify.notification.service.models.Notification;
import com.crackify.notification.service.models.NotificationChannel;
import com.crackify.notification.service.models.NotificationStatus;
import com.crackify.notification.service.senders.INotificationSender;

public class NotificationProcessor {

    NotificationSenderFactory factory;

    private static final int MAX_RETRY  = 3;

    public NotificationProcessor(NotificationSenderFactory factory) {
        this.factory = factory;
    }

    public void processNotification(Notification notification) {
        NotificationChannel channel = notification.getChannel();
        INotificationSender sender = factory.getSender(channel);

        boolean success = false;

        while(!success && notification.getRetryCount() < MAX_RETRY){
            try{
                sender.send(notification);
                notification.setStatus(NotificationStatus.DELIVERED);
                success = true;
            } catch (Exception e) {
                notification.setRetryCount(notification.getRetryCount() + 1);
            }
        }
        if(!success){
            notification.setStatus(NotificationStatus.FAILED);
            System.out.println("Failed to send notification to " + notification.getUserId() + " with message " + notification.getMessage() + " via " + channel);
        }
    }
}
