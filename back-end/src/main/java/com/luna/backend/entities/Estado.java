package com.luna.backend.entities;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Estado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long estadoId;
    private String sigla;
    @ManyToOne
    @JoinColumn(name = "regiao_id")
    private Regiao regiao;
    @OneToMany(mappedBy = "estado")
    private List<Municipio> municipios;

    public Estado() {
    }

    public Long getEstadoId() {
        return estadoId;
    }

    public void setEstadoId(Long estadoId) {
        this.estadoId = estadoId;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public Regiao getRegiao() {
        return regiao;
    }

    public void setRegiao(Regiao regiao) {
        this.regiao = regiao;
    }

    public List<Municipio> getMunicipios() {
        return municipios;
    }

    public void setMunicipios(List<Municipio> municipios) {
        this.municipios = municipios;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Estado estado = (Estado) o;
        return Objects.equals(estadoId, estado.estadoId) &&
                Objects.equals(sigla, estado.sigla) &&
                Objects.equals(regiao, estado.regiao) &&
                Objects.equals(municipios, estado.municipios);
    }

    @Override
    public int hashCode() {
        return Objects.hash(estadoId, sigla, regiao, municipios);
    }

    @Override
    public String toString() {
        return "Estado{" +
                "estadoId=" + estadoId +
                ", sigla='" + sigla + '\'' +
                ", regiao=" + regiao +
                ", municipios=" + municipios +
                '}';
    }
}
