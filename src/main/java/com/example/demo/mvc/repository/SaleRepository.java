package com.example.demo.mvc.repository;

import com.example.demo.mvc.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository <Sale , Integer> {
}
