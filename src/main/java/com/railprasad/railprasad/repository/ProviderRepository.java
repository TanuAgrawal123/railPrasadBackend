package com.railprasad.railprasad.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.railprasad.railprasad.model.Provider;

public interface ProviderRepository extends JpaRepository <Provider,Long> {
    Optional<Provider> findByMobileNumber(String mobileNumber);
    Optional <Provider> findByEmail(String email);
}
