package com.luna.backend.services;

import com.luna.backend.converters.CSVConverter;
import com.luna.backend.csv.CSVHelper;
import com.luna.backend.entities.*;
import com.luna.backend.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class CSVService {
    @Autowired
    private RegiaoService regiaoService;
    @Autowired
    private EstadoRepository estadoRepository;
    @Autowired
    private MunicipioRepository municipioRepository;
    @Autowired
    private PostoRepository postoRepository;
    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private DistribuidoraRepository distribuidoraRepository;
    @Autowired
    private HistoricoPrecoRepository historicoPrecoRepository;

    public void create(MultipartFile file){
        try{
            List<HistoricoCSV> historicoCSVS = CSVHelper.csvToHistorico(file.getInputStream());
            List<Regiao> regioes = CSVConverter.getRegioes(historicoCSVS);
            this.regiaoService.createAll(regioes);
            List<Estado> estados = this.setRegioesInEstados(CSVConverter.getEstados(historicoCSVS));
            this.estadoRepository.saveAll(estados);
            List<Municipio> municipios = this.setEstadosInMunicipios(CSVConverter.getMunicipios(historicoCSVS));
            this.municipioRepository.saveAll(municipios);
            List<Posto> postos = this.setMunicipiosInPostos(CSVConverter.getPostos(historicoCSVS));
            this.postoRepository.saveAll(postos);
            List<Produto> produtos = CSVConverter.getProdutos(historicoCSVS);
            this.produtoRepository.saveAll(produtos);
            List<Distribuidora> distribuidoras = CSVConverter.getDistribuidoras(historicoCSVS);
            this.distribuidoraRepository.saveAll(distribuidoras);
            List<HistoricoPreco> historicoPrecos = CSVConverter.getHistoricos(historicoCSVS);
            this.historicoPrecoRepository.saveAll(historicoPrecos);
        }catch (IOException e){
            throw new RuntimeException("fail to store csv data: " + e.getMessage());
        }
    }

    private List<Estado> setRegioesInEstados(List<Estado> estados){
        for (int i = 0; i < estados.size(); i++) {
            Regiao regiao = this.regiaoService.read(estados.get(i).getRegiao().getSigla()).orElse(null);
            estados.get(i).setRegiao(regiao);
        }
        return estados;
    }

    private List<Municipio> setEstadosInMunicipios(List<Municipio> municipios){
        for (int i = 0; i < municipios.size(); i++) {
            Estado estado = this.estadoRepository.findBySigla(municipios.get(i).getEstado().getSigla()).orElse(null);
            municipios.get(i).setEstado(estado);
        }
        return municipios;
    }

    private List<Posto> setMunicipiosInPostos(List<Posto> postos){
        for (int i = 0; i < postos.size(); i++) {
            Municipio municipio = this.municipioRepository.findByNome(postos.get(i).getMunicipio().getNome()).orElse(null);
            postos.get(i).setMunicipio(municipio);
        }
        return postos;
    }

    private List<HistoricoPreco> setParametrosInHistorico(List<HistoricoPreco> historicoPrecos){
        for (int i = 0; i < historicoPrecos.size(); i++) {
            HistoricoPreco historico = historicoPrecos.get(i);
            Posto posto = this.postoRepository.findByCnpj(historico.getPosto().getCnpj()).orElse(null);
            Produto produto = this.produtoRepository.findByDescricao(historico.getProduto().getDescricao()).orElse(null);
            Distribuidora distribuidora = this.distribuidoraRepository.findByNome(historico.getDistribuidora().getNome()).orElse(null);
            historicoPrecos.get(i).setPosto(posto);
            historicoPrecos.get(i).setProduto(produto);
            historicoPrecos.get(i).setDistribuidora(distribuidora);
        }
        return historicoPrecos;
    }
}
