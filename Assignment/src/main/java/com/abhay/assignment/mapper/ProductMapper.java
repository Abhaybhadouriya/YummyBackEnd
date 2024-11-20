package com.abhay.assignment.mapper;

import com.abhay.assignment.dto.ProductDTO;
import com.abhay.assignment.entity.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductMapper {
    public Product toModel(ProductDTO dto) {
        return Product.builder().price(dto.price()).productName(dto.productName()).build();
    }
}
