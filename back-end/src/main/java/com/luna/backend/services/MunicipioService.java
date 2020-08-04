package com.luna.backend.services;

import com.luna.backend.entities.Estado;
import com.luna.backend.entities.Municipio;
import com.luna.backend.repositories.MunicipioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MunicipioService {
    @Autowired
    private MunicipioRepository municipioRepository;

    public void create(Municipio municipio){
        this.municipioRepository.save(municipio);
    }

    public Optional<Municipio> read(String nome){
        return this.municipioRepository.findByNome(nome);
    }

    public Optional<List<Municipio>> listByEstado(Estado estado){
        return this.municipioRepository.findAllByEstado(estado);
    }
}
