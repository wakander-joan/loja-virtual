package com.loja_virtual.develop.cliente.application.service;

import com.loja_virtual.develop.cliente.application.api.ClienteRequest;
import com.loja_virtual.develop.cliente.application.api.ClienteResponse;

public interface ClienteService {
    ClienteResponse postCliente(ClienteRequest clienteRequest);
}
