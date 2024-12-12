package com.loja_virtual.develop.produto.infra;

import com.loja_virtual.develop.produto.application.service.ProdutoRepository;
import com.loja_virtual.develop.produto.domain.Produto;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@Log
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
        Produto produto = produtoSpringDataJPARepository.getById(idProduto);
        log.info("[finish] ProdutoInfraRepository - getProduto");
        return produto;
    }
}
