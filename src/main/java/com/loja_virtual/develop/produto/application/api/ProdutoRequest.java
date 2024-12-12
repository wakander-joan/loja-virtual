package com.loja_virtual.develop.produto.application.api;

import com.loja_virtual.develop.produto.domain.Categoria;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@ToString
public class ProdutoRequest {
    @NotBlank
    private String nomeProduto;
    @NotBlank
    private String descricao;
    @NotNull
    private BigDecimal precoProduto;
    @Min(0)
    private int estoque;
    private Categoria categoria;
    private UUID idPromocao;
}
