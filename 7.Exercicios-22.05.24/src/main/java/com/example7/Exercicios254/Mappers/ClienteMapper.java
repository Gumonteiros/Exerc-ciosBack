package com.example7.Exercicios254.Mappers;

import org.springframework.stereotype.Component;

import com.example7.Exercicios254.Dtos.ClienteDto;
import com.example7.Exercicios254.models.Cliente;

@Component
public class ClienteMapper {
    public ClienteDto toDto(Cliente cliente) {
        ClienteDto clienteDto = new ClienteDto(
            cliente.getNome(),
            cliente.getSaldo()
        );
        return clienteDto;
    }
}
