package co.edu.unicauca.notification_microservice.DTOS;

import lombok.Data;

@Data
public class NotificationResponse {
    private String message;
    private String status;

    public NotificationResponse(String message) {
        this.message = message;
        this.status = "SUCCESS";
    }

    public NotificationResponse(String message, String status) {
        this.message = message;
        this.status = status;
    }
}