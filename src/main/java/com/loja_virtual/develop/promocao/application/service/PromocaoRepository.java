package com.loja_virtual.develop.promocao.application.service;

import com.loja_virtual.develop.promocao.domain.Promocao;

import java.util.UUID;

public interface PromocaoRepository {
    Promocao postPromocao(Promocao promocao);
    Promocao getPromocao(UUID idPromocao);
}
