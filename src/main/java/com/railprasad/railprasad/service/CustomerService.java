
package com.railprasad.railprasad.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.railprasad.railprasad.dto.CustomerDTO;
import com.railprasad.railprasad.model.Customer;
import com.railprasad.railprasad.repository.CustomerRepository;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public String signup(CustomerDTO customerDTO) {
        if (customerRepository.findByMobileNumber(customerDTO.getMobileNumber()).isPresent()) {
            throw new IllegalArgumentException("Mobile number already registered");
        }
        if (customerRepository.findByEmail(customerDTO.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Email id already registered");
        }
        Customer customer = new Customer();
        customer.setName(customerDTO.getName());
        customer.setMobileNumber(customerDTO.getMobileNumber());
        customer.setEmail(customerDTO.getEmail());
        customer.setPassword(passwordEncoder.encode(customerDTO.getPassword())); // Encrypt password

        customerRepository.save(customer);
        return "Signup successful";
    }

    public String login(String mobileNumber, String password) {
        Optional<Customer> customerOptional = customerRepository.findByMobileNumber(mobileNumber);
        if (customerOptional.isEmpty()) {
            throw new IllegalArgumentException("Invalid mobile number");
        }
        Customer customer = customerOptional.get();
        if (!passwordEncoder.matches(password, customer.getPassword())) {
            throw new IllegalArgumentException("Invalid password");
        }
        return "Login successful";
    }
}
