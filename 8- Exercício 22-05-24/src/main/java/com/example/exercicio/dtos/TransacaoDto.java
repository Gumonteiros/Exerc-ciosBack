package com.example.exercicio.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TransacaoDto(
        @NotBlank(message = "O recebedor não pode estar em branco")
        String recebedor,
        @NotBlank(message = "O pagador não pode estar em branco")
        String pagador,
        @NotNull(message = "A quantidade não pode ser nula")
        @Min(value = 1, message = "A quantidade deve ser maior que zero")
        Double quantidade
) {
}
