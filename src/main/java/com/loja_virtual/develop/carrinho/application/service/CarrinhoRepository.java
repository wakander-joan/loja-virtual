package com.loja_virtual.develop.carrinho.application.service;

import com.loja_virtual.develop.carrinho.domain.Carrinho;
import com.loja_virtual.develop.carrinho.domain.ItemCarrinho;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.UUID;

public interface CarrinhoRepository {
    void save(Carrinho carrinhoAtualizado);
    List<Carrinho> getCarrinhoIdCliente(@NotNull UUID idCliente);
    Carrinho getCarrinhoPorId(UUID idCarrinho);
    void salvaProduto(ItemCarrinho itemCarrinho);
}
