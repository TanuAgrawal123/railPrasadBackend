package com.railprasad.railprasad.dto;

import lombok.Data;

@Data
public class FeedbackDTO {
    private Long userid;
    private Long stationproviderid; //unique combination 
    private String review;
    private Integer rating;

}
