package com.loja_virtual.develop.cliente.infra;

import com.loja_virtual.develop.cliente.application.service.ClienteRepository;
import com.loja_virtual.develop.cliente.domain.Cliente;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

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
}
