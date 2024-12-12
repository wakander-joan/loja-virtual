package com.loja_virtual.develop.produto.application.api;

import com.loja_virtual.develop.produto.domain.Produto;
import lombok.Getter;
import lombok.ToString;

import java.util.UUID;

@Getter
@ToString
public class ProdutoResponse {
    private UUID idProduto;

    public ProdutoResponse(Produto produto) {
        this.idProduto = produto.getIdProduto();
    }
}
