package com.railprasad.railprasad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.railprasad.railprasad.dto.ProviderDTO;
import com.railprasad.railprasad.service.ProviderService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("provider")
public class ProviderController {
    @Autowired
    private ProviderService providerService;

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@Valid @RequestBody ProviderDTO providerDTO) {
        try {
            String response = providerService.signup(providerDTO);
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String mobileNumber, @RequestParam String password) {
        try {
            String response = providerService.login(mobileNumber, password);
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
