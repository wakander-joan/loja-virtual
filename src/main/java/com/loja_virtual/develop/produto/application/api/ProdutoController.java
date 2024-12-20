package com.loja_virtual.develop.produto.application.api;

import com.loja_virtual.develop.produto.application.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@Log4j2
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

    @Override
    public List<ProdutoListResponse> getAllProdutos() {
        log.info("[start] ProdutoController - getAllProdutos");
        List<ProdutoListResponse> produtos = produtoService.getAllProdutos();
        log.info("[finish] ProdutoController - getAllProdutos");
        return produtos;
    }
}
