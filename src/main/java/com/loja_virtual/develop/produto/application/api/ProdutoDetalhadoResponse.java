package com.loja_virtual.develop.produto.application.api;

import com.loja_virtual.develop.produto.domain.Categoria;
import com.loja_virtual.develop.produto.domain.Produto;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@ToString
public class ProdutoDetalhadoResponse {
    private UUID idProduto;
    private String nomeProduto;
    private String descricao;
    private BigDecimal precoProduto;
    private int estoque;
    private Categoria categoria;
    private UUID idPromocao;

    public ProdutoDetalhadoResponse(Produto produto) {
        this.idProduto = produto.getIdProduto();
        this.nomeProduto = produto.getNomeProduto();
        this.descricao = produto.getDescricao();
        this.precoProduto = produto.getPrecoProduto();
        this.estoque = produto.getEstoque();
        this.categoria = produto.getCategoria();
        this.idPromocao = produto.getIdPromocao();
    }
}
