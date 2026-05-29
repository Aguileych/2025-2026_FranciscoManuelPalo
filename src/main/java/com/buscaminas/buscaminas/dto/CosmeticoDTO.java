package com.buscaminas.buscaminas.dto;

import com.buscaminas.buscaminas.model.Cosmetico;

public class CosmeticoDTO {

    public Long id;
    public String nombre;
    public Integer precioPuntos;
    public String estilo;
    public String imagenUrl;

    public CosmeticoDTO(Cosmetico c) {
        this.id = c.getId();
        this.nombre = c.getNombre();
        this.precioPuntos = c.getPrecioPuntos();
        this.estilo = c.getEstilo();
        this.imagenUrl = c.getImagenUrl();
    }
}