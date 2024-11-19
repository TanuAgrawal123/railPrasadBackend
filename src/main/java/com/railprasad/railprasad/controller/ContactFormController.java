package com.railprasad.railprasad.controller;
import jakarta.validation.Valid;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.railprasad.railprasad.dto.ContactFormDTO;
import com.railprasad.railprasad.model.Contactform;
import com.railprasad.railprasad.service.ContactFormService;


@RestController
@RequestMapping("contactform")
@CrossOrigin
public class ContactFormController {

    @Autowired
    private ContactFormService contactFormService;

    @PostMapping("/submit")
    public ResponseEntity<String> submitFeedbackForm(@Valid @RequestBody ContactFormDTO feedbackFormDTO) {
        try {
            Contactform feedback = contactFormService.submitFeedbackForm(feedbackFormDTO);
            return ResponseEntity.ok("Form submitted successfully! ID: " + feedback.getId());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Failed to submit Form: " + e.getMessage());
        }
    }
@GetMapping("all-entries")
public ResponseEntity<?> getAllEntries() {
    try {
        List<ContactFormDTO> entries = contactFormService.getAllEntries();
        if (entries.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No contact form entries found.");
        }
        return ResponseEntity.ok(entries);
    } catch (Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("An error occurred while fetching contact form entries: " + ex.getMessage());
    }
}
    
}