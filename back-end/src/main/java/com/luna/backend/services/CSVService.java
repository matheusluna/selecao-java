package com.luna.backend.services;

import com.luna.backend.csv.CSVHelper;
import com.luna.backend.entities.*;

import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CSVService {

    private List<Regiao> getRegioes(InputStream is){
        List<HistoricoCSV> historicoCSVS = CSVHelper.csvToHistorico(is);
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

    private List<Estado> getEstados(InputStream is){
        List<HistoricoCSV> historicoCSVS = CSVHelper.csvToHistorico(is);
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
    private List<Municipio> getMunicipios(InputStream is){
        List<HistoricoCSV> historicoCSVS = CSVHelper.csvToHistorico(is);
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
    private List<Posto> getPostos(InputStream is){
        List<HistoricoCSV> historicoCSVS = CSVHelper.csvToHistorico(is);
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
    private List<Distribuidora> getDistribuidoras(InputStream is){
        List<HistoricoCSV> historicoCSVS = CSVHelper.csvToHistorico(is);
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
    private List<Produto> getProdutos(InputStream is){
        List<HistoricoCSV> historicoCSVS = CSVHelper.csvToHistorico(is);
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

    private List<HistoricoPreco> getHistoricos(InputStream is){
        List<HistoricoCSV> historicoCSVS = CSVHelper.csvToHistorico(is);
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
            historicoPreco.setData(this.parseDate(historicoCSV.getDataColeta()));
            historicoPrecos.add(historicoPreco);
        }
        return historicoPrecos;
    }

    private Long parseDate(String date){
        LocalDateTime localDateTime  = LocalDateTime.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        return localDateTime
                .atZone(ZoneId.systemDefault())
                .toInstant().toEpochMilli();
    }

}
