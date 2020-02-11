package com.example.demo.mvc.repository;

import com.example.demo.mvc.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository <Category , Integer> {
}
