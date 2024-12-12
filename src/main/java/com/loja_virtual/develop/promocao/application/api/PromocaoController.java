package com.loja_virtual.develop.promocao.application.api;

import com.loja_virtual.develop.promocao.application.service.PromocaoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@Log
public class PromocaoController implements PromocaoAPI {
    private final PromocaoService promocaoService;

    @Override
    public PromocaoResponse postPromocao(PromocaoRequest promocaoRequest) {
        log.info("[start] PromocaoController - postPromocao");
        PromocaoResponse promocao = promocaoService.postPromocao(promocaoRequest);
        log.info("[finish] PromocaoController - postPromocao");
        return promocao;
    }

    @Override
    public PromocaoDetalhadoResponse getPromocao(UUID idPromocao) {
        log.info("[start] PromocaoController - getPromocao");
        PromocaoDetalhadoResponse promocao = promocaoService.getPromocao(idPromocao);
        log.info("[finish] PromocaoController - getPromocao");
        return promocao;
    }
}
