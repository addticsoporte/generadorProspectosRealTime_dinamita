package com.dinamita.retargetting2.repositories;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Id;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dinamita.retargetting2.models.ProspectoSinTarjeta;


@Repository
public interface ProspectoSinTarjetaRepository extends JpaRepository<ProspectoSinTarjeta,Long>{

    List<ProspectoSinTarjeta> findAllByCedulaCiudadania(String cedulaCiudadania);
    
}