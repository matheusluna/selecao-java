package com.luna.backend.repositories;

import com.luna.backend.entities.Estado;
import com.luna.backend.entities.Municipio;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface MunicipioRepository extends CrudRepository<Municipio, Long> {
    Optional<Municipio> findByNome(String nome);
    Optional<List<Municipio>> findAllByEstado(Estado estado);
}
