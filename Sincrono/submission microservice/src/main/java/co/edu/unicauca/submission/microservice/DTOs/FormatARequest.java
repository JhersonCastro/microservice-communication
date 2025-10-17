package co.edu.unicauca.submission.microservice.DTOs;

import lombok.Data;

@Data
public class FormatARequest {
    private String title;
    private String studentEmail;
    private String departmentHeadEmail;
    private String director1Email;
    private String director2Email;
}