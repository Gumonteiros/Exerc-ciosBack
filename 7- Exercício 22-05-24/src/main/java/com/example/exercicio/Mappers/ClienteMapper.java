package com.example.exercicio.Mappers;

import com.example.exercicio.dtos.ClienteDto;
import com.example.exercicio.models.Cliente;
import org.springframework.stereotype.Component;

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
