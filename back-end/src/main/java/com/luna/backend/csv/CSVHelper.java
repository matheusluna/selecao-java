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
        return TYPE.equals(file.getContentType());
    }

    public static List<HistoricoCSV> csvToHistorico(InputStream is){
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim())) {

            List<HistoricoCSV> historicoCSVS = new ArrayList<HistoricoCSV>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            for (CSVRecord csvRecord : csvRecords) {
                HistoricoCSV historicoCSV = new HistoricoCSV(
                        csvRecord.get(HEADERs[0]),
                        csvRecord.get(HEADERs[1]),
                        csvRecord.get(HEADERs[2]),
                        csvRecord.get(HEADERs[3]),
                        csvRecord.get(HEADERs[4]),
                        csvRecord.get(HEADERs[5]),
                        csvRecord.get(HEADERs[6]),
                        csvRecord.get(HEADERs[7]),
                        csvRecord.get(HEADERs[8]),
                        csvRecord.get(HEADERs[9]),
                        csvRecord.get(HEADERs[10])
                );

                historicoCSVS.add(historicoCSV);
            }

            return historicoCSVS;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }

}
