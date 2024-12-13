package com.loja_virtual.develop.produto.application.api;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping ("/produto")
public interface ProdutoAPI {

    @PostMapping("/cadastraProduto")
    @ResponseStatus(code = HttpStatus.CREATED)
    ProdutoResponse postProduto (@Valid @RequestBody ProdutoRequest produtoRequest);

    @GetMapping("/getProduto/{idProduto}")
    @ResponseStatus(code = HttpStatus.OK)
    ProdutoDetalhadoResponse getProduto (@PathVariable UUID idProduto);

    @GetMapping("/getAllProduto")
    @ResponseStatus(code = HttpStatus.OK)
    List <ProdutoListResponse> getAllProdutos();

}
