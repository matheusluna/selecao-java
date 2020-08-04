package com.luna.backend.services;

import com.luna.backend.entities.Estado;
import com.luna.backend.entities.Regiao;
import com.luna.backend.repositories.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstadoService {

    @Autowired
    private EstadoRepository estadoRepository;

    public void create(Estado estado){
        this.estadoRepository.save(estado);
    }

    public Optional<Estado> read(String sigla){
        return this.estadoRepository.findBySigla(sigla);
    }

    public Optional<List<Estado>> listByRegiao(Regiao regiao){
        return this.estadoRepository.findAllByRegiao(regiao);
    }
}
