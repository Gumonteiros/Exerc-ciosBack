package com.example.exercicio.dtos;

public record TransacaoDto(
        String recebedor,
        String pagador,
        Double quantidade
) {
}
