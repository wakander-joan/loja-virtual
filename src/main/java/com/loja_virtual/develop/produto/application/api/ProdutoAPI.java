package com.loja_virtual.develop.produto.application.api;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping ("/produto")
public interface ProdutoAPI {

    @PostMapping("/cadastraProduto")
    @ResponseStatus(code = HttpStatus.CREATED)
    ProdutoResponse postProduto (@Valid @RequestBody ProdutoRequest produtoRequest);

    @GetMapping("/getProduto/{idProduto}")
    @ResponseStatus(code = HttpStatus.CREATED)
    ProdutoDetalhadoResponse getProduto (@PathVariable UUID idProduto);

}
