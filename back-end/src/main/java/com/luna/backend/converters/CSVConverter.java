package com.luna.backend.converters;

import com.luna.backend.csv.CSVHelper;
import com.luna.backend.entities.*;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class CSVConverter {
    public static List<Regiao> getRegioes(List<HistoricoCSV> historicoCSVS){
        List<Regiao> regioes = new ArrayList<>();
        for(HistoricoCSV historicoCSV : historicoCSVS){
            int cont = 0;
            for (int i = 0; i < regioes.size(); i++) {
                if (historicoCSV.getRegiao().equals(regioes.get(i).getSigla())) cont++;
            }
            if (cont == 0){
                Regiao regiao = new Regiao();
                regiao.setSigla(historicoCSV.getRegiao());
                regioes.add(regiao);
            }
        }
        return regioes;
    }

    public static List<Estado> getEstados(List<HistoricoCSV> historicoCSVS){
        List<Estado> estados = new ArrayList<>();
        for(HistoricoCSV historicoCSV : historicoCSVS){
            int cont = 0;
            for (int i = 0; i < estados.size(); i++) {
                if (historicoCSV.getEstado().equals(estados.get(i).getSigla())) cont++;
            }
            if (cont == 0){
                Regiao regiao = new Regiao();
                regiao.setSigla(historicoCSV.getRegiao());
                Estado estado = new Estado();
                estado.setSigla(historicoCSV.getEstado());
                estado.setRegiao(regiao);
                estados.add(estado);
            }
        }
        return estados;
    }
    public static List<Municipio> getMunicipios(List<HistoricoCSV> historicoCSVS){
        List<Municipio> municipios = new ArrayList<>();
        for(HistoricoCSV historicoCSV : historicoCSVS){
            int cont = 0;
            for (int i = 0; i < municipios.size(); i++) {
                if (historicoCSV.getMunicipio().equals(municipios.get(i).getNome())) cont++;
            }
            if (cont == 0){
                Estado estado = new Estado();
                estado.setSigla(historicoCSV.getEstado());
                Municipio municipio = new Municipio();
                municipio.setNome(historicoCSV.getMunicipio());
                municipio.setEstado(estado);
                municipios.add(municipio);
            }
        }
        return municipios;
    }
    public static List<Posto> getPostos(List<HistoricoCSV> historicoCSVS){
        List<Posto> postos = new ArrayList<>();
        for(HistoricoCSV historicoCSV : historicoCSVS){
            int cont = 0;
            for (int i = 0; i < postos.size(); i++) {
                if (historicoCSV.getPostoCNPJ().equals(postos.get(i).getCnpj())) cont++;
            }
            if (cont == 0){
                Municipio municipio = new Municipio();
                municipio.setNome(historicoCSV.getMunicipio());
                Posto posto = new Posto();
                posto.setNome(historicoCSV.getPosto());
                posto.setCnpj(historicoCSV.getPostoCNPJ());
                posto.setMunicipio(municipio);
                postos.add(posto);
            }
        }
        return postos;
    }
    public static List<Distribuidora> getDistribuidoras(List<HistoricoCSV> historicoCSVS){
        List<Distribuidora> distribuidoras = new ArrayList<>();
        for(HistoricoCSV historicoCSV : historicoCSVS){
            int cont = 0;
            for (int i = 0; i < distribuidoras.size(); i++) {
                if (historicoCSV.getDistribuidora().equals(distribuidoras.get(i).getNome())) cont++;
            }
            if (cont == 0){
                Distribuidora distribuidora = new Distribuidora();
                distribuidora.setNome(historicoCSV.getDistribuidora());
                distribuidoras.add(distribuidora);
            }
        }
        return distribuidoras;
    }
    public static List<Produto> getProdutos(List<HistoricoCSV> historicoCSVS){
        List<Produto> produtos = new ArrayList<>();
        for(HistoricoCSV historicoCSV : historicoCSVS){
            int cont = 0;
            for (int i = 0; i < produtos.size(); i++) {
                if (historicoCSV.getProduto().equals(produtos.get(i).getDescricao())) cont++;
            }
            if (cont == 0){
                Produto produto = new Produto();
                produto.setDescricao(historicoCSV.getProduto());
                produtos.add(produto);
            }
        }
        return produtos;
    }

    public static List<HistoricoPreco> getHistoricos(List<HistoricoCSV> historicoCSVS){
        List<HistoricoPreco> historicoPrecos = new ArrayList<>();
        for(HistoricoCSV historicoCSV : historicoCSVS){
            HistoricoPreco historicoPreco = new HistoricoPreco();
            //adicionando posto
            Posto posto = new Posto();
            posto.setNome(historicoCSV.getPosto());
            historicoPreco.setPosto(posto);
            //adicionando distribuidora
            Distribuidora distribuidora = new Distribuidora();
            distribuidora.setNome(historicoCSV.getDistribuidora());
            historicoPreco.setDistribuidora(distribuidora);
            //adicionando produto
            Produto produto = new Produto();
            produto.setDescricao(historicoCSV.getProduto());
            historicoPreco.setProduto(produto);
            //adicionando valor de compra
            historicoPreco.setValorCompra(Double.valueOf(historicoCSV.getValorCompra()));
            //adicionando valor de venda
            historicoPreco.setValorVenda(Double.valueOf(historicoCSV.getValorVenda()));
            //adicionando unidade de medida
            historicoPreco.setUnidadeMedida(historicoCSV.getUnidadeMedida());
            //adicionando data de coleta
            historicoPreco.setData(DateConverter.parseDate(historicoCSV.getDataColeta()));
            historicoPrecos.add(historicoPreco);
        }
        return historicoPrecos;
    }
}
