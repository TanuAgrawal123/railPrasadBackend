package com.railprasad.railprasad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class RailprasadApplication {

	public static void main(String[] args) {
		SpringApplication.run(RailprasadApplication.class, args);
	}

}
