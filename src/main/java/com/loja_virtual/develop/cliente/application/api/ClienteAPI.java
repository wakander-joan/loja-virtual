package com.loja_virtual.develop.cliente.application.api;

import com.loja_virtual.develop.produto.application.api.ProdutoDetalhadoResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping ("/cliente")
public interface ClienteAPI {

    @PostMapping("/cadastraCliente")
    @ResponseStatus(code = HttpStatus.CREATED)
    ClienteResponse postCliente (@Valid @RequestBody ClienteRequest clienteRequest);

    @GetMapping("/getCliente/{idCliente}")
    @ResponseStatus(code = HttpStatus.OK)
    ClienteDetalhadoResponse getCliente (@PathVariable UUID idCliente);
}
