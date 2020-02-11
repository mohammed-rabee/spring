package com.example.demo.mvc.repository;

import com.example.demo.mvc.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer > {
}
