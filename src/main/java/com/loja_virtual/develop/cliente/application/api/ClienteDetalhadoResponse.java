package com.loja_virtual.develop.cliente.application.api;

import com.loja_virtual.develop.cliente.domain.Cliente;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.ToString;
import org.hibernate.validator.constraints.br.CPF;

import java.util.UUID;

@Getter
@ToString
public class ClienteDetalhadoResponse {
    private UUID idCliente;
    private String nome;
    private String email;
    private String cpf;

    public ClienteDetalhadoResponse(Cliente cliente) {
        this.idCliente = cliente.getIdCliente();
        this.nome = cliente.getNome();
        this.email = cliente.getEmail();
        this.cpf = cliente.getCpf();
    }
}
