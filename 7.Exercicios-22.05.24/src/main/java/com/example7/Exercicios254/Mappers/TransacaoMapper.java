package com.example7.Exercicios254.Mappers;

import org.springframework.stereotype.Component;

import com.example7.Exercicios254.Dtos.TransacaoDto;
import com.example7.Exercicios254.models.Transacao;


@Component
public class TransacaoMapper {
    public TransacaoDto toDto(Transacao transacao) {
        TransacaoDto transacaoDto = new TransacaoDto(
                transacao.getContaOrigem(),
                transacao.getContaDestino(),
                transacao.getValor()
        );
        return transacaoDto;
    }
}

