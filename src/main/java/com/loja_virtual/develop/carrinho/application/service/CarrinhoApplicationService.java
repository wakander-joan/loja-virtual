package com.loja_virtual.develop.carrinho.application.service;

import com.loja_virtual.develop.carrinho.application.api.CarrinhoRequest;
import com.loja_virtual.develop.carrinho.application.api.CarrinhoResponse;
import com.loja_virtual.develop.carrinho.domain.Carrinho;
import com.loja_virtual.develop.cliente.application.service.ClienteService;
import com.loja_virtual.develop.handler.APIException;
import com.loja_virtual.develop.produto.application.service.ProdutoRepository;
import com.loja_virtual.develop.produto.application.service.ProdutoService;
import com.loja_virtual.develop.produto.domain.Produto;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.UUID;

import static com.loja_virtual.develop.carrinho.domain.Carrinho.criaCarrinho;

@Service
@Log4j2
@RequiredArgsConstructor
public class CarrinhoApplicationService implements CarrinhoService {
    private final CarrinhoRepository carrinhoRepository;

    private final ClienteService clienteService;
    private final ProdutoRepository produtoRepository;


    @Override
    public CarrinhoResponse postCarrinho(CarrinhoRequest carrinhoRequest) {
        log.info("[start] CarrinhoApplicationService - postCarrinho");
        verificaCliente(carrinhoRequest.getIdCliente());
        verificaCarrinhosDeCliente(carrinhoRequest);
        verificaProdutos(carrinhoRequest);
        Carrinho carrinhoAtualizado = criaCarrinho(carrinhoRequest);
        carrinhoRepository.save(carrinhoAtualizado);

        log.info("[finish] CarrinhoApplicationService - postCarrinho");
        return new CarrinhoResponse(carrinhoAtualizado);
    }

    private void verificaCarrinhosDeCliente(CarrinhoRequest carrinhoRequest) {
        carrinhoRepository.getCarrinhoIdCliente(carrinhoRequest.getIdCliente());
    }

    public void verificaProdutos(CarrinhoRequest carrinhoRequest) {
        log.info("[start] CarrinhoApplicationService - verificaProdutos");
        carrinhoRequest.getItens().forEach(itemDoCarrinhoRequest -> {
            Produto produtoEstoque = produtoRepository.getProduto(itemDoCarrinhoRequest.getIdProduto());
            if (produtoEstoque.getEstoque() < itemDoCarrinhoRequest.getQuantidade()) {
                throw APIException.build(HttpStatus.NOT_FOUND, "Não tem estoque disponivel um dos Produtos");
            }
            int valorAlterado = produtoEstoque.alteraEstoque(itemDoCarrinhoRequest.getQuantidade());
            log.info("Produto Verificado!", produtoEstoque.getNomeProduto());
            log.info("Estoque Alterado para", valorAlterado);
        });
        log.info("[finish] CarrinhoApplicationService - verificaProdutos");
    }

    public void  verificaCliente(UUID idCliente){
        clienteService.getCliente(idCliente);
    }
}
