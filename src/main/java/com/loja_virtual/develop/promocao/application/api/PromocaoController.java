package com.loja_virtual.develop.promocao.application.api;

import com.loja_virtual.develop.promocao.application.service.PromocaoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.RestController;

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
}
