package com.railprasad.railprasad.service;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.railprasad.railprasad.dto.ProviderDTO;
import com.railprasad.railprasad.model.Provider;
import com.railprasad.railprasad.repository.ProviderRepository;

@Service
public class ProviderService {
    @Autowired
    private ProviderRepository providerRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public String signup(ProviderDTO providerDTO) {
        if (providerRepository.findByMobileNumber(providerDTO.getMobileNumber()).isPresent()) {
            throw new IllegalArgumentException("Mobile number already registered");
        }
        if (providerRepository.findByEmail(providerDTO.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Email id already registered");
        }
        Provider provider = new Provider();
        provider.setName(providerDTO.getName());
        provider.setMobileNumber(providerDTO.getMobileNumber());
        provider.setEmail(providerDTO.getEmail());
        provider.setPassword(passwordEncoder.encode(providerDTO.getPassword())); // Encrypt password

        providerRepository.save(provider);
        return "Signup successful";
    }

    public String login(String mobileNumber, String password) {
        Optional<Provider> providerOptional = providerRepository.findByMobileNumber(mobileNumber);
        if (providerOptional.isEmpty()) {
            throw new IllegalArgumentException("Invalid mobile number");
        }
        Provider provider = providerOptional.get();
        if (!passwordEncoder.matches(password, provider.getPassword())) {
            throw new IllegalArgumentException("Invalid password");
        }
        return "Login successful";
    }
}
