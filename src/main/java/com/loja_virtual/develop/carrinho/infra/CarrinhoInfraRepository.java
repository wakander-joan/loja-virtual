package com.loja_virtual.develop.carrinho.infra;

import com.loja_virtual.develop.carrinho.application.service.CarrinhoRepository;
import com.loja_virtual.develop.carrinho.domain.Carrinho;
import com.loja_virtual.develop.handler.APIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Repository
@Log4j2
@RequiredArgsConstructor
public class CarrinhoInfraRepository implements CarrinhoRepository {
    private final CarrinhoSpringDataJPARepository carrinhoSpringDataJPARepository;

    @Override
    public void save(Carrinho carrinhoAtualizado) {
    log.info("[start] CarrinhoInfraRepository - save");
    carrinhoSpringDataJPARepository.save(carrinhoAtualizado);
    log.info("[finish] CarrinhoInfraRepository - save");
    }

    @Override
    public void getCarrinhoIdCliente(UUID idCliente) {
        log.info("[start] CarrinhoInfraRepository - getCarrinhoIdCliente");
        List<Carrinho> carrinhos = carrinhoSpringDataJPARepository.findAllByIdCliente(idCliente);
        if (!carrinhos.isEmpty()) {
            log.error("Já existem carrinhos associados ao cliente com id: {}", idCliente);
            throw APIException.build(HttpStatus.NOT_FOUND, "Já existe um carrinho associado ao Cliente");
        }
        log.info("Cliente Verificado! Esse cliente não possui carrinho!");
        log.info("[finish] CarrinhoInfraRepository - getCarrinhoIdCliente");
    }
}
