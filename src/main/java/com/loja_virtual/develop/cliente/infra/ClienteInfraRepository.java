package com.loja_virtual.develop.cliente.infra;

import com.loja_virtual.develop.cliente.application.service.ClienteRepository;
import com.loja_virtual.develop.cliente.domain.Cliente;
import com.loja_virtual.develop.handler.APIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@Log4j2
@RequiredArgsConstructor
public class ClienteInfraRepository implements ClienteRepository {
    private final ClienteSpringDataJPARepository clienteSpringDataJPARepository;

    @Override
    public Cliente salvaCliente(Cliente cliente) {
        log.info("[start] ClienteInfraRepository - salvaCliente");
        Cliente clienteSalvo =clienteSpringDataJPARepository.save(cliente);
        log.info("[finish] ClienteInfraRepository - salvaCliente");
        return clienteSalvo;
    }

    @Override
    public Cliente getCliente(UUID idCliente) {
        log.info("[start] ClienteInfraRepository - getCliente");
        Cliente cliente = clienteSpringDataJPARepository.findById(idCliente)
                .orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
        log.info("[finish] ClienteInfraRepository - getCliente");
        return cliente;
    }
}
