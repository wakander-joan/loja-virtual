package com.loja_virtual.develop.cliente.domain;

import com.loja_virtual.develop.cliente.application.api.ClienteRequest;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;


import java.util.UUID;

@Entity
@Getter
@ToString
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid", updatable = false, unique = true, nullable = false)
    private UUID idCliente;

    private String nome;
    @Email
    @Column(unique = true, nullable = false)
    private String email;
    @CPF
    @Column(unique = true, nullable = false)
    private String cpf;

    public Cliente(ClienteRequest clienteRequest) {
        this.nome = clienteRequest.getNome();
        this.email = clienteRequest.getEmail();
        this.cpf = clienteRequest.getCpf();
    }
}
