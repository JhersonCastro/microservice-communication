package co.edu.unicauca.submission.microservice.service;

import co.edu.unicauca.submission.microservice.interfaces.ISubmissionService;
import co.edu.unicauca.submission.microservice.interfaces.NotificationClient;
import co.edu.unicauca.submission.microservice.model.FormatA;
import co.edu.unicauca.submission.microservice.model.Notification;
import co.edu.unicauca.submission.microservice.DTOs.FormatARequest;
import co.edu.unicauca.submission.microservice.DTOs.NotificationResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.unicauca.submission.microservice.repository.FormatARepository;

@Service
public class SubmissionService implements ISubmissionService {

    private static final Logger logger = LoggerFactory.getLogger(SubmissionService.class);

    private final FormatARepository formatARepository;
    private final NotificationClient notificationClient;

    public SubmissionService(FormatARepository formatARepository,
                             NotificationClient notificationClient) {
        this.formatARepository = formatARepository;
        this.notificationClient = notificationClient;
    }
    
    @Override
    @Transactional
    public FormatA getPreliminaryProject(Long id) {
        logger.info("Buscando anteproyecto con ID: {}", id);
        return formatARepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Anteproyecto no encontrado con ID: " + id));
    }
    
    @Override
    @Transactional
    public FormatA registerPreliminaryProject(FormatARequest request) {
        if (request.getTitle() == null || request.getDepartmentHeadEmail() == null) {
            throw new IllegalArgumentException("Título y correo del jefe de departamento son obligatorios");
        }

        logger.info("Registrando nuevo anteproyecto: {}", request.getTitle());

        FormatA formatA = new FormatA();
        formatA.setTitle(request.getTitle());
        formatA.setStudentEmail(request.getStudentEmail());
        formatA.setDepartmentHeadEmail(request.getDepartmentHeadEmail());
        formatA.setDirector1Email(request.getDirector1Email());
        formatA.setDirector2Email(request.getDirector2Email());

        FormatA saved = formatARepository.save(formatA);
        logger.info("Anteproyecto guardado en BD con ID: {}", saved.getId());

        // Preparar notificación
        Notification notification = new Notification();
        notification.setIdFormatA(saved.getId().toString());
        notification.setTitle(saved.getTitle());
        notification.setDepartmentEmail(saved.getDepartmentHeadEmail());
        notification.setStudentEmail(saved.getStudentEmail());
        notification.setDirector(saved.getDirector1Email());
        notification.setCodirector(saved.getDirector2Email());

        // LLAMADA SÍNCRONA al servicio de notificaciones
        try {
            logger.info("Enviando notificación síncrona al servicio de notificaciones para ID: {}", saved.getId());
            NotificationResponse response = notificationClient.enviarNotificacion(notification);
            logger.info("Notificación procesada. Respuesta: {}", response.getMessage());
        } catch (Exception e) {
            logger.error("Error al enviar notificación síncrona para ID: {}. Error: {}", saved.getId(), e.getMessage(), e);
        }

        return saved;
    }
}