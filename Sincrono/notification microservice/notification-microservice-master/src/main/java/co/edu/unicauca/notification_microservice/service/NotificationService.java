package co.edu.unicauca.notification_microservice.service;

import co.edu.unicauca.notification_microservice.entity.FormatANotification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class NotificationService implements INotificationService {

    private static final Logger logger = LoggerFactory.getLogger(NotificationService.class);

    @Override
    public void sendNotification(FormatANotification request) {
        StringBuilder mensaje = new StringBuilder();
        mensaje.append("\n===Notificación SÍNCRONA recibida===\n");

        // Notificación al Jefe de Departamento
        if (request.getDepartmentEmail() != null) {
            mensaje.append(String.format(
                    "\nde: sistema@fiet.edu.co \npara: %s \nasunto: Nuevo formato A registrado \nbody: El formato A '%s' con ID %s ha sido registrado y está pendiente de revisión.\n",
                    request.getDepartmentEmail(),
                    request.getTitle(),
                    request.getIdFormatA()));
        }

        // Notificación al Estudiante
        if (request.getStudentEmail() != null) {
            mensaje.append(String.format(
                    "\nde: sistema@fiet.edu.co \npara: %s \nasunto: Confirmación de subida del formato A \nbody: Tu formato A '%s' ha sido registrado exitosamente con ID %s.\n",
                    request.getStudentEmail(),
                    request.getTitle(),
                    request.getIdFormatA()));
        }

        // Notificación al director
        if (request.getDirector() != null) {
            mensaje.append(String.format(
                    "\nde: sistema@fiet.edu.co para: %s asunto: Asignación como director: Has sido asignado como director del trabajo de grado '%s' con ID %s.\n",
                    request.getDirector(),
                    request.getTitle(),
                    request.getIdFormatA()));
        }

        // Notificación al codirector
        if (request.getCodirector() != null) {
            mensaje.append(String.format(
                    "\nde: sistema@fiet.edu.co para: %s asunto: Asignación como codirector: Has sido asignado como codirector del anteproyecto '%s' con ID %s.\n",
                    request.getCodirector(),
                    request.getTitle(),
                    request.getIdFormatA()));
        }

        mensaje.append("\n===Notificaciones enviadas correctamente===\n");

        logger.info(mensaje.toString());
    }
}