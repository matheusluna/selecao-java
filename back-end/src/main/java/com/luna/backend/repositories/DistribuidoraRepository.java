package com.luna.backend.repositories;

import com.luna.backend.entities.Distribuidora;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface DistribuidoraRepository extends CrudRepository<Distribuidora, Long> {
    Optional<Distribuidora> findByNome(String nome);
}
