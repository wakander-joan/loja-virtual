package com.loja_virtual.develop.carrinho.application.service;

import com.loja_virtual.develop.carrinho.application.api.AddProdutoRequest;
import com.loja_virtual.develop.carrinho.application.api.CarrinhoRequest;
import com.loja_virtual.develop.carrinho.application.api.CarrinhoResponse;
import com.loja_virtual.develop.carrinho.domain.Carrinho;
import com.loja_virtual.develop.cliente.application.service.ClienteService;
import com.loja_virtual.develop.handler.APIException;
import com.loja_virtual.develop.produto.application.service.ProdutoRepository;
import com.loja_virtual.develop.produto.domain.Produto;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import static com.loja_virtual.develop.carrinho.domain.Carrinho.adicionaIten;
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
        validaClienteSemCarrinho(carrinhoRequest.getIdCliente());
        verificaProdutos(carrinhoRequest);
        Carrinho carrinhoAtualizado = criaCarrinho(carrinhoRequest);
        carrinhoRepository.save(carrinhoAtualizado);
        log.info("[finish] CarrinhoApplicationService - postCarrinho");
        return new CarrinhoResponse(carrinhoAtualizado);
    }

    @Override
    public void addProdutoCarrinho(AddProdutoRequest addProdutoRequest) {
        log.info("[start] CarrinhoApplicationService - addProdutoCarrinho");
        verificaCliente(addProdutoRequest.getIdCliente());
        validaClienteTemCarrinho(addProdutoRequest);
        Produto produto = verificaProduto(addProdutoRequest);
        Carrinho carrinho = getCarrinhoPorId(addProdutoRequest.getIdCarrinho());
        Carrinho carrinhoAtualizado = adicionaIten(addProdutoRequest, carrinho,produto);
        carrinhoRepository.save(carrinhoAtualizado);

        log.info("[finish] CarrinhoApplicationService - addProdutoCarrinho");
    }

    private Produto verificaProduto(AddProdutoRequest addProdutoRequest) {
       Produto produto = produtoRepository.getProduto(addProdutoRequest.getIdProduto());
       Carrinho carrinho = getCarrinhoPorId(addProdutoRequest.getIdCarrinho());
        boolean produtoJaExiste = carrinho.getItens().stream()
                .anyMatch(itemDoCarrinho -> itemDoCarrinho.getIdProduto().equals(produto.getIdProduto()));
        if (produtoJaExiste) {
            throw APIException.build(HttpStatus.NOT_FOUND, "Produto já existe no carrinho");
        }
        else if (produto.getEstoque() < addProdutoRequest.getQuantidadeAdicional()) {
            throw APIException.build(HttpStatus.NOT_FOUND, "Estoque do Produto Insufuciente!");
        }
        log.info("Produto Verificado!");
        produto.alteraEstoque(addProdutoRequest.getQuantidadeAdicional());
        log.info("Estoque Alterado para");
        return produto;
    }

    private void validaClienteSemCarrinho(UUID idCliente) {
        List<Carrinho> carrinhos = carrinhoRepository.getCarrinhoIdCliente(idCliente);
        if (!carrinhos.isEmpty()) {
            log.error("Já existem carrinhos associados ao cliente");
            throw APIException.build(HttpStatus.NOT_FOUND, "Já existe um carrinho associado ao Cliente");
        }
        log.info("Cliente Verificado! Esse cliente não possui carrinho!");
    }

    private void validaClienteTemCarrinho(AddProdutoRequest addProdutoRequest) {
        List<Carrinho> carrinhos = carrinhoRepository.getCarrinhoIdCliente(addProdutoRequest.getIdCliente());
        if (carrinhos.isEmpty()) {
            log.error("Não existe carrinho associado ao cliente!");
            throw APIException.build(HttpStatus.NOT_FOUND, "Não existe carrinho associado ao cliente!");
        }
        log.info("Cliente Verificado! Esse cliente possui carrinho!");
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

    public Carrinho getCarrinhoPorId(UUID idCarrinho){
        log.info("[start] CarrinhoApplicationService - getCarrinhoPorId");
        Carrinho carrinho = carrinhoRepository.getCarrinhoPorId(idCarrinho);
        log.info("[finish] CarrinhoApplicationService - getCarrinhoPorId");
        return carrinho;
    }
}