package com.crackify.notification.service.senders;

import com.crackify.notification.service.models.Notification;

public class PushNotificationSender implements INotificationSender{

    public PushNotificationSender() {
        System.out.println("PushNotificationSender initialized");
    }
    @Override
    public void send(Notification notification) throws Exception {
        int random = (int) (Math.random()*10);
        if(random < 3){
            throw new Exception("Failed to send email");
        }
        System.out.println("Push notification sent to " + notification.getUserId() + " with message " + notification.getMessage());
    }
}
