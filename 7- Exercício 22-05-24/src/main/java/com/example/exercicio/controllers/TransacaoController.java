package com.example.exercicio.controllers;

import com.example.exercicio.dtos.TransacaoDto;
import com.example.exercicio.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransacaoController {
    @Autowired
    private ClienteService clienteService;

    @PostMapping("/transacao")
    public ResponseEntity<TransacaoDto> adicionarTransacao(@RequestBody TransacaoDto transacaoDto) {
        TransacaoDto transacao = clienteService.processarTransacao(transacaoDto);
        if (transacao != null) {
            return ResponseEntity.ok(transacao);
        }
        return ResponseEntity.badRequest().build();
    }
}