package com.luna.backend.entities;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long produtoId;
    private String descricao;
    @OneToMany(mappedBy = "produto")
    private List<HistoricoPreco> historicoPrecos;

    public Produto() {
    }

    public Long getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(Long produtoId) {
        this.produtoId = produtoId;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<HistoricoPreco> getHistoricoPrecos() {
        return historicoPrecos;
    }

    public void setHistoricoPrecos(List<HistoricoPreco> historicoPrecos) {
        this.historicoPrecos = historicoPrecos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Objects.equals(produtoId, produto.produtoId) &&
                Objects.equals(descricao, produto.descricao) &&
                Objects.equals(historicoPrecos, produto.historicoPrecos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(produtoId, descricao, historicoPrecos);
    }

    @Override
    public String toString() {
        return "Produto{" +
                "produtoId=" + produtoId +
                ", descricao='" + descricao + '\'' +
                ", historicoPrecos=" + historicoPrecos +
                '}';
    }
}
