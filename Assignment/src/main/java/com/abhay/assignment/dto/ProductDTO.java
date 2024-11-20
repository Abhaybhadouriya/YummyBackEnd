package com.abhay.assignment.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;

public record ProductDTO (

    @JsonProperty("product_name")
    String productName,
    @JsonProperty("price")
    int price,
    int min,
    int max
){}
