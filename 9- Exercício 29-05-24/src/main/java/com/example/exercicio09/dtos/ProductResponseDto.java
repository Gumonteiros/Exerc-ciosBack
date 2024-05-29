package com.example.exercicio09.dtos;

import java.util.UUID;

public record ProductResponseDto(
        UUID id,
        String name,
        Double price
) {
}
