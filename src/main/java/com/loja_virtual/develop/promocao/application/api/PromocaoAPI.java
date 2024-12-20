package com.loja_virtual.develop.promocao.application.api;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/promocao")
public interface PromocaoAPI {

    @PostMapping("/cadastraPromocao")
    @ResponseStatus(code = HttpStatus.CREATED)
    PromocaoResponse postPromocao (@Valid @RequestBody PromocaoRequest promocaoRequest);

    @GetMapping("/getPromocao/{idPromocao}")
    @ResponseStatus(code = HttpStatus.OK)
    PromocaoDetalhadoResponse getPromocao (@PathVariable UUID idPromocao);
}
