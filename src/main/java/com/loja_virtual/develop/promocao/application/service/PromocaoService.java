package com.loja_virtual.develop.promocao.application.service;

import com.loja_virtual.develop.promocao.application.api.PromocaoRequest;
import com.loja_virtual.develop.promocao.application.api.PromocaoResponse;

public interface PromocaoService {
    PromocaoResponse postPromocao(PromocaoRequest promocaoRequest);
}
