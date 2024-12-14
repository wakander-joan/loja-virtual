package com.loja_virtual.develop.carrinho.application.service;

import com.loja_virtual.develop.carrinho.application.api.CarrinhoRequest;
import com.loja_virtual.develop.carrinho.application.api.CarrinhoResponse;

public interface CarrinhoService {
    CarrinhoResponse postCarrinho(CarrinhoRequest carrinhoRequest);
}
