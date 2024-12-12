package com.loja_virtual.develop.produto.application.api;

import com.loja_virtual.develop.produto.domain.Produto;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Getter
@ToString
public class ProdutoListResponse {
    private UUID idProduto;
    private String nomeProduto;
    private BigDecimal precoProduto;

    public ProdutoListResponse(Produto produto) {
        this.idProduto = produto.getIdProduto();
        this.nomeProduto = produto.getNomeProduto();
        this.precoProduto = produto.getPrecoProduto();
    }

    public static List<ProdutoListResponse> converte(List<Produto> produtos) {
            return produtos.stream()
                    .filter(p -> p instanceof Produto)
                    .map(c -> new ProdutoListResponse(c))
                    .collect(Collectors.toList());
        }
    }
