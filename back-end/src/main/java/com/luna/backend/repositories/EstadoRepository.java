package com.luna.backend.repositories;

import com.luna.backend.entities.Estado;
import com.luna.backend.entities.Regiao;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface EstadoRepository extends CrudRepository<Estado, Long> {
    Optional<Estado> findBySigla(String sigla);
    Optional<List<Estado>> findAllByRegiao(Regiao regiao);
}
