package com.dinamita.retargetting2.controllers;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dinamita.retargetting2.dto.ActualizarProspectoDTO;
import com.dinamita.retargetting2.services.ProspectoService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RequestMapping("/prospecto")
@RestController
public class ProspectoController {
 
    private final ProspectoService prospectoService;

    @PostMapping("/actualizar")
    public HttpEntity<Void> actualizarProspecto(@RequestBody ActualizarProspectoDTO actualizarProspectoDTO) {
        prospectoService.moverAProspectoConCliente(actualizarProspectoDTO.getCedulaCiudadania());
        return ResponseEntity.accepted().build();
    }

}