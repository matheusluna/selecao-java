package com.luna.backend.repositories;

import com.luna.backend.entities.Distribuidora;
import com.luna.backend.entities.HistoricoPreco;
import com.luna.backend.entities.Posto;
import com.luna.backend.entities.Produto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface HistoricoPrecoRepository extends CrudRepository<HistoricoPreco, Long> {
    Optional<List<HistoricoPreco>> findByPosto(Posto posto);
    Optional<List<HistoricoPreco>> findByDistribuidora(Distribuidora distribuidora);
    Optional<List<HistoricoPreco>> findByProduto(Produto produto);}
