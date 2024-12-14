package com.loja_virtual.develop.carrinho.infra;

import com.loja_virtual.develop.carrinho.application.service.CarrinhoRepository;
import com.loja_virtual.develop.carrinho.domain.Carrinho;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

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
}
