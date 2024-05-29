package com.example.exercicio09.repositories;


import com.example.exercicio09.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;
public interface ProductRepository extends JpaRepository<Product, UUID> {
    List<Product> findByName(String name);
}
