package com.crackify.notification.service.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class NotificationRequest {

    private String userId;
    private String message;
    private List<NotificationChannel> channels;

    public NotificationRequest(String userId, String message, List<NotificationChannel> channels) {
        this.userId = userId;
        this.message = message;
        this.channels = channels;
    }
}
