package com.loja_virtual.develop.produto.application.service;

import com.loja_virtual.develop.produto.application.api.ProdutoDetalhadoResponse;
import com.loja_virtual.develop.produto.application.api.ProdutoListResponse;
import com.loja_virtual.develop.produto.application.api.ProdutoRequest;
import com.loja_virtual.develop.produto.application.api.ProdutoResponse;
import com.loja_virtual.develop.produto.domain.Produto;
import com.loja_virtual.develop.promocao.application.service.PromocaoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Log4j2
@RequiredArgsConstructor
public class ProdutoApplicationService implements ProdutoService {
    private final ProdutoRepository produtoRepository;
    private final PromocaoService promocaoService;

    @Override
    public ProdutoResponse postProduto(ProdutoRequest produtoRequest) {
        log.info("[start] ProdutoApplicationService - postProduto");
        verificaIdPromocao(produtoRequest.getIdPromocao());
        Produto produto = produtoRepository.salvaProduto(new Produto(produtoRequest));
        log.info("[finish] ProdutoApplicationService - postProduto");
        return new ProdutoResponse(produto);
    }

    private void verificaIdPromocao(UUID idPromocaoRequest) {
        if (idPromocaoRequest == null) {
            log.info("[id de Promoção é nulo, nenhuma validação necessária]");
            return;
        }else {
            promocaoService.getPromocao(idPromocaoRequest);
            log.info("[id de Promoção Valido!]");
        }
    }

    @Override
    public ProdutoDetalhadoResponse getProduto(UUID idProduto) {
        log.info("[start] ProdutoApplicationService - getProduto");
        Produto produto = produtoRepository.getProduto(idProduto);
        log.info("[finish] ProdutoApplicationService - getProduto");
        return new ProdutoDetalhadoResponse(produto);
    }

    @Override
    public List<ProdutoListResponse> getAllProdutos() {
        log.info("[start] ProdutoApplicationService - getAllProdutos");
        List<Produto> produtos =produtoRepository.getAllProdutos();
        log.info("[finish] ProdutoApplicationService - getAllProdutos");
        return ProdutoListResponse.converte(produtos);
    }
}
