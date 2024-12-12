package com.loja_virtual.develop.produto.application.service;

import com.loja_virtual.develop.produto.application.api.ProdutoRequest;
import com.loja_virtual.develop.produto.application.api.ProdutoResponse;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

@Service
@Log
public class ProdutoApplicationService implements ProdutoService {
    @Override
    public ProdutoResponse postProduto(ProdutoRequest produtoRequest) {
        log.info("[start] ProdutoApplicationService - postProduto");
        log.info("[finish] ProdutoApplicationService - postProduto");
        return null;
    }
}
