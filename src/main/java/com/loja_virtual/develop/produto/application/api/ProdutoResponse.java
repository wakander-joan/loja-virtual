package com.loja_virtual.develop.produto.application.api;

import lombok.Getter;
import lombok.ToString;

import java.util.UUID;

@Getter
@ToString
public class ProdutoResponse {
    private UUID idProduto;
}
