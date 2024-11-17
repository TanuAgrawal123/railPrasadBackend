package com.railprasad.railprasad.dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class ContactFormDTO {

    @NotBlank(message = "Name is mandatory")
    private String name;

    private String email; // Optional field

    @NotBlank(message = "Mobile number is mandatory")
    @Pattern(regexp = "\\d{10}", message = "Mobile number must be 10 digits")
    private String mobileNumber;

    @NotBlank(message = "Feedback cannot be blank")
    private String feedback;

}
