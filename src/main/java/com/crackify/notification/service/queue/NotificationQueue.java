package com.crackify.notification.service.queue;

import com.crackify.notification.service.models.Notification;

import java.util.LinkedList;
import java.util.Queue;

public class NotificationQueue {

    Queue<Notification> queue;

    public NotificationQueue() {
        this.queue = new LinkedList<>();
    }

    public void enqueue(Notification notification) {
        queue.offer(notification);
    }

    public Notification dequeue() {
        if(isEmpty()) {
            return null;
        }
        return queue.poll();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}
