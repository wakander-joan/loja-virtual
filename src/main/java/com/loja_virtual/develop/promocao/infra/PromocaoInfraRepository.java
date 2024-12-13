package com.loja_virtual.develop.promocao.infra;

import com.loja_virtual.develop.handler.APIException;
import com.loja_virtual.develop.promocao.application.service.PromocaoRepository;
import com.loja_virtual.develop.promocao.domain.Promocao;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@Log
@RequiredArgsConstructor
public class PromocaoInfraRepository implements PromocaoRepository {
    private final PromocaoSpringDataJPARepository promocaoSpringDataJPARepository;

    @Override
    public Promocao postPromocao(Promocao promocao) {
        log.info("[start] PromocaoInfraRepository - postPromocao");
        Promocao promocaoSalva = promocaoSpringDataJPARepository.save(promocao);
        log.info("[finish] PromocaoInfraRepository - postPromocao");
        return promocaoSalva;
    }

    @Override
    public Promocao getPromocao(UUID idPromocao) {
        log.info("[start] PromocaoInfraRepository - getPromocao");
        Promocao promocao = promocaoSpringDataJPARepository.findById(idPromocao)
                .orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Promoção não encontrada"));
        log.info("[finish] PromocaoInfraRepository - getPromocao");
        return promocao;
    }
}
