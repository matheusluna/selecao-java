package com.luna.backend.services;

import com.luna.backend.entities.Municipio;
import com.luna.backend.entities.Posto;
import com.luna.backend.repositories.PostoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostoService {
    @Autowired
    private PostoRepository postoRepository;

    public void create(Posto posto){
        this.postoRepository.save(posto);
    }

    public Optional<Posto> read(String cnpj){
        return this.postoRepository.findByCnpj(cnpj);
    }

    public Optional<List<Posto>> listByMunicipio(Municipio municipio){
        return this.postoRepository.findAllByMunicipio(municipio);
    }
}
