package co.edu.unicauca.notification_microservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class FormatANotification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String idFormatA;
    private String title;
    private String departmentEmail;
    private String studentEmail;
    private String director;
    private String codirector;
}