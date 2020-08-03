package com.luna.backend.entities;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Posto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postoId;
    private String nome;
    private String cnpj;
    @ManyToOne
    @JoinColumn(name = "municipio_id")
    private Municipio municipio;
    @OneToMany(mappedBy = "posto")
    private List<HistoricoPreco> historicoPrecoList;

    public Posto() {
    }

    public Long getPostoId() {
        return postoId;
    }

    public void setPostoId(Long postoId) {
        this.postoId = postoId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    public List<HistoricoPreco> getHistoricoPrecoList() {
        return historicoPrecoList;
    }

    public void setHistoricoPrecoList(List<HistoricoPreco> historicoPrecoList) {
        this.historicoPrecoList = historicoPrecoList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Posto posto = (Posto) o;
        return Objects.equals(postoId, posto.postoId) &&
                Objects.equals(nome, posto.nome) &&
                Objects.equals(cnpj, posto.cnpj) &&
                Objects.equals(municipio, posto.municipio) &&
                Objects.equals(historicoPrecoList, posto.historicoPrecoList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(postoId, nome, cnpj, municipio, historicoPrecoList);
    }

    @Override
    public String toString() {
        return "Posto{" +
                "postoId=" + postoId +
                ", nome='" + nome + '\'' +
                ", cnpj='" + cnpj + '\'' +
                ", municipio=" + municipio +
                ", historicoPrecoList=" + historicoPrecoList +
                '}';
    }
}
