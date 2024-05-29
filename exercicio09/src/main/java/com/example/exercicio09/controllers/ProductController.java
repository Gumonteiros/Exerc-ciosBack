package com.example.exercicio09.controllers;

import com.example.exercicio09.dtos.ProductRequestDto;
import com.example.exercicio09.dtos.ProductResponseDto;
import com.example.exercicio09.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponseDto> getAllProducts(
            @RequestParam (defaultValue = "Name") List<String> sortBy) {
        return productService.getAllProducts(sortBy);
    }

    @GetMapping("/{name}")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponseDto> getProductsByName(@PathVariable String name) {
        return productService.getProductsByName(name);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponseDto createProduct(@RequestBody @Valid ProductRequestDto productRequestDto){
        return productService.createProduct(productRequestDto);
    }

    @PatchMapping("/{id}")
    public ProductResponseDto updateProduct(@PathVariable UUID id, @RequestBody @Valid ProductRequestDto productRequestDto) {
        return productService.updateProduct(id, productRequestDto);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable UUID id) {
        productService.deleteProduct(id);
    }
}
