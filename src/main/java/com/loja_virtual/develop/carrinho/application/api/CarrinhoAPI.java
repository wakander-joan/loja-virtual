package com.loja_virtual.develop.carrinho.application.api;

import com.loja_virtual.develop.produto.application.api.ProdutoRequest;
import com.loja_virtual.develop.produto.application.api.ProdutoResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("/carrinho")
public interface CarrinhoAPI {

    @PostMapping("/criaCarrinho")
    @ResponseStatus(code = HttpStatus.CREATED)
    CarrinhoResponse postCarrinho (@Valid @RequestBody CarrinhoRequest produtoRequest);
}
