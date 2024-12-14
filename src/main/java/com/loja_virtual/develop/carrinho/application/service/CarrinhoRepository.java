package com.loja_virtual.develop.carrinho.application.service;

import com.loja_virtual.develop.carrinho.domain.Carrinho;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public interface CarrinhoRepository {
    void save(Carrinho carrinhoAtualizado);
    void getCarrinhoIdCliente(@NotNull UUID idCliente);
}
