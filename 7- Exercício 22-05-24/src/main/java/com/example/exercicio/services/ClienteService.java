package com.example.exercicio.services;

import com.example.exercicio.Mappers.TransacaoMapper;
import com.example.exercicio.dtos.ClienteDto;
import com.example.exercicio.dtos.TransacaoDto;
import com.example.exercicio.models.Cliente;
import com.example.exercicio.models.Transacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ClienteService {

    private final Map<String, Cliente> clientes = new HashMap<>();

    @Autowired
    public ClienteService() {
        clientes.put ("Julia", new Cliente("Julia", 500.0, "senha1"));
        clientes.put("Ramon", new Cliente("Ramon", 10.0, "senha2"));
        clientes.put("Rafael", new Cliente("Rafael", 100.0, "senha3"));
    }

    public ClienteDto getCliente(String nome) {
        Cliente cliente = clientes.get(nome);
        if (cliente != null) {
            return new ClienteDto(cliente.getNome(), cliente.getSaldo());
        }
        return null;
    }
    public TransacaoDto processarTransacao(TransacaoDto transacaoDto) {
        return transacaoDto;
    }

}
