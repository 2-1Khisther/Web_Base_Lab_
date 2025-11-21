package com.balat.lab_7;

import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;
import java.util.Collection;
import java.util.Optional;

@Service
public class ProductService {

    private Map<Long, Product> products = new HashMap<>();

    // Initialize mock products
    public ProductService() {
        products.put(1L, new Product(1L, "Laptop", 5000.0));
        products.put(2L, new Product(2L, "Television", 1000.0));
        products.put(3L, new Product(3L, "Electricfan", 15000.0));
    }

    // Get all products
    public Collection<Product> getAllProducts() {
        return products.values();
    }

    // Get product by ID
    public Optional<Product> getProductById(Long id) {
        return Optional.ofNullable(products.get(id));
    }

    // Add new product
    public Product addProduct(Product product) {
        products.put(product.getId(), product);
        return product;
    }

    // Update product
    public Optional<Product> updateProduct(Long id, Product updated) {
        if (products.containsKey(id)) {
            products.put(id, updated);
            return Optional.of(updated);
        }
        return Optional.empty();
    }

    // Delete product
    public boolean deleteProduct(Long id) {
        return products.remove(id) != null;
    }
}
