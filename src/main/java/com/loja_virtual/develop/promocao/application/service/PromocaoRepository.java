package com.loja_virtual.develop.promocao.application.service;

import com.loja_virtual.develop.promocao.domain.Promocao;

public interface PromocaoRepository {
    Promocao postPromocao(Promocao promocao);
}
