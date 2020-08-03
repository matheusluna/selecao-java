package com.luna.backend.entities;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Distribuidora {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long distribuidoraId;
    private String nome;
    @OneToMany(mappedBy = "distribuidora")
    private List<HistoricoPreco> historicoPrecos;

    public Distribuidora() {
    }

    public Long getDistribuidoraId() {
        return distribuidoraId;
    }

    public void setDistribuidoraId(Long distribuidoraId) {
        this.distribuidoraId = distribuidoraId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
        Distribuidora that = (Distribuidora) o;
        return Objects.equals(distribuidoraId, that.distribuidoraId) &&
                Objects.equals(nome, that.nome) &&
                Objects.equals(historicoPrecos, that.historicoPrecos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(distribuidoraId, nome, historicoPrecos);
    }

    @Override
    public String toString() {
        return "Distribuidora{" +
                "distribuidoraId=" + distribuidoraId +
                ", nome='" + nome + '\'' +
                ", historicoPrecos=" + historicoPrecos +
                '}';
    }
}
