package com.dinamita.retargetting2.services;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.dinamita.retargetting2.models.ProspectoSinTarjeta;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class CsvService {

    public void escribirCSV(List<ProspectoSinTarjeta> list, String fileName) {
        try (FileWriter fileWriter = new FileWriter(".\\"+fileName+".csv");
            CSVPrinter printer = new CSVPrinter(fileWriter, CSVFormat.DEFAULT);){
            
            for (ProspectoSinTarjeta prosp : list) {
                printer.printRecord(prosp.getId(), prosp.getNombre(), prosp.getApellidos(), prosp.getCedulaCiudadania(), prosp.getTelefono(), prosp.getEmail());
            }
            
            } catch (IOException e) {
                log.error(e.getMessage(), e);
            }
            
    }
    
}