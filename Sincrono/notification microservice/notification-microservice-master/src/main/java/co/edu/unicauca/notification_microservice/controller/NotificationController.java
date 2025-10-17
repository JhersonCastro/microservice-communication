package co.edu.unicauca.notification_microservice.controller;

import co.edu.unicauca.notification_microservice.DTOS.NotificationResponse;
import co.edu.unicauca.notification_microservice.entity.FormatANotification;
import co.edu.unicauca.notification_microservice.service.INotificationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    private static final Logger log = LoggerFactory.getLogger(NotificationController.class);

    @Autowired
    private INotificationService notificationService;

    @PostMapping("/formata")
    public ResponseEntity<NotificationResponse> notifyFormatA(
            @RequestBody FormatANotification request) {

        try {
            notificationService.sendNotification(request);
            return ResponseEntity.ok(new NotificationResponse("Notificación enviada correctamente"));
        } catch (Exception e) {
            log.error("Error al procesar notificación para el formato A: {}", request.getTitle(), e);
            return ResponseEntity
                    .status(500)
                    .body(new NotificationResponse("Error interno al enviar notificación", "ERROR"));
        }
    }
}
