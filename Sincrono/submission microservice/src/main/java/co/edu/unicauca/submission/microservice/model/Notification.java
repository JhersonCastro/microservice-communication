package co.edu.unicauca.submission.microservice.model;

import lombok.Data;

@Data
public class Notification {
    private String idFormatA;
    private String title;
    private String departmentEmail;
    private String studentEmail;
    private String director;
    private String codirector;
}