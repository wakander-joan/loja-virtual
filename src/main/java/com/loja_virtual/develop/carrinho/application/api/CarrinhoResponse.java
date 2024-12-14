package com.loja_virtual.develop.carrinho.application.api;

import com.loja_virtual.develop.carrinho.domain.Carrinho;
import com.loja_virtual.develop.carrinho.domain.ItemCarrinho;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CarrinhoResponse {
    private UUID idCarrinho;
    private UUID idCliente;
    private List<ItemCarrinhoResponse> itens;

    public CarrinhoResponse(Carrinho carrinhoAtualizado) {
        this.idCarrinho = carrinhoAtualizado.getIdCarrinho();
        this.idCliente = carrinhoAtualizado.getIdCliente();
        this.itens = carrinhoAtualizado.getItens().stream()
                .map(item -> ItemCarrinhoResponse
                        .builder()
                        .idItemCarrinho(item.getIdItenCarrinho())
                        .idProduto(item.getIdProduto())
                        .quantidade(item.getQuantidade())
                        .build())
                .collect(Collectors.toList());
    }
}
