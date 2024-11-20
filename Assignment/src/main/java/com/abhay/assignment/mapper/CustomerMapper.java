package com.abhay.assignment.mapper;

import com.abhay.assignment.dto.CustomerRequest;
import com.abhay.assignment.entity.Customer;
import org.springframework.stereotype.Service;

@Service
public class CustomerMapper {
    public Customer toEntity(CustomerRequest request) {
        return Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .password( request.password())
                .build();
    }
}