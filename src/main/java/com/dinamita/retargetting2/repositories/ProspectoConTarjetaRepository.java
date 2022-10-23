package com.dinamita.retargetting2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dinamita.retargetting2.models.ProspectoConTarjetaModel;

@Repository
public interface ProspectoConTarjetaRepository extends JpaRepository<ProspectoConTarjetaModel,Long>{}