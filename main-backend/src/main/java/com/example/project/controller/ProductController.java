package com.example.project.controller;

import com.example.project.model.Product;
import com.example.project.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/create")
    public ResponseEntity<Product> createProduct(
            @RequestParam String name,
            @RequestParam String description,
            @RequestParam LocalDateTime startTime,
            @RequestParam LocalDateTime endTime,
            @RequestParam(required = false) MultipartFile image
    ) {
        try {
            Product product = productService.createProduct(name, description, startTime, endTime, image);
            return new ResponseEntity<>(product, HttpStatus.CREATED);
        } catch (Exception e) {
            // Handle the exception appropriately
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/active")
    public ResponseEntity<List<Product>> getActiveProducts() {
        List<Product> activeProducts = productService.getActiveProducts();
        return new ResponseEntity<>(activeProducts, HttpStatus.OK);
    }
}
