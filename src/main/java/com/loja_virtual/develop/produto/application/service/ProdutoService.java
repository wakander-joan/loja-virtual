package com.loja_virtual.develop.produto.application.service;

import com.loja_virtual.develop.produto.application.api.ProdutoDetalhadoResponse;
import com.loja_virtual.develop.produto.application.api.ProdutoRequest;
import com.loja_virtual.develop.produto.application.api.ProdutoResponse;

import java.util.UUID;

public interface ProdutoService {
    ProdutoResponse postProduto(ProdutoRequest produtoRequest);
    ProdutoDetalhadoResponse getProduto(UUID idProduto);
}
