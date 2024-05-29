package com.example.exercicio09.services;


import com.example.exercicio09.dtos.ProductRequestDto;
import com.example.exercicio09.dtos.ProductResponseDto;
import com.example.exercicio09.mappers.ProductMapper;
import com.example.exercicio09.models.Product;
import com.example.exercicio09.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService {
    @Autowired
    ProductMapper productMapper;
    @Autowired
    ProductRepository productRepository;

    public List<ProductResponseDto> getAllProducts(List<String> sortBy) {
        List<Sort.Order> orderByList = sortBy.stream().map(attributeName -> {
                       return new Sort.Order(Sort.Direction.ASC, attributeName);
        }).toList();
        List<Product> productList = productRepository.findAll(Sort.by(orderByList));
        List<ProductResponseDto> productListDto = productList.stream().map(productMapper::toResponseDTO).toList();
        return productListDto;
    }

    // Retorna um produto pelo nome
    public List<ProductResponseDto> getProductsByName(String name) {
        List<Product> product = productRepository.findByName(name);
        if (product.isEmpty()) throw new RuntimeException("O produto não existe");
        return product.stream().map(productMapper::toResponseDTO).toList();
    }

    public ProductResponseDto createProduct(ProductRequestDto productRequestDto) {
        Product product = new Product();
        product.setName(productRequestDto.name());
        product.setPrice(productRequestDto.price());
        product = productRepository.save(product);
        return productMapper.toResponseDTO(product);
    }

    public ProductResponseDto updateProduct(UUID id, ProductRequestDto productRequestDto) {
        Product product = productRepository.findById(id).get();
                    product.setName(productRequestDto.name());
                    product.setPrice(productRequestDto.price());
                    productRepository.save(product);
                    return productMapper.toResponseDTO(product);
    }

    public ProductResponseDto deleteProduct(UUID id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        productRepository.delete(product);
        return productMapper.toResponseDTO(product);
    }
}
