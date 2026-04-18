package com.crackify.notification.service.factory;

import com.crackify.notification.service.models.NotificationChannel;
import com.crackify.notification.service.senders.EmailNotificationSender;
import com.crackify.notification.service.senders.INotificationSender;
import com.crackify.notification.service.senders.PushNotificationSender;
import com.crackify.notification.service.senders.SmsNotificationSender;

import java.util.HashMap;
import java.util.Map;

import static com.crackify.notification.service.models.NotificationChannel.*;

public class NotificationSenderFactory {

    Map<NotificationChannel, INotificationSender> senderMap = new HashMap<>();

    public NotificationSenderFactory(){
        senderMap.put(NotificationChannel.EMAIL, new EmailNotificationSender());
        senderMap.put(NotificationChannel.SMS, new SmsNotificationSender());
        senderMap.put(NotificationChannel.PUSH_NOTIFICATION, new PushNotificationSender());
    }

    public INotificationSender getSender(NotificationChannel channel) {
        if(channel == EMAIL){
            return senderMap.get(NotificationChannel.EMAIL);
        } else if(channel == SMS){
            return senderMap.get(NotificationChannel.SMS);
        } else if(channel == PUSH_NOTIFICATION){
            return senderMap.get(NotificationChannel.PUSH_NOTIFICATION);
        }
        throw new IllegalArgumentException("Invalid channel");
    }
}
