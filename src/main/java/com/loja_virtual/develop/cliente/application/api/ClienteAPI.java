package com.loja_virtual.develop.cliente.application.api;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("/cliente")
public interface ClienteAPI {

    @PostMapping("/cadastraCliente")
    @ResponseStatus(code = HttpStatus.CREATED)
    ClienteResponse postCliente (@Valid @RequestBody ClienteRequest clienteRequest);
}
