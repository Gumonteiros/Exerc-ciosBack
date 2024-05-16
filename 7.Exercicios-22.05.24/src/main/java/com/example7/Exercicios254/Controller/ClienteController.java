package com.example7.Exercicios254.Controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example7.Exercicios254.models.Cliente;

@RestController
@RequestMapping("/Clientes")
public class ClienteController {
    private Map<String, Cliente> clientes = new HashMap<>();

    @PostMapping
    public ResponseEntity<String> criarUsuario(@RequestBody Cliente cliente) {        
        clientes.put(cliente.getNome(), cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body("Usuário criado com sucesso");
    }

    @GetMapping("/{cliente}")
    public ResponseEntity<Cliente> obterUsuario(@PathVariable String nome) {
        Cliente cliente = clientes.get(nome);
        if (cliente == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cliente);
    }
    
}
