package com.example.exercicio09.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record ProductRequestDto(
        UUID id,
        @NotBlank(message = "O nome não pode estar em branco")
        String name,

        @NotNull(message = "O preço não pode ser nulo")
        @Min(value = 0, message = "O preço precisa ser maior ou igual a zero")
        Double price
) {
}
