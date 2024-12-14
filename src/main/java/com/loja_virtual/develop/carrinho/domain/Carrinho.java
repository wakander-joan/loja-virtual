package com.loja_virtual.develop.carrinho.domain;

import com.loja_virtual.develop.carrinho.application.api.CarrinhoRequest;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Carrinho {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid", updatable = false, unique = true, nullable = false)
    private UUID idCarrinho;
    @Column(unique = true, nullable = false)
    private UUID idCliente;

    @OneToMany(mappedBy = "carrinho", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemCarrinho> itens;

    public static Carrinho adicionaIten(Carrinho carrinho, CarrinhoRequest carrinhoRequest) {

        List<ItemCarrinho> itens = carrinhoRequest.getItens().stream()
                .map(itemDoCarrinhoRequest -> {
                    ItemCarrinho item = new ItemCarrinho();
                    item.setIdProduto(UUID.fromString(String.valueOf(itemDoCarrinhoRequest.getIdProduto())));
                    item.setQuantidade(itemDoCarrinhoRequest.getQuantidade());
                    item.setCarrinho(carrinho); // Relaciona o item com o carrinho
                    return item;
                })
                .collect(Collectors.toList());

        carrinho.setItens(itens);
        return carrinho;
    }
}
