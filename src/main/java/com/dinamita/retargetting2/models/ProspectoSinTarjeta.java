package com.dinamita.retargetting2.models;

import java.sql.Date;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * ProspectoConTarjeta
 */
@ToString
@Getter
@Setter
@Entity
@Table(name = "prospectoSinTarjeta")
public class ProspectoSinTarjeta {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    private String nombre;
    private String apellidos;
    private String cedulaCiudadania;
    private String telefono;
    private String email;

}