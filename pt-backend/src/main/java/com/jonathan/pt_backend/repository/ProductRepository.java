package com.jonathan.pt_backend.repository;

import com.jonathan.pt_backend.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository <Product, Long> {

}
