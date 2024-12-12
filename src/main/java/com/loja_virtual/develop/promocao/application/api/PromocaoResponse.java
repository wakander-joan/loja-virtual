package com.loja_virtual.develop.promocao.application.api;

import com.loja_virtual.develop.promocao.domain.Promocao;
import lombok.Getter;
import lombok.ToString;

import java.util.UUID;

@Getter
@ToString
public class PromocaoResponse {
    private UUID idPromocao;

    public PromocaoResponse(Promocao promocao) {
        this.idPromocao = promocao.getIdPromocao();
    }
}
