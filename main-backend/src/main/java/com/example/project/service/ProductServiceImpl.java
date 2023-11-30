package com.example.project.service;

import com.example.project.model.Product;
import com.example.project.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Value("${upload.path}")
    private String uploadPath;


    @Override
    public Product createProduct(String name, String description, LocalDateTime startTime, LocalDateTime endTime, MultipartFile image) {
        Product product = new Product();
        product.setName(name);
        product.setDescription(description);
        product.setStartTime(startTime);
        product.setEndTime(endTime);

        // Save the image file if it is not null and not empty
        if (image != null && !image.isEmpty()) {
            String imageName = StringUtils.cleanPath(Objects.requireNonNull(image.getOriginalFilename()));

            try {
                Path imagePath = Paths.get(uploadPath, imageName);
                Files.copy(image.getInputStream(), imagePath);
                product.setImageFileName(imageName);
            } catch (IOException e) {
                // Handle the exception appropriately
                throw new RuntimeException("Failed to save image", e);
            }
        }

        return productRepository.save(product);
    }


    @Override
    public List<Product> getActiveProducts() {
        return productRepository.findByEndTimeAfter(LocalDateTime.now());
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long productId) {
        return productRepository.findById(productId).orElse(null);
    }

    @Override
    public void saveProduct(Product product) {
        productRepository.save(product);
    }

}

