package com.crackify.notification.service;

import com.crackify.notification.service.factory.NotificationSenderFactory;
import com.crackify.notification.service.models.NotificationChannel;
import com.crackify.notification.service.models.NotificationRequest;
import com.crackify.notification.service.queue.NotificationQueue;
import com.crackify.notification.service.services.NotificationProcessor;
import com.crackify.notification.service.services.NotificationService;
import com.crackify.notification.service.worker.NotificationWorker;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class NotificationServiceApplication {

	public static void main(String[] args) {

		NotificationQueue queue = new NotificationQueue(); // SQS Kafka for real world

		//2nd Application
		NotificationSenderFactory factory = new NotificationSenderFactory();
		NotificationProcessor processor = new NotificationProcessor(factory);
		Thread worker = new Thread(new NotificationWorker(queue, processor));
		worker.start();


		//1st Application
		NotificationService service = new NotificationService(queue);
		NotificationRequest request = new NotificationRequest("1", "Hello", List.of(NotificationChannel.EMAIL));

		NotificationRequest request2 = new NotificationRequest("2", "Hello World 2", List.of(NotificationChannel.PUSH_NOTIFICATION));
		service.sendNotification(request);
		service.sendNotification(request2);

	}

}
