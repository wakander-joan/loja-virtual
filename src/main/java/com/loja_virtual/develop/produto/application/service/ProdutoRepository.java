package com.loja_virtual.develop.produto.application.service;

import com.loja_virtual.develop.produto.domain.Produto;

public interface ProdutoRepository {
    Produto salvaProduto(Produto produto);
}
