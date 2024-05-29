package com.example.exercicio09.dtos;

import java.time.Instant;

public record ApiExceptionDto(
        String titulo,
        String descricao,
        Instant data
) {
}
