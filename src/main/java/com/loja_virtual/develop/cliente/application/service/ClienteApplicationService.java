package com.loja_virtual.develop.cliente.application.service;

import com.loja_virtual.develop.cliente.application.api.ClienteRequest;
import com.loja_virtual.develop.cliente.application.api.ClienteResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class ClienteApplicationService implements ClienteService {

    @Override
    public ClienteResponse postCliente(ClienteRequest clienteRequest) {
        log.info("[start] ClienteApplicationService - postCliente");
        log.info("[finish] ClienteApplicationService - postCliente");
        return null;
    }
}
