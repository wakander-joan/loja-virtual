package com.loja_virtual.develop.produto.application.service;

import com.loja_virtual.develop.produto.application.api.ProdutoDetalhadoResponse;
import com.loja_virtual.develop.produto.application.api.ProdutoListResponse;
import com.loja_virtual.develop.produto.application.api.ProdutoRequest;
import com.loja_virtual.develop.produto.application.api.ProdutoResponse;
import com.loja_virtual.develop.produto.domain.Produto;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

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

    @Override
    public ProdutoDetalhadoResponse getProduto(UUID idProduto) {
        log.info("[start] ProdutoApplicationService - getProduto");
        Produto produto = produtoRepository.getProduto(idProduto);
        log.info("[finish] ProdutoApplicationService - getProduto");
        return new ProdutoDetalhadoResponse(produto);
    }

    @Override
    public List<ProdutoListResponse> getAllProdutos() {
        log.info("[start] ProdutoApplicationService - getAllProdutos");
        List<Produto> produtos =produtoRepository.getAllProdutos();
        log.info("[finish] ProdutoApplicationService - getAllProdutos");
        return ProdutoListResponse.converte(produtos);
    }
}
