package com.loja_virtual.develop.promocao.application.service;

import com.loja_virtual.develop.promocao.application.api.PromocaoDetalhadoResponse;
import com.loja_virtual.develop.promocao.application.api.PromocaoRequest;
import com.loja_virtual.develop.promocao.application.api.PromocaoResponse;

import java.util.UUID;

public interface PromocaoService {
    PromocaoResponse postPromocao(PromocaoRequest promocaoRequest);
    PromocaoDetalhadoResponse getPromocao(UUID idPromocao);
}
