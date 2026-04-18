package com.crackify.notification.service.senders;

import com.crackify.notification.service.models.Notification;

public class SmsNotificationSender implements INotificationSender{

    public SmsNotificationSender() {
        System.out.println("SmsNotificationSender initialized");
    }

    @Override
    public void send(Notification notification) throws Exception {
        int random = (int) Math.random()*10;
        if(random < 2){
            throw new Exception("Failed to send email");
        }
        System.out.println("Sms sent to " + notification.getUserId() + " with message " + notification.getMessage());
    }
}
