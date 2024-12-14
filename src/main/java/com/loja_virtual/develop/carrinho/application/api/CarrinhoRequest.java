package com.loja_virtual.develop.carrinho.application.api;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.ToString;

import java.util.List;
import java.util.UUID;

@Getter
@ToString
public class CarrinhoRequest {
    @NotNull
    private UUID idCliente;
    @NotEmpty
    @Size(min = 1)
    private List<ItemCarrinhoRequest> itens;
}
