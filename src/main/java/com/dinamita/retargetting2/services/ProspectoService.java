package com.dinamita.retargetting2.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dinamita.retargetting2.models.ProspectoSinTarjeta;
import com.dinamita.retargetting2.models.ProspectoConTarjetaModel;
import com.dinamita.retargetting2.repositories.ProspectoSinTarjetaRepository;
import com.dinamita.retargetting2.repositories.ProspectoConTarjetaRepository;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@AllArgsConstructor
@Service
public class ProspectoService {

    private final ProspectoSinTarjetaRepository prospectoRepository;
    private final ProspectoConTarjetaRepository prospectoSinCreditoRepository;

    public void moverAProspectoConCliente(String cedulaCiudadania) {
        log.info(cedulaCiudadania);
        List<ProspectoSinTarjeta> listaProspectos = this.prospectoRepository.findAllByCedulaCiudadania(cedulaCiudadania);
        log.info("size: {}", listaProspectos.size());
        List<ProspectoConTarjetaModel> listCopia = listaProspectos.stream().map(this::copiarProspecto).collect(Collectors.toList());
        this.prospectoSinCreditoRepository.saveAll(listCopia);
        listaProspectos.forEach(this.prospectoRepository::delete);
    }

    public List<ProspectoSinTarjeta> listaProspectosSinTarjeta() {
        return this.prospectoRepository.findAll();
    }

    private ProspectoConTarjetaModel copiarProspecto(ProspectoSinTarjeta prospectoModel) {
        ProspectoConTarjetaModel copia = new ProspectoConTarjetaModel();
        copia.setApellidos(prospectoModel.getApellidos());
        copia.setCedulaCiudadania(prospectoModel.getCedulaCiudadania());
        copia.setEmail(prospectoModel.getEmail());
        copia.setNombre(prospectoModel.getNombre());
        copia.setTelefono(prospectoModel.getTelefono());
        return copia;
    }

}
