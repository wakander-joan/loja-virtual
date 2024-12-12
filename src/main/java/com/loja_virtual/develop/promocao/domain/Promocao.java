package com.loja_virtual.develop.promocao.domain;

import com.loja_virtual.develop.promocao.application.api.PromocaoRequest;
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
public class Promocao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid", updatable = false, unique = true, nullable = false)
    private UUID idPromocao;
    private String nomePromocao;
    private BigDecimal descontoPercentual;
    private StatusPromocao StatusPromocao;

    public Promocao(PromocaoRequest promocaoRequest) {
        this.nomePromocao = promocaoRequest.getNomePromocao();
        this.descontoPercentual = promocaoRequest.getDescontoPercentual();
    }
}
