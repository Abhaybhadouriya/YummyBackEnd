package com.abhay.assignment.Services;

import com.abhay.assignment.dto.CustomerRequest;
import com.abhay.assignment.dto.ProductDTO;
import com.abhay.assignment.entity.Customer;
import com.abhay.assignment.entity.Product;
import com.abhay.assignment.mapper.CustomerMapper;
import com.abhay.assignment.mapper.ProductMapper;
import com.abhay.assignment.repo.CustomerRepo;
import com.abhay.assignment.repo.ProductRepo;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerMapper mapper;
    private final CustomerRepo customerRepo;
    private final ProductRepo productRepo;
    private final ProductMapper productMapper;
    private final PasswordEncoder passwordEncoder;

    public String createCustomer(@Valid CustomerRequest request) {
        Customer customer = mapper.toEntity(request);
        customer.setPassword(passwordEncoder.encode(customer.getPassword()));
        customerRepo.save(customer);
        return "Created";
    }

    public String getUser(CustomerRequest request) {
        Customer customer = customerRepo.findByEmail(request.email()).orElse(null);
        return customer == null ? "No User Found" : customer.toString();
    }

    public String updateUser(@Valid CustomerRequest request) {
        Customer customer = customerRepo.findByEmail(request.email()).orElse(null);
        if(customer == null) { return "User not found"; }

        customer.setFirstName(request.firstName());
        customer.setLastName(request.lastName());
        customer.setEmail(request.email());
        customer.setPassword(passwordEncoder.encode(request.password()));
        customerRepo.save(customer);
        return "User Updated Success Full \n "+ customer.toString();
    }

    public String deleteUser(@Valid CustomerRequest request) {
        Customer customer = customerRepo.findByEmail(request.email()).orElse(null);
        if(customer == null) { return "User not found"; }
        customerRepo.delete(customer);
        return "User Deleted Success Full \n "+ customer.toString();
    }

    public String addProduct(@Valid ProductDTO request) {
        Product product = productMapper.toModel(request);
        productRepo.save(product);
        return "Product added SuccessFully";
    }

    public String getProduct(ProductDTO request) {
        List<Product> product = productRepo.findTop2ByPriceRange(request.min(),request.max());
        return product == null ? "No Product Found" : product.toString();
    }
}
