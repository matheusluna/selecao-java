package com.luna.backend.services;

import com.luna.backend.entities.Distribuidora;
import com.luna.backend.repositories.DistribuidoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DistribuidoraService {
    @Autowired
    private DistribuidoraRepository distribuidoraRepository;

    public void create(Distribuidora distribuidora){
        this.distribuidoraRepository.save(distribuidora);
    }

    public Optional<Distribuidora> read(String nome){
        return this.distribuidoraRepository.findByNome(nome);
    }

    public Iterable<Distribuidora> list(){
        return this.distribuidoraRepository.findAll();
    }
}
