package com.loja_virtual.develop.produto.application.api;

import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log
public class ProdutoController implements ProdutoAPI {

    @Override
    public ProdutoResponse postProduto(ProdutoRequest ProdutoRequest) {
        log.info("[start] ProdutoController - postProduto");
        log.info("[finish] ProdutoController - postProduto");
        return null;
    }
}
