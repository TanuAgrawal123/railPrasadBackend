package com.railprasad.railprasad.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.railprasad.railprasad.dto.ContactFormDTO;
import com.railprasad.railprasad.model.Contactform;
import com.railprasad.railprasad.repository.ContactFormRepository;

@Service
public class ContactFormService {
    
@Autowired
private ContactFormRepository contactFormRepository;

  public Contactform submitFeedbackForm(ContactFormDTO feedbackFormDTO) {
        Contactform contactform = new Contactform();
        contactform.setName(feedbackFormDTO.getName());
        contactform.setEmail(feedbackFormDTO.getEmail());
        contactform.setMobileNumber(feedbackFormDTO.getMobileNumber());
        contactform.setFeedback(feedbackFormDTO.getFeedback());
        return contactFormRepository.save(contactform);
    }

 public List<ContactFormDTO> getAllEntries() {
    List<Contactform> contactForms = contactFormRepository.findAll();

    return contactForms.stream()
            .map(this::convertToDTO)
            .collect(Collectors.toList());
}

private ContactFormDTO convertToDTO(Contactform contactform) {
    ContactFormDTO dto = new ContactFormDTO();
    dto.setName(contactform.getName());
    dto.setEmail(contactform.getEmail());
    dto.setMobileNumber(contactform.getMobileNumber());
    dto.setFeedback(contactform.getFeedback());
    return dto;
}
}
