package com.luna.backend.repositories;

import com.luna.backend.entities.Municipio;
import com.luna.backend.entities.Posto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PostoRepository extends CrudRepository<Posto, Long> {
    Optional<Posto> findByCnpj(String cnpj);
    Optional<List<Posto>> findAllByMunicipio(Municipio municipio);
}
