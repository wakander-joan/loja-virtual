package com.loja_virtual.develop.promocao.application.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Log
public class PromocaoController implements PromocaoAPI {

    @Override
    public PromocaoResponse postPromocao(PromocaoRequest promocaoRequest) {
        log.info("[start] PromocaoController - postPromocao");
        log.info("[finish] PromocaoController - postPromocao");
        return null;
    }
}
