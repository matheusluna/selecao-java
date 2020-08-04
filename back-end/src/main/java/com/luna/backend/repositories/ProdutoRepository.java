package com.luna.backend.repositories;

import com.luna.backend.entities.Produto;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ProdutoRepository extends CrudRepository<Produto, Long> {
    Optional<Produto> findByDescricao(String descricao);
}
