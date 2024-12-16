package com.loja_virtual.develop.carrinho.application.api;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.ToString;

import java.util.UUID;

@Getter
@ToString
public class AddProdutoRequest {
    @NotNull
    private UUID idCliente;
    @NotNull
    private UUID idProduto;
    @NotNull
    private int quantidade;
}
