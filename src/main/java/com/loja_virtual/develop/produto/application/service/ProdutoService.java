package com.loja_virtual.develop.produto.application.service;

import com.loja_virtual.develop.produto.application.api.ProdutoRequest;
import com.loja_virtual.develop.produto.application.api.ProdutoResponse;

public interface ProdutoService {
    ProdutoResponse postProduto(ProdutoRequest produtoRequest);
}
