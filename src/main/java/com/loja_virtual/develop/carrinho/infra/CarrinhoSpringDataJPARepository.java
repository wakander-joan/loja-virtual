package com.loja_virtual.develop.carrinho.infra;

import com.loja_virtual.develop.carrinho.domain.Carrinho;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CarrinhoSpringDataJPARepository extends JpaRepository<Carrinho, UUID> {
}
