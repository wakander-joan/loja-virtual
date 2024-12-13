package com.loja_virtual.develop.cliente.application.service;

import com.loja_virtual.develop.cliente.domain.Cliente;

import java.util.UUID;

public interface ClienteRepository {
    Cliente salvaCliente(Cliente cliente);
    Cliente getCliente(UUID idCliente);
}
