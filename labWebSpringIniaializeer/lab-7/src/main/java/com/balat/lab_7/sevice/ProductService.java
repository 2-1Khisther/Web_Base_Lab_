package com.balat.lab_7.sevice;

import com.balat.lab_7.entity.Product;
import com.balat.lab_7.repository.ProductRepository;
import org.springframework.stereotype.Service;
import java.util.Collection;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository; // New JPA dependency

    // Constructor Injection
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // Replaced HashMap logic with JpaRepository methods
    public Collection<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public Optional<Product> updateProduct(Long id, Product updated) {
        if (productRepository.existsById(id)) {
            updated.setId(id);
            return Optional.of(productRepository.save(updated));
        }
        return Optional.empty();
    }

    public boolean deleteProduct(Long id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return true;
        }
        return false;
    }
}