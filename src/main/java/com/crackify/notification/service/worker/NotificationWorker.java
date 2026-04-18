package com.crackify.notification.service.worker;

import com.crackify.notification.service.models.Notification;
import com.crackify.notification.service.queue.NotificationQueue;
import com.crackify.notification.service.services.NotificationProcessor;

public class NotificationWorker implements Runnable{
    private NotificationQueue queue;
    private NotificationProcessor processor;

    public NotificationWorker(NotificationQueue queue, NotificationProcessor processor) {
        this.queue = queue;
        this.processor = processor;
    }

    @Override
    public void run() {
        while (true){
            try{
                Notification notification = queue.dequeue();
                if(notification == null) {
                    continue;
                }
                processor.processNotification(notification);
            }catch (Exception e) {
                Thread.currentThread().interrupt();
                break;
            }
        }

    }
}
