package com.loja_virtual.develop.carrinho.application.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ItemCarrinhoResponse {
    private UUID idItemCarrinho;
    private UUID idProduto;
    private int quantidade;
}
