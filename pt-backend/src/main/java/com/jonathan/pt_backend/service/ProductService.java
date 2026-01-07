package com.jonathan.pt_backend.service;

import java.util.List;

import com.jonathan.pt_backend.dto.ProductDto;

public interface ProductService {
    
    ProductDto createProduct(ProductDto productDto);

    ProductDto getProductById(Long productId);

    List<ProductDto> getAllProducts();
}
