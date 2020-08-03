package com.luna.backend.csv;

import com.luna.backend.entities.*;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CSVHelper {
    public static String TYPE = "text/csv";
    static String[] HEADERs = {"Região - Sigla", "Estado - Sigla", "Município", "Revenda", "CNPJ da Revenda", "Produto", "Data da Coleta", "Valor de Venda", "Valor de Compra", "Unidade de Medida", "Bandeira"};

    public static boolean hasCSVFormat(MultipartFile file){
        return (!TYPE.equals(file.getContentType())) ? false : true;
    }

    public static List<Regiao> csvToRegiao(InputStream is){
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim())) {

            List<Regiao> regioes = new ArrayList<>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            for (CSVRecord csvRecord : csvRecords) {
                int cont = 0;
                for (int i = 0; i < regioes.size(); i++) {
                    if(regioes.get(i).getSigla().equals(csvRecord.get(HEADERs[0]))){
                        cont++;
                    }
                }
                if (cont == 0){
                    Regiao regiao = new Regiao();
                    regiao.setSigla(csvRecord.get(HEADERs[0]));
                    regioes.add(regiao);
                }
            }

            return regioes;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }

    public static List<Estado> csvToEstado(InputStream is){
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim())) {

            List<Estado> estados = new ArrayList<>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            for (CSVRecord csvRecord : csvRecords) {
                int cont = 0;
                for (int i = 0; i < estados.size(); i++) {
                    if(estados.get(i).getSigla().equals(csvRecord.get(HEADERs[1]))){
                        cont++;
                    }
                }
                if (cont == 0){
                    Estado estado = new Estado();
                    estado.setSigla(csvRecord.get(HEADERs[1]));
                    Regiao regiao = new Regiao();
                    regiao.setSigla(csvRecord.get(HEADERs[0]));
                    estado.setRegiao(regiao);
                    estados.add(estado);
                }
            }

            return estados;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }

    public static List<Municipio> csvToMunicipio(InputStream is){
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim())) {

            List<Municipio> municipios = new ArrayList<>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            for (CSVRecord csvRecord : csvRecords) {
                int cont = 0;
                for (int i = 0; i < municipios.size(); i++) {
                    if(municipios.get(i).getNome().equals(csvRecord.get(HEADERs[2]))){
                        cont++;
                    }
                }
                if (cont == 0){
                    Municipio municipio = new Municipio();
                    municipio.setNome(csvRecord.get(HEADERs[2]));
                    Estado estado = new Estado();
                    estado.setSigla(csvRecord.get(HEADERs[1]));
                    municipio.setEstado(estado);
                    municipios.add(municipio);
                }
            }

            return municipios;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }

    public static List<Posto> csvToPosto(InputStream is){
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim())) {

            List<Posto> postos = new ArrayList<>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            for (CSVRecord csvRecord : csvRecords) {
                Posto posto = new Posto();
                int cont = 0;
                for (int i = 0; i < postos.size(); i++) {
                    if(postos.get(i).getNome().equals(csvRecord.get(HEADERs[3]))){
                        cont++;
                    }
                }
                if (cont == 0){
                    posto.setCnpj(csvRecord.get(HEADERs[4]));
                    posto.setNome(csvRecord.get(HEADERs[3]));
                    Municipio municipio = new Municipio();
                    municipio.setNome(csvRecord.get(HEADERs[2]));
                    posto.setMunicipio(municipio);
                    postos.add(posto);
                }
            }

            return postos;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }

}
