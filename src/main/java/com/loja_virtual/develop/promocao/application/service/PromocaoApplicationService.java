package com.loja_virtual.develop.promocao.application.service;

import com.loja_virtual.develop.promocao.application.api.PromocaoRequest;
import com.loja_virtual.develop.promocao.application.api.PromocaoResponse;
import com.loja_virtual.develop.promocao.domain.Promocao;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

@Service
@Log
@RequiredArgsConstructor
public class PromocaoApplicationService implements PromocaoService {
    private final PromocaoRepository promocaoRepository;

    @Override
    public PromocaoResponse postPromocao(PromocaoRequest promocaoRequest) {
        log.info("[start] PromocaoApplicationService - postPromocao");
        Promocao promocao = promocaoRepository.postPromocao(new Promocao(promocaoRequest));
        log.info("[finish] PromocaoApplicationService - postPromocao");
        return new PromocaoResponse(promocao);
    }
}
