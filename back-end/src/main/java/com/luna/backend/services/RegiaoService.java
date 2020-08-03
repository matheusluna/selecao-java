package com.luna.backend.services;

import com.luna.backend.entities.Regiao;
import com.luna.backend.repositories.RegiaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegiaoService {
    @Autowired
    private RegiaoRepository regiaoRepository;

    public void create(Regiao regiao){
        this.regiaoRepository.save(regiao);
    }

    public Iterable<Regiao> list(){
        return this.regiaoRepository.findAll();
    }
}
