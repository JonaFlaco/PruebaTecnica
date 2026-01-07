package com.jonathan.pt_backend.mapper;

import com.jonathan.pt_backend.dto.ProductDto;
import com.jonathan.pt_backend.entity.Product;

public class ProductMapper {

    public static ProductDto mapToProductDto (Product product){
        return new ProductDto(
            product.getId(),
            product.getName(),
            product.getPrice(),
            product.getStock(),
            product.getCreatedAt()
        );
    }

    public static Product mapToProduct(ProductDto productDto){
        return new Product(
            productDto.getId(),
            productDto.getName(),
            productDto.getPrice(),
            productDto.getStock(),
            productDto.getCreatedAt()
        );
    }
}
