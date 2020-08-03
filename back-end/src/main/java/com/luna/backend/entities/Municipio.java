package com.luna.backend.entities;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Municipio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long municipioId;
    private String nome;
    @ManyToOne
    @JoinColumn(name = "estado_id")
    private Estado estado;
    @OneToMany(mappedBy = "municipio")
    private List<Posto> postos;

    public Municipio() {
    }

    public Long getMunicipioId() {
        return municipioId;
    }

    public void setMunicipioId(Long municipioId) {
        this.municipioId = municipioId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public List<Posto> getPostos() {
        return postos;
    }

    public void setPostos(List<Posto> postos) {
        this.postos = postos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Municipio municipio = (Municipio) o;
        return Objects.equals(municipioId, municipio.municipioId) &&
                Objects.equals(nome, municipio.nome) &&
                Objects.equals(estado, municipio.estado) &&
                Objects.equals(postos, municipio.postos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(municipioId, nome, estado, postos);
    }

    @Override
    public String toString() {
        return "Municipio{" +
                "municipioId=" + municipioId +
                ", nome='" + nome + '\'' +
                ", estado=" + estado +
                ", postos=" + postos +
                '}';
    }
}
