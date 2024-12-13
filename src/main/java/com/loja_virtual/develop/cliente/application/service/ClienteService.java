package com.loja_virtual.develop.cliente.application.service;

import com.loja_virtual.develop.cliente.application.api.ClienteDetalhadoResponse;
import com.loja_virtual.develop.cliente.application.api.ClienteRequest;
import com.loja_virtual.develop.cliente.application.api.ClienteResponse;

import java.util.UUID;

public interface ClienteService {
    ClienteResponse postCliente(ClienteRequest clienteRequest);
    ClienteDetalhadoResponse getCliente(UUID idCliente);
}
