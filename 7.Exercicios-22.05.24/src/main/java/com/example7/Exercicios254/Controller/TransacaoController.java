package com.example7.Exercicios254.Controller;

import javax.xml.crypto.dsig.TransformService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example7.Exercicios254.Dtos.TransacaoDto;

@RestController
public class TransacaoController {
    @Autowired
    TransformService transacaoService;

    @GetMapping("/transacao")
    public ResponseEntity<Object> getTransacao() {
        TransacaoDto transacaoDto = transacaoService.getTransacao();
        return ResponseEntity.status(HttpStatus.OK).body(transacaoDto);
    }
}

