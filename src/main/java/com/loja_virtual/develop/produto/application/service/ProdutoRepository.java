package com.loja_virtual.develop.produto.application.service;

import com.loja_virtual.develop.produto.domain.Produto;

import java.util.List;
import java.util.UUID;

public interface ProdutoRepository {
    Produto salvaProduto(Produto produto);
    Produto getProduto(UUID idProduto);
    List<Produto> getAllProdutos();
}
