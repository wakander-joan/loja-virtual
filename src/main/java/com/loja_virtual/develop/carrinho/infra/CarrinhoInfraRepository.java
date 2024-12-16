package com.loja_virtual.develop.carrinho.infra;

import com.loja_virtual.develop.carrinho.application.service.CarrinhoRepository;
import com.loja_virtual.develop.carrinho.domain.Carrinho;
import com.loja_virtual.develop.carrinho.domain.ItemCarrinho;
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
    public List<Carrinho> getCarrinhoIdCliente(UUID idCliente) {
        log.info("[start] CarrinhoInfraRepository - verificaCarrinhoAddProduto");
        List<Carrinho> carrinhos = carrinhoSpringDataJPARepository.findAllByIdCliente(idCliente);
        log.info("[finish] CarrinhoInfraRepository - verificaCarrinhoAddProduto");
        return carrinhos;
    }

    @Override
    public Carrinho getCarrinhoPorId(UUID idCarrinho) {
        log.info("[start] CarrinhoInfraRepository - getCarrinhoPorId");
        Carrinho carrinho = carrinhoSpringDataJPARepository.findById(idCarrinho)
                .orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Carrinho não encontrado!"));
        log.info("[finish] CarrinhoInfraRepository - getCarrinhoPorId");
        return carrinho;
    }

    @Override
    public void salvaProduto(ItemCarrinho itemCarrinho) {

    }
}
