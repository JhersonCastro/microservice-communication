package co.edu.unicauca.submission.microservice.interfaces;

import co.edu.unicauca.submission.microservice.model.FormatA;
import co.edu.unicauca.submission.microservice.DTOs.FormatARequest;
import jakarta.transaction.Transactional;

public interface ISubmissionService {
    @Transactional
    FormatA getPreliminaryProject(Long id);
    
    @Transactional
    FormatA registerPreliminaryProject(FormatARequest request);
}