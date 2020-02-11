package com.example.demo.mvc.repository;

import com.example.demo.mvc.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository <Client,Integer> {
}
