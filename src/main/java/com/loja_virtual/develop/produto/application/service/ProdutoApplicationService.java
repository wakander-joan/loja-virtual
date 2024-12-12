package com.loja_virtual.develop.produto.application.service;

import com.loja_virtual.develop.produto.application.api.ProdutoRequest;
import com.loja_virtual.develop.produto.application.api.ProdutoResponse;
import com.loja_virtual.develop.produto.domain.Produto;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

@Service
@Log
@RequiredArgsConstructor
public class ProdutoApplicationService implements ProdutoService {
    private final ProdutoRepository produtoRepository;

    @Override
    public ProdutoResponse postProduto(ProdutoRequest produtoRequest) {
        log.info("[start] ProdutoApplicationService - postProduto");
        Produto produto = produtoRepository.salvaProduto(new Produto(produtoRequest));
        log.info("[finish] ProdutoApplicationService - postProduto");
        return new ProdutoResponse(produto);
    }
}
