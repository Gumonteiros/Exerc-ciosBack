package com.example7.Exercicios254.Services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example7.Exercicios254.Dtos.TransacaoDto;
import com.example7.Exercicios254.Mappers.TransacaoMapper;
import com.example7.Exercicios254.models.Transacao;


@Service
public class TransacaoService {
    @Autowired
    TransacaoMapper transacaoMapper;

    public TransacaoDto getTransacao() {
        Transacao transacao = new Transacao(
                "Gustavo Monteiro",
                "Bruno Supriano",
                "pix",
                100.0,
                "Tome"

        );
        return transacaoMapper.toDto(transacao);
    }
}



