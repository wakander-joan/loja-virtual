package com.loja_virtual.develop.carrinho.application.service;

import com.loja_virtual.develop.carrinho.application.api.CarrinhoRequest;
import com.loja_virtual.develop.carrinho.application.api.CarrinhoResponse;
import com.loja_virtual.develop.carrinho.domain.Carrinho;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Log4j2
@RequiredArgsConstructor
public class CarrinhoApplicationService implements CarrinhoService {
    private final CarrinhoRepository carrinhoRepository;
    
    @Override
    public CarrinhoResponse postCarrinho(CarrinhoRequest carrinhoRequest) {
        log.info("[start] CarrinhoApplicationService - postCarrinho");
        Carrinho carrinho = new Carrinho();
        carrinho.setIdCliente(UUID.fromString(String.valueOf(carrinhoRequest.getIdCliente())));
        Carrinho carrinhoAtualizado = Carrinho.adicionaIten(carrinho, carrinhoRequest);
        carrinhoRepository.save(carrinhoAtualizado);
        log.info("[finish] CarrinhoApplicationService - postCarrinho");
        return new CarrinhoResponse(carrinhoAtualizado);
    }
}
