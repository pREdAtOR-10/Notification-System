package com.crackify.notification.service.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Notification {
    private String id;
    private String userId;
    private String message;
    private NotificationStatus status;
    private int retryCount;
    private NotificationChannel channel;

    public Notification(String id, String userId, String message, NotificationChannel channel) {
        this.id = id;
        this.userId = userId;
        this.message = message;
        this.status = status;
        this.retryCount = 0;
        this.channel = channel;
    }
    public Notification(String id, String userId, String message, NotificationStatus status, NotificationChannel channel) {
        this.id = id;
        this.userId = userId;
        this.message = message;
        this.status = status;
        this.retryCount = 0;
        this.channel = channel;
    }

}
