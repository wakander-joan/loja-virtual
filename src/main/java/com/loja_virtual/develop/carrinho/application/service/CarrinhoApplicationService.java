package com.loja_virtual.develop.carrinho.application.service;

import com.loja_virtual.develop.carrinho.application.api.CarrinhoRequest;
import com.loja_virtual.develop.carrinho.application.api.CarrinhoResponse;
import com.loja_virtual.develop.carrinho.domain.Carrinho;
import com.loja_virtual.develop.carrinho.domain.ItemCarrinho;
import com.loja_virtual.develop.cliente.application.service.ClienteService;
import com.loja_virtual.develop.produto.application.api.ProdutoDetalhadoResponse;
import com.loja_virtual.develop.produto.application.service.ProdutoService;
import com.loja_virtual.develop.produto.domain.Produto;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static com.loja_virtual.develop.carrinho.domain.Carrinho.criaCarrinho;

@Service
@Log4j2
@RequiredArgsConstructor
public class CarrinhoApplicationService implements CarrinhoService {
    private final CarrinhoRepository carrinhoRepository;
    private final ClienteService clienteService;
    private final ProdutoService produtoService;


    @Override
    public CarrinhoResponse postCarrinho(CarrinhoRequest carrinhoRequest) {
        log.info("[start] CarrinhoApplicationService - postCarrinho");
        verificaCliente(carrinhoRequest.getIdCliente());
        verificaProdutos(carrinhoRequest);
        Carrinho carrinhoAtualizado = criaCarrinho(carrinhoRequest);
        carrinhoRepository.save(carrinhoAtualizado);
        log.info("[finish] CarrinhoApplicationService - postCarrinho");
        return new CarrinhoResponse(carrinhoAtualizado);
    }

    public void verificaProdutos(CarrinhoRequest carrinhoRequest) {
        log.info("[start] CarrinhoApplicationService - verificaProdutos");
        carrinhoRequest.getItens().forEach(itemDoCarrinhoRequest -> {
            var produto = produtoService.getProduto(itemDoCarrinhoRequest.getIdProduto());
            log.info("Produto Verificado!", produto.getNomeProduto(),produto.getIdProduto());
        });
        log.info("[finish] CarrinhoApplicationService - verificaProdutos");
    }


    public void  verificaCliente(UUID idCliente){
        clienteService.getCliente(idCliente);
    }
}
