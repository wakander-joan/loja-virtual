package com.loja_virtual.develop.carrinho.domain;

import com.loja_virtual.develop.carrinho.application.api.AddProdutoRequest;
import com.loja_virtual.develop.carrinho.application.api.CarrinhoRequest;
import com.loja_virtual.develop.produto.domain.Produto;
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

    public static Carrinho criaCarrinho (CarrinhoRequest carrinhoRequest){
        Carrinho carrinho = new Carrinho();
        carrinho.setIdCliente(UUID.fromString(String.valueOf(carrinhoRequest.getIdCliente())));
        return Carrinho.adicionaItenIniciais(carrinho, carrinhoRequest);
    };

    public static Carrinho adicionaItenIniciais(Carrinho carrinho, CarrinhoRequest carrinhoRequest) {
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

    public static Carrinho adicionaIten(AddProdutoRequest addProdutoRequest, Carrinho carrinho, Produto produto) {
                    ItemCarrinho item = new ItemCarrinho();
                    item.setIdProduto(UUID.fromString(String.valueOf(produto.getIdProduto())));
                    item.setQuantidade(addProdutoRequest.getQuantidadeAdicional());
                    item.setCarrinho(carrinho); // Relaciona o item com o carrinho
                    carrinho.getItens().add(item);
                    return carrinho;
                }


    }


