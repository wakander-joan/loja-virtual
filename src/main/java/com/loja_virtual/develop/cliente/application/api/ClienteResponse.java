package com.loja_virtual.develop.cliente.application.api;

import com.loja_virtual.develop.cliente.domain.Cliente;
import lombok.Getter;
import lombok.ToString;

import java.util.UUID;

@Getter
@ToString
public class ClienteResponse {
    private UUID idCliente;

    public ClienteResponse(Cliente cliente) {
        this.idCliente = cliente.getIdCliente();
    }
}
