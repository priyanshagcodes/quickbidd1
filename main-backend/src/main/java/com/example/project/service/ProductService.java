package com.example.project.service;

import com.example.project.model.Product;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;

public interface ProductService {

    Product createProduct(String name, String description, LocalDateTime startTime, LocalDateTime endTime, MultipartFile image);

    List<Product> getActiveProducts();


    List<Product> getAllProducts();

    Product getProductById(Long productId);

    void saveProduct(Product product);
}
