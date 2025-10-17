package co.edu.unicauca.notification_microservice.DTOS;
import lombok.Data;

@Data
public class FormatANotificacionRequest {
    private String idAnteproyecto;
    private String title;
    private String jefeDepartamentoEmail;
    private String estudianteEmail;
    private String tutor1Email;
    private String tutor2Email;
}