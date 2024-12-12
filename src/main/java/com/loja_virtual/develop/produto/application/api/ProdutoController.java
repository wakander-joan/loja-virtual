package com.loja_virtual.develop.produto.application.api;

import com.loja_virtual.develop.produto.application.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@Log
@RequiredArgsConstructor
public class ProdutoController implements ProdutoAPI {
    private final ProdutoService produtoService;

    @Override
    public ProdutoResponse postProduto(ProdutoRequest produtoRequest) {
        log.info("[start] ProdutoController - postProduto");
        ProdutoResponse produto = produtoService.postProduto(produtoRequest);
        log.info("[finish] ProdutoController - postProduto");
        return produto;
    }

    @Override
    public ProdutoDetalhadoResponse getProduto(UUID idProduto) {
        log.info("[start] ProdutoController - getProduto");
        ProdutoDetalhadoResponse produto = produtoService.getProduto(idProduto);
        log.info("[finish] ProdutoController - getProduto");
        return produto;
    }
}
