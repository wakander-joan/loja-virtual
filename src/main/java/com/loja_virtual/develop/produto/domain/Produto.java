package com.loja_virtual.develop.produto.domain;

import com.loja_virtual.develop.produto.application.api.ProdutoRequest;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Builder(access = AccessLevel.PACKAGE)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid", updatable = false, unique = true, nullable = false)
    private UUID idProduto;

    private String nomeProduto;
    private String descricao;
    private BigDecimal precoProduto;
    private int estoque;
    private Categoria categoria;
    private String promocaoProduto;

    public Produto(ProdutoRequest produtoRequest) {
        this.nomeProduto = produtoRequest.getNomeProduto();
        this.descricao = produtoRequest.getDescricao();
        this.precoProduto = produtoRequest.getPrecoProduto();
        this.estoque = produtoRequest.getEstoque();
        this.categoria = produtoRequest.getCategoria();
        this.promocaoProduto = produtoRequest.getPromocaoProduto();
    }
}
