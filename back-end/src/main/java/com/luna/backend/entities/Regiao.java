package com.luna.backend.entities;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Regiao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long regiaoId;
    private String sigla;
    @OneToMany(mappedBy = "regiao")
    private List<Estado> estados;

    public Regiao() {
    }

    public Long getRegiaoId() {
        return regiaoId;
    }

    public void setRegiaoId(Long regiaoId) {
        this.regiaoId = regiaoId;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public List<Estado> getEstados() {
        return estados;
    }

    public void setEstados(List<Estado> estados) {
        this.estados = estados;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Regiao regiao = (Regiao) o;
        return Objects.equals(regiaoId, regiao.regiaoId) &&
                Objects.equals(sigla, regiao.sigla) &&
                Objects.equals(estados, regiao.estados);
    }

    @Override
    public int hashCode() {
        return Objects.hash(regiaoId, sigla, estados);
    }

    @Override
    public String toString() {
        return "Regiao{" +
                "regiaoId=" + regiaoId +
                ", sigla='" + sigla + '\'' +
                ", estados=" + estados +
                '}';
    }
}
