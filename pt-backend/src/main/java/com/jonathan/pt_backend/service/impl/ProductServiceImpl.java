package com.jonathan.pt_backend.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jonathan.pt_backend.dto.ProductDto;
import com.jonathan.pt_backend.entity.Product;
import com.jonathan.pt_backend.exception.ResourceNotFoundException;
import com.jonathan.pt_backend.mapper.ProductMapper;
import com.jonathan.pt_backend.repository.ProductRepository;
import com.jonathan.pt_backend.service.ProductService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;


    @Override
    public ProductDto createProduct(ProductDto productDto) {

        Product product = ProductMapper.mapToProduct(productDto);
        Product savedProduct = productRepository.save(product);

        return ProductMapper.mapToProductDto(savedProduct);
    }


    @Override
    public ProductDto getProductById(Long productId) {
        Product product =  productRepository.findById(productId)
                .orElseThrow(() -> 
                        new ResourceNotFoundException("No se encuentra un producto con el Id de: " + productId));
        return ProductMapper.mapToProductDto(product);
    }


    @Override
    public List<ProductDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map((product) -> ProductMapper.mapToProductDto(product))
                .toList();
    }
}
