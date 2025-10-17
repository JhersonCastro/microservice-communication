package co.edu.unicauca.notification_microservice.service;

import co.edu.unicauca.notification_microservice.entity.FormatANotification;

public interface INotificationService {
    void sendNotification(FormatANotification request);
}
