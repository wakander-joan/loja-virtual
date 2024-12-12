package com.loja_virtual.develop.promocao.application.service;

import com.loja_virtual.develop.promocao.application.api.PromocaoRequest;
import com.loja_virtual.develop.promocao.application.api.PromocaoResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

@Service
@Log
@RequiredArgsConstructor
public class PromocaoApplicationService implements PromocaoService {
    @Override
    public PromocaoResponse postPromocao(PromocaoRequest promocaoRequest) {
    log.info("[start] PromocaoApplicationService - postPromocao");
    log.info("[finish] PromocaoApplicationService - postPromocao");
        return null;
    }
}
