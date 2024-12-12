package com.loja_virtual.develop.promocao.application.api;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@ToString
public class PromocaoRequest {
    @NotNull
    private String nomePromocao;
    @NotNull
    private BigDecimal descontoPercentual;
}
