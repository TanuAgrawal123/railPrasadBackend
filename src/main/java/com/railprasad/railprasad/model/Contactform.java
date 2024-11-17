package com.railprasad.railprasad.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Contactform {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column
    private String email; // Optional

    @Column(nullable = false)
    private String mobileNumber;

    @Column(nullable = false, length = 500)
    private String feedback; // Feedback content
}

