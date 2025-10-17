package co.edu.unicauca.submission.microservice.interfaces;

import co.edu.unicauca.submission.microservice.model.Notification;
import co.edu.unicauca.submission.microservice.DTOs.NotificationResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "notification-service", url = "http://localhost:8081")
public interface NotificationClient {

    @PostMapping("/api/notifications/formata")
    NotificationResponse enviarNotificacion(@RequestBody Notification anteproyecto);
}