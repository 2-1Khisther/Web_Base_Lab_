package com.balat.lab_7;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;
    private final AtomicLong idCounter = new AtomicLong(4); // Start after mock products (IDs 1,2,3)

    // Constructor injection
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    /**
     * READ ALL - GET /api/products
     * Success: 200 OK, returns all products
     */
    @GetMapping
    public ResponseEntity<Collection<Product>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    /**
     * READ ONE - GET /api/products/{id}
     * Success: 200 OK, returns the product
     * Error: 404 Not Found if product ID does not exist
     */
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        return productService.getProductById(id)
                .map(ResponseEntity::ok) // 200 OK
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build()); // 404 Not Found
    }

    /**
     * CREATE - POST /api/products
     * Success: 201 Created, returns the newly created product
     * Note: Auto-increment ID is simulated
     */
    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        product.setId(idCounter.getAndIncrement()); // Assign unique ID
        Product created = productService.addProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(created); // 201 Created
    }

    /**
     * UPDATE - PUT /api/products/{id}
     * Success: 200 OK, returns the updated product
     * Error: 404 Not Found if product ID does not exist
     */
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(
            @PathVariable Long id,
            @RequestBody Product updatedProduct) {

        return productService.updateProduct(id, updatedProduct)
                .map(ResponseEntity::ok) // 200 OK
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build()); // 404 Not Found
    }

    /**
     * DELETE - DELETE /api/products/{id}
     * Success: 204 No Content, product deleted successfully
     * Error: 404 Not Found if product ID does not exist
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        boolean deleted = productService.deleteProduct(id);
        if (deleted) {
            return ResponseEntity.noContent().build(); // 204 No Content
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // 404 Not Found
        }
    }
}
