package com.loja_virtual.develop.carrinho.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@ToString
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class ItemCarrinho {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid", updatable = false, unique = true, nullable = false)
    private UUID idItenCarrinho;
    @Column(nullable = false)
    private UUID idProduto;
    @Column(nullable = false)
    private int quantidade;
    @ManyToOne
    @JoinColumn(name = "id_carrinho", nullable = false)
    private Carrinho carrinho;

}
