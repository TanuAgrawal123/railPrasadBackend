package com.railprasad.railprasad.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.railprasad.railprasad.dto.FeedbackDTO;
import com.railprasad.railprasad.dto.FeedbackResponseDTO;
import com.railprasad.railprasad.model.Customer;
import com.railprasad.railprasad.model.Feedback;
import com.railprasad.railprasad.repository.CustomerRepository;
import com.railprasad.railprasad.repository.FeedbackRepository;

@Service
public class FeedbackService {
    @Autowired
    private FeedbackRepository feedbackRepository;
    @Autowired
    private CustomerRepository customerRepository;

    public String submitFeedback(FeedbackDTO feedbackDTO) {
        // Validate the rating value
        if (feedbackDTO.getRating() < 1 || feedbackDTO.getRating() > 5) {
        throw new IllegalArgumentException("Rating must be between 1 and 5");
        }

        Feedback feedback = new Feedback();
        feedback.setUserid(feedbackDTO.getUserid());
        feedback.setStationproviderid(feedbackDTO.getStationproviderid());
        feedback.setReview(feedbackDTO.getReview());
        feedback.setRating(feedbackDTO.getRating());

        feedbackRepository.save(feedback);
        return "Feedback submitted successfully";
    }

    public Double getAverageRating(Long stationproviderid) {
        return feedbackRepository.findAverageRatingByStationproviderid(stationproviderid);
    }

    public List<FeedbackResponseDTO> getFeedbackForStationProvider(Long stationproviderid) {
        List<Feedback> feedbacks = feedbackRepository.findByStationproviderid(stationproviderid);

         List<FeedbackResponseDTO> feedbackResponses=feedbacks.stream().map(feedback -> {
            FeedbackResponseDTO responseDTO = new FeedbackResponseDTO();

            // Get user details
            Customer customer = customerRepository.findById(feedback.getUserid())
                    .orElseThrow(() -> new RuntimeException("User not found"));


            responseDTO.setName(customer.getName());
            responseDTO.setReview(feedback.getReview());
            responseDTO.setRating(feedback.getRating());

            return responseDTO;
        }).toList();
        return feedbackResponses;
    }
}
