package com.loja_virtual.develop.carrinho.application.api;

import com.loja_virtual.develop.cliente.application.api.ClienteDetalhadoResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping ("/carrinho")
public interface CarrinhoAPI {

    @PostMapping("/criaCarrinho")
    @ResponseStatus(code = HttpStatus.CREATED)
    CarrinhoResponse postCarrinho (@Valid @RequestBody CarrinhoRequest carrinhoRequest);

    @PostMapping("/addProdutoCarrinho")
    @ResponseStatus(code = HttpStatus.OK)
    void addProdutoCarrinho (@Valid @RequestBody AddProdutoRequest addProdutoRequest);

}
