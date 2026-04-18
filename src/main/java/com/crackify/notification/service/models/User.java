package com.crackify.notification.service.models;

import java.util.List;

public class User {
    String id;
    String name;
    String email;
    String phone;

    List<NotificationChannel> channels;

    public User(String id, String name, String email, String phone, List<NotificationChannel> channels) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.channels = channels;
    }
}
