package com.railprasad.railprasad.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Entity

public class StationProvider {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; // Primary key for the Station entity

    private int providerid;  //this will come as logged in provider can only add station

    @NotBlank(message = "Station name is mandatory")
    private String stationName;

    

    @NotBlank(message = "Station code is mandatory")
    @Column(length = 10) // Ensure unique codes and limit the length
    private String stationCode;

    @NotBlank(message = "State is mandatory")
    private String state;

    @NotBlank(message = "Full name is mandatory")
    private String fullName;

    @NotBlank(message = "Phone number is mandatory")
    @Pattern(regexp = "\\d{10}", message = "Phone number must be 10 digits")
    private String phoneNumber;

    @Pattern(regexp = "\\d{10}", message = "WhatsApp number must be 10 digits")
    private String whatsappNumber;

    @Email(message = "Invalid email address")
    @NotBlank(message = "Email ID is mandatory")
    private String emailId;

}
