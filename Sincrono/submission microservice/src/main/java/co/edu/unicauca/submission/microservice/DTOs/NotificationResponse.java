package co.edu.unicauca.submission.microservice.DTOs;

import lombok.Data;

@Data
public class NotificationResponse {
    private String message;
    private String status;

    // Constructor vacío necesario para Jackson (deserialización JSON)
    public NotificationResponse() {}

    public NotificationResponse(String message) {
        this.message = message;
        this.status = "SUCCESS";
    }

    public NotificationResponse(String message, String status) {
        this.message = message;
        this.status = status;
    }
}