package com.loja_virtual.develop.promocao.infra;

import com.loja_virtual.develop.promocao.domain.Promocao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PromocaoSpringDataJPARepository  extends JpaRepository<Promocao, UUID> {
}
