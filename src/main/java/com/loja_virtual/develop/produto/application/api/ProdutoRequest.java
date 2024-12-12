package com.loja_virtual.develop.produto.application.api;

import com.loja_virtual.develop.produto.domain.Categoria;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@ToString
public class ProdutoRequest {
    @NotNull
    private String nomeProduto;
    @NotNull
    private String descricao;
    @NotNull
    private BigDecimal precoProduto;
    private int estoque;
    private Categoria categoria;
    private String promocaoProduto;
}
