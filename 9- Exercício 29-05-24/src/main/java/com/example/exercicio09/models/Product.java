package com.example.exercicio09.models;

import jakarta.persistence.*;


import java.util.UUID;
@Entity
@Table(name = "produtos")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private Double price;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

//    public Product(String name, Double price) {
//        this.name = name;
//        this.price = price;
//    }
}
