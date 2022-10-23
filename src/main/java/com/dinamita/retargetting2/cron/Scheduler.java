package com.dinamita.retargetting2.cron;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.dinamita.retargetting2.models.ProspectoSinTarjeta;
import com.dinamita.retargetting2.services.CsvService;
import com.dinamita.retargetting2.services.ProspectoService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@AllArgsConstructor
@Component
public class Scheduler {
    
    private final ProspectoService prospectoService;
    private final CsvService csvService;
    //Aquí se define el alias de cada cuanto se quiere actualizar la lista de prospectos. 
    @Scheduled(cron="${cron.10secondly}")
    public void scheduleTaskUsingCronExpression(){
        long now = System.currentTimeMillis()/1000;
        System.out.println("schedule tasks using cron jobs " + now);
        List<ProspectoSinTarjeta> list = this.prospectoService.listaProspectosSinTarjeta();
        list.forEach(log::debug);
        log.info("size: {}", list.size());
        
        csvService.escribirCSV(list, "ProspectosSinTarjeta-" + obtenerFecha());
    }

    private String obtenerFecha() {
        try {
            SimpleDateFormat myFormat = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
            return myFormat.format(new Date());
        } catch (Exception e) {
            return "archivo-prueba";
        }
    }
}
