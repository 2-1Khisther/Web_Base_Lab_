package com.balat.lab_7;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.Collection;

@Controller
public class ProductGraphQL {

    private final ProductService productService;

    public ProductGraphQL(ProductService productService) {
        this.productService = productService;
    }

    // QUERY: GET ALL
    @QueryMapping
    public Collection<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    // QUERY: GET ONE BY ID
    @QueryMapping
    public Product getProductById(@Argument Long id) {
        return productService.getProductById(id).orElse(null);
    }

    // MUTATION: CREATE
    @MutationMapping
    public Product createProduct(
            @Argument String name,
            @Argument Double price
    ) {
        // Generate new ID (same logic from your controller)
        Long newId = System.currentTimeMillis();
        Product product = new Product(newId, name, price);

        return productService.addProduct(product);
    }

    // MUTATION: UPDATE
    @MutationMapping
    public Product updateProduct(
            @Argument Long id,
            @Argument String name,
            @Argument Double price
    ) {
        Product updated = new Product(id, name, price);
        return productService.updateProduct(id, updated).orElse(null);
    }

    // MUTATION: DELETE
    @MutationMapping
    public Boolean deleteProduct(@Argument Long id) {
        return productService.deleteProduct(id);
    }
}

