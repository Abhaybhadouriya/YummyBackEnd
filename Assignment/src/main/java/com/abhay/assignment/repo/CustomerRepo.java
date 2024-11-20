package com.abhay.assignment.repo;

import com.abhay.assignment.entity.Customer;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface CustomerRepo extends JpaRepository<Customer, Long> {
    Optional<Customer> findByEmailAndPassword(String email, String password);

    Optional<Customer> findByEmail(@NotNull(message="Customer email is required") @Email(message = "Email must be in correct format") String email);
}