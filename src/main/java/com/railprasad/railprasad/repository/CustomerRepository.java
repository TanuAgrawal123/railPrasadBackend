package com.railprasad.railprasad.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.railprasad.railprasad.model.Customer;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findByMobileNumber(String mobileNumber);
    Optional <Customer> findByEmail(String email);
    Optional <Customer> findById(Long id);

}
