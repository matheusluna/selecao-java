package com.luna.backend.entities;

import java.util.Objects;

public class HistoricoCSV {
    private String regiao;
    private String estado;
    private String municipio;
    private String posto;
    private String postoCNPJ;
    private String produto;
    private String dataColeta;
    private String valorVenda;
    private String valorCompra;
    private String unidadeMedida;
    private String distribuidora;

    public HistoricoCSV() {
    }

    public HistoricoCSV(String regiao, String estado, String municipio, String posto, String postoCNPJ, String produto, String dataColeta, String valorVenda, String valorCompra, String unidadeMedida, String distribuidora) {
        this.regiao = regiao;
        this.estado = estado;
        this.municipio = municipio;
        this.posto = posto;
        this.postoCNPJ = postoCNPJ;
        this.produto = produto;
        this.dataColeta = dataColeta;
        this.valorVenda = valorVenda;
        this.valorCompra = valorCompra;
        this.unidadeMedida = unidadeMedida;
        this.distribuidora = distribuidora;
    }

    public String getRegiao() {
        return regiao;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getPosto() {
        return posto;
    }

    public void setPosto(String posto) {
        this.posto = posto;
    }

    public String getPostoCNPJ() {
        return postoCNPJ;
    }

    public void setPostoCNPJ(String postoCNPJ) {
        this.postoCNPJ = postoCNPJ;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public String getDataColeta() {
        return dataColeta;
    }

    public void setDataColeta(String dataColeta) {
        this.dataColeta = dataColeta;
    }

    public String getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(String valorVenda) {
        this.valorVenda = valorVenda;
    }

    public String getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(String valorCompra) {
        this.valorCompra = valorCompra;
    }

    public String getUnidadeMedida() {
        return unidadeMedida;
    }

    public void setUnidadeMedida(String unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }

    public String getDistribuidora() {
        return distribuidora;
    }

    public void setDistribuidora(String distribuidora) {
        this.distribuidora = distribuidora;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HistoricoCSV that = (HistoricoCSV) o;
        return Objects.equals(regiao, that.regiao) &&
                Objects.equals(estado, that.estado) &&
                Objects.equals(municipio, that.municipio) &&
                Objects.equals(posto, that.posto) &&
                Objects.equals(postoCNPJ, that.postoCNPJ) &&
                Objects.equals(produto, that.produto) &&
                Objects.equals(dataColeta, that.dataColeta) &&
                Objects.equals(valorVenda, that.valorVenda) &&
                Objects.equals(valorCompra, that.valorCompra) &&
                Objects.equals(unidadeMedida, that.unidadeMedida) &&
                Objects.equals(distribuidora, that.distribuidora);
    }

    @Override
    public int hashCode() {
        return Objects.hash(regiao, estado, municipio, posto, postoCNPJ, produto, dataColeta, valorVenda, valorCompra, unidadeMedida, distribuidora);
    }

    @Override
    public String toString() {
        return "HistoricoCSV{" +
                "regiao='" + regiao + '\'' +
                ", estado='" + estado + '\'' +
                ", municipio='" + municipio + '\'' +
                ", posto='" + posto + '\'' +
                ", postoCNPJ='" + postoCNPJ + '\'' +
                ", produto='" + produto + '\'' +
                ", dataColeta='" + dataColeta + '\'' +
                ", valorVenda='" + valorVenda + '\'' +
                ", valorCompra='" + valorCompra + '\'' +
                ", unidadeMedida='" + unidadeMedida + '\'' +
                ", distribuidora='" + distribuidora + '\'' +
                '}';
    }
}
