package com.buscaminas.buscaminas.dto;

import com.buscaminas.buscaminas.model.Logro;

public class LogroDTO {

    public Long id;
    public String nombre;
    public String descripcion;
    public Integer puntos;

    public LogroDTO(Logro l) {
        this.id = l.getId();
        this.nombre = l.getNombre();
        this.descripcion = l.getDescripcion();
        this.puntos = l.getPuntos();
    }
}