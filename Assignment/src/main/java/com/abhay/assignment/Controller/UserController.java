package com.abhay.assignment.Controller;

import com.abhay.assignment.Services.CustomerService;
import com.abhay.assignment.dto.CustomerRequest;
import com.abhay.assignment.dto.ProductDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
    private final CustomerService services;
    @GetMapping("/")
    public ResponseEntity<String> sayHello(){
        return ResponseEntity.ok( "hello");
    }

    @PostMapping("/createUser")
    public ResponseEntity<String> createUser(@RequestBody @Valid CustomerRequest request){
        return ResponseEntity.ok(services.createCustomer(request));
    }

    @GetMapping("/getUser")
    public ResponseEntity<String> getUser(@RequestBody CustomerRequest request){
        return ResponseEntity.ok(services.getUser(request));
    }

    @PutMapping("/updateUser")
    public ResponseEntity<String> updateUser(@RequestBody @Valid CustomerRequest request){
         return ResponseEntity.ok(services.updateUser(request));
    }
    @DeleteMapping("/deleteUser")
    public ResponseEntity<String> deleteUser(@RequestBody @Valid CustomerRequest request){
         return ResponseEntity.ok(services.deleteUser(request));
    }

    @PostMapping("/addProduct")
    public ResponseEntity<String> addProduct(@RequestBody @Valid ProductDTO request){
        return ResponseEntity.ok(services.addProduct(request));
    }

    @GetMapping("/getProduct")
    public ResponseEntity<String> getProduct(@RequestBody ProductDTO request){
        return ResponseEntity.ok(services.getProduct(request));
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody @Valid CustomerRequest request) {
        return ResponseEntity.ok(services.login(request));
    }

}
