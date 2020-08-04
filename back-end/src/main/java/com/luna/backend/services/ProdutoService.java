package com.luna.backend.services;

import com.luna.backend.entities.Produto;
import com.luna.backend.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    public void create(Produto produto){
        this.produtoRepository.save(produto);
    }

    public Optional<Produto> read(String descricao){
        return this.produtoRepository.findByDescricao(descricao);
    }

    public Iterable<Produto> list(){
        return this.produtoRepository.findAll();
    }
}
