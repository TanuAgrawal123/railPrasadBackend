package com.railprasad.railprasad.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.railprasad.railprasad.dto.FeedbackDTO;
import com.railprasad.railprasad.dto.FeedbackResponseDTO;
import com.railprasad.railprasad.service.FeedbackService;

@RestController
@RequestMapping("feedback")
public class FeedbackController {
    @Autowired
    private FeedbackService feedbackService;
    @PostMapping("/submit")
    public ResponseEntity<String> submitFeedback(@RequestBody FeedbackDTO feedbackDTO) {
        try {
            String response = feedbackService.submitFeedback(feedbackDTO);
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

      @GetMapping("station-provider/{stationproviderid}")
    public ResponseEntity<List<FeedbackResponseDTO>> getFeedbackForStationProvider(@PathVariable Long stationproviderid) {
        try {
            List<FeedbackResponseDTO> feedbackList = feedbackService.getFeedbackForStationProvider(stationproviderid);
            return ResponseEntity.ok(feedbackList);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    
    
}
