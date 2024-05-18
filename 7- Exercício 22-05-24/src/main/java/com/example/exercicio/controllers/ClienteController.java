package com.example.exercicio.controllers;

import com.example.exercicio.dtos.ClienteDto;
import com.example.exercicio.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.crypto.dsig.TransformService;

@RestController
public class ClienteController {
    private final ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("/cliente/{nome}")
    public ResponseEntity<ClienteDto> getCliente(@PathVariable String nome) {
        ClienteDto clienteDto = clienteService.getCliente(nome);
        if (clienteDto != null) {
            return ResponseEntity.ok(clienteDto);
        }
        return ResponseEntity.notFound().build();
    }

}
