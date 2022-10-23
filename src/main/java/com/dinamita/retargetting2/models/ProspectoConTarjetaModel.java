package com.dinamita.retargetting2.models;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * ProspectoSinTarjeta
 */
@ToString
@Getter
@Setter
@Entity
@Table(name = "prospectoConTarjeta")
public class ProspectoConTarjetaModel {
   
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