package com.luna.backend.repositories;

import com.luna.backend.entities.Regiao;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RegiaoRepository extends CrudRepository<Regiao, Long> {
    public Optional<Regiao> findBySigla(String sigla);
}
