package com.loja_virtual.develop.carrinho.application.api;

import com.loja_virtual.develop.carrinho.application.service.CarrinhoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
@RequiredArgsConstructor
public class CarrinhoController implements CarrinhoAPI {
    private final CarrinhoService carrinhoService;

    @Override
    public CarrinhoResponse postCarrinho(CarrinhoRequest produtoRequest) {
        log.info("[start] CarrinhoController - postCarrinho");
        CarrinhoResponse carrinho = carrinhoService.postCarrinho(produtoRequest);
        log.info("[finish] CarrinhoController - postCarrinho");
        return carrinho;
    }
}