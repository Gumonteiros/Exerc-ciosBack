package com.example.exercicio.Mappers;


import com.example.exercicio.dtos.TransacaoDto;
import com.example.exercicio.models.Transacao;
import org.springframework.stereotype.Component;

@Component
public class TransacaoMapper {
    public static TransacaoDto toDto(Transacao transacao) {
        TransacaoDto transacaoDto = new TransacaoDto(
                transacao.getPagador(),
                transacao.getRecebedor(),
                transacao.getQuantidade()
        );
        return transacaoDto;
    }
}
