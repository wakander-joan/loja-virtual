package com.loja_virtual.develop.promocao.application.api;

import com.loja_virtual.develop.promocao.domain.StatusPromocao;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@ToString
public class PromocaoDetalhadoResponse {
    private String nomePromocao;
    private BigDecimal descontoPercentual;
    private StatusPromocao StatusPromocao;
}
