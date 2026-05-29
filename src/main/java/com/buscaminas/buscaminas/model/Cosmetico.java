package com.buscaminas.buscaminas.model;

import jakarta.persistence.*;

@Entity
@Table(name = "cosmeticos")
public class Cosmetico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(name = "precio_puntos", nullable = false)
    private Integer precioPuntos;

    @Column(length = 100)
    private String estilo;
    @Column(name = "imagen_url")
    private String imagenUrl;

    public String getImagenUrl() {
        return imagenUrl;
    }

    public void setImagenUrl(String imagenUrl) {
        this.imagenUrl = imagenUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getPrecioPuntos() {
        return precioPuntos;
    }

    public void setPrecioPuntos(Integer precioPuntos) {
        this.precioPuntos = precioPuntos;
    }

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }
}