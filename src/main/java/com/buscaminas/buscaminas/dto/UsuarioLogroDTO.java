package com.buscaminas.buscaminas.dto;

import com.buscaminas.buscaminas.model.UsuarioLogro;

public class UsuarioLogroDTO {

    public Long id;
    public Long jugadorId;
    public String jugadorUsername;
    public Long logroId;
    public String logroNombre;
    public Integer logroPuntos;

    public UsuarioLogroDTO(UsuarioLogro ul) {
        this.id = ul.getId();
        this.jugadorId = ul.getJugador().getId();
        this.jugadorUsername = ul.getJugador().getUsername();
        this.logroId = ul.getLogro().getId();
        this.logroNombre = ul.getLogro().getNombre();
        this.logroPuntos = ul.getLogro().getPuntos();
    }
}