package com.loja_virtual.develop.produto.infra;

import com.loja_virtual.develop.handler.APIException;
import com.loja_virtual.develop.produto.application.service.ProdutoRepository;
import com.loja_virtual.develop.produto.domain.Produto;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
@Log4j2
@RequiredArgsConstructor
public class ProdutoInfraRepository implements ProdutoRepository {
    private final ProdutoSpringDataJPARepository produtoSpringDataJPARepository;

    @Override
    public Produto salvaProduto(Produto produto) {
        log.info("[start] ProdutoInfraRepository - salvaProduto");
        produtoSpringDataJPARepository.save(produto);
        log.info("[finish] ProdutoInfraRepository - salvaProduto");
        return produto;
    }

    @Override
    public Produto getProduto(UUID idProduto) {
        log.info("[start] ProdutoInfraRepository - getProduto");
        Produto produto = produtoSpringDataJPARepository.findById(idProduto)
                .orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Produto não encontrado"));
        log.info("[finish] ProdutoInfraRepository - getProduto");
        return produto;
    }

    @Override
    public List<Produto> getAllProdutos() {
        log.info("[start] ProdutoInfraRepository - getAllProdutos");
        List<Produto> produtos = produtoSpringDataJPARepository.findAll();
        log.info("[finish] ProdutoInfraRepository - getAllProdutos");
        return produtos;
    }
}
