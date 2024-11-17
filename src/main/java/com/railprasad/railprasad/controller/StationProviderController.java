package com.railprasad.railprasad.controller;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.railprasad.railprasad.dto.StationProviderDTO;
import com.railprasad.railprasad.service.FeedbackService;
import com.railprasad.railprasad.service.StationProviderService;

@RestController
@RequestMapping("station-provider")
@CrossOrigin
public class StationProviderController {
    @Autowired
    StationProviderService stationProviderService;

    @Autowired
    FeedbackService feedbackService;

    @PostMapping("submit")
    public ResponseEntity<String> submitStationEntry(@RequestBody StationProviderDTO stationDTO) throws Exception{

        try {
         stationProviderService.submitStationEntry(stationDTO);
            return new ResponseEntity<>("Entry submitted successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error submitting entry: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("average-rating/{stationproviderid}")
    public ResponseEntity<Double> getAverageRating(@PathVariable Long stationproviderid) {
        Double averageRating = feedbackService.getAverageRating(stationproviderid);
        if (averageRating == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(averageRating);
    }

    @GetMapping("/all-entries")
    public ResponseEntity<List<StationProviderDTO>> getAllStationProviders() {
        try {
            List<StationProviderDTO> stationProviders = stationProviderService.getAllStationProviders();
            return ResponseEntity.ok(stationProviders);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    

 
    



}
