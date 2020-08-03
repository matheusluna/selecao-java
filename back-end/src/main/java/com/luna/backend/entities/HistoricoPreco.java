package com.luna.backend.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class HistoricoPreco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long historicoId;
    private Double valorVenda;
    private Double valorCompra;
    private String unidadeMedida;
    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;
    @ManyToOne
    @JoinColumn(name = "distribuidora_id")
    private Distribuidora distribuidora;
    @ManyToOne
    @JoinColumn(name = "posto_id")
    private Posto posto;

    public HistoricoPreco() {
    }

    public Long getHistoricoId() {
        return historicoId;
    }

    public void setHistoricoId(Long historicoId) {
        this.historicoId = historicoId;
    }

    public Double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(Double valorVenda) {
        this.valorVenda = valorVenda;
    }

    public Double getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(Double valorCompra) {
        this.valorCompra = valorCompra;
    }

    public String getUnidadeMedida() {
        return unidadeMedida;
    }

    public void setUnidadeMedida(String unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Distribuidora getDistribuidora() {
        return distribuidora;
    }

    public void setDistribuidora(Distribuidora distribuidora) {
        this.distribuidora = distribuidora;
    }

    public Posto getPosto() {
        return posto;
    }

    public void setPosto(Posto posto) {
        this.posto = posto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HistoricoPreco that = (HistoricoPreco) o;
        return Objects.equals(historicoId, that.historicoId) &&
                Objects.equals(valorVenda, that.valorVenda) &&
                Objects.equals(valorCompra, that.valorCompra) &&
                Objects.equals(unidadeMedida, that.unidadeMedida) &&
                Objects.equals(produto, that.produto) &&
                Objects.equals(distribuidora, that.distribuidora) &&
                Objects.equals(posto, that.posto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(historicoId, valorVenda, valorCompra, unidadeMedida, produto, distribuidora, posto);
    }

    @Override
    public String toString() {
        return "HistoricoPreco{" +
                "historicoId=" + historicoId +
                ", valorVenda=" + valorVenda +
                ", valorCompra=" + valorCompra +
                ", unidadeMedida='" + unidadeMedida + '\'' +
                ", produto=" + produto +
                ", distribuidora=" + distribuidora +
                ", posto=" + posto +
                '}';
    }
}
