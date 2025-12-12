package com.balat.lab_7.repository;
import com.balat.lab_7.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
