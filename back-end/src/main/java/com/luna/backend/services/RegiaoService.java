package com.luna.backend.services;

import com.luna.backend.entities.Regiao;
import com.luna.backend.repositories.RegiaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegiaoService {
    @Autowired
    private RegiaoRepository regiaoRepository;

    public void create(Regiao regiao){
        this.regiaoRepository.save(regiao);
    }

    public void createAll(List<Regiao> regioes){
        this.regiaoRepository.saveAll(regioes);
    }

    public Optional<Regiao> read(String sigla){
        return this.regiaoRepository.findBySigla(sigla);
    }

    public Iterable<Regiao> list(){
        return this.regiaoRepository.findAll();
    }
}
