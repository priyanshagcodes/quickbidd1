package com.example.project.repository;

import com.example.project.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByEndTimeAfter(LocalDateTime endTime);
}

