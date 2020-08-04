package com.luna.backend.services;

import com.luna.backend.entities.Distribuidora;
import com.luna.backend.entities.HistoricoPreco;
import com.luna.backend.entities.Posto;
import com.luna.backend.entities.Produto;
import com.luna.backend.repositories.HistoricoPrecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HistoricoPrecoService {
    @Autowired
    private HistoricoPrecoRepository historicoPrecoRepository;

    public void create(HistoricoPreco historicoPreco){
        this.historicoPrecoRepository.save(historicoPreco);
    }

    public Optional<HistoricoPreco> read(Long id){
        return this.historicoPrecoRepository.findById(id);
    }

    public Optional<List<HistoricoPreco>> listByProduto(Produto produto){
        return this.historicoPrecoRepository.findAllByProduto(produto);
    }

    public Optional<List<HistoricoPreco>> listByPosto(Posto posto){
        return this.historicoPrecoRepository.findAllByPosto(posto);
    }

    public Optional<List<HistoricoPreco>> listByDistribuidora(Distribuidora distribuidora){
        return this.historicoPrecoRepository.findAllByDistribuidora(distribuidora);
    }
}
