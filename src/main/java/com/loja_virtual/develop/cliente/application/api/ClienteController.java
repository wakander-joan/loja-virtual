package com.loja_virtual.develop.cliente.application.api;

import com.loja_virtual.develop.cliente.application.service.ClienteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@Log4j2
@RequiredArgsConstructor
public class ClienteController implements ClienteAPI {
    private final ClienteService clienteService;

    @Override
    public ClienteResponse postCliente(ClienteRequest clienteRequest) {
        log.info("[start] ClienteController - postCliente");
        ClienteResponse cliente = clienteService.postCliente(clienteRequest);
        log.info("[finish] ClienteController - postCliente");
        return cliente;
    }

    @Override
    public ClienteDetalhadoResponse getCliente(UUID idCliente) {
        log.info("[start] ClienteController - getProduto");
        ClienteDetalhadoResponse produto = clienteService.getCliente(idCliente);
        log.info("[finish] ClienteController - getProduto");
        return produto;
    }
}
