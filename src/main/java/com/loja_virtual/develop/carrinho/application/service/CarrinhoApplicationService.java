package com.loja_virtual.develop.carrinho.application.service;

import com.loja_virtual.develop.carrinho.application.api.CarrinhoRequest;
import com.loja_virtual.develop.carrinho.application.api.CarrinhoResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class CarrinhoApplicationService implements CarrinhoService {
    
    
    @Override
    public CarrinhoResponse postCarrinho(CarrinhoRequest produtoRequest) {
        log.info("[start] CarrinhoApplicationService - postCarrinho");
        log.info("[finish] CarrinhoApplicationService - postCarrinho");
        return null;
    }
}
