package com.loja_virtual.develop.produto.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Getter
@ToString
@Builder
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
}
