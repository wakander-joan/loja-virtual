package com.loja_virtual.develop.carrinho.application.api;

import lombok.Getter;
import lombok.ToString;

import java.util.UUID;

@Getter
@ToString
public class ItemCarrinhoRequest {
    private UUID idProduto;
    private int quantidade;
}