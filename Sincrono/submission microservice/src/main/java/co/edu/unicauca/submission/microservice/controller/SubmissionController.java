package co.edu.unicauca.submission.microservice.controller;

import co.edu.unicauca.submission.microservice.model.FormatA;
import co.edu.unicauca.submission.microservice.DTOs.FormatARequest;
import co.edu.unicauca.submission.microservice.interfaces.ISubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/submission")
public class SubmissionController {

    @Autowired
    private ISubmissionService submissionService;

    @PostMapping("/formata")
    public ResponseEntity<?> registerPreliminaryProject(@RequestBody FormatARequest request) {
        try {
            FormatA resultado = submissionService.registerPreliminaryProject(request);
            return ResponseEntity.ok(resultado);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("{\"error\": \"" + e.getMessage() + "\"}");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("{\"error\": \"Error interno\"}");
        }
    }

    @GetMapping("/formata/{id}")
    public ResponseEntity<?> getPreliminaryProject(@PathVariable Long id) {
        try {
            FormatA formatA = submissionService.getPreliminaryProject(id);
            return ResponseEntity.ok(formatA);
        } catch (Exception e) {
            return ResponseEntity.status(404).body("{\"error\": \"" + e.getMessage() + "\"}");
        }
    }
}