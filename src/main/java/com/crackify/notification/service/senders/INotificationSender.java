package com.crackify.notification.service.senders;

import com.crackify.notification.service.models.Notification;

public interface INotificationSender {

    public void send(Notification notification) throws Exception;
}
