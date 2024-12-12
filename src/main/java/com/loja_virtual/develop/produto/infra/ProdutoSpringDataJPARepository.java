package com.loja_virtual.develop.produto.infra;

import com.loja_virtual.develop.produto.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProdutoSpringDataJPARepository extends JpaRepository<Produto, UUID> {
}
