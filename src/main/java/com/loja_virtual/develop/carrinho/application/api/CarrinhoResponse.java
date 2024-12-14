package com.loja_virtual.develop.carrinho.application.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CarrinhoResponse {
    private UUID idCarrinho;
    private UUID idCliente;
    private List<ItemCarrinhoResponse> itens;
}
