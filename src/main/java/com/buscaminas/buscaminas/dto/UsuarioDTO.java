package com.buscaminas.buscaminas.dto;

import com.buscaminas.buscaminas.model.Usuario;
import java.time.LocalDateTime;

public class UsuarioDTO {
    public Long id;
    public String username;
    public String email;
    public Integer puntosLogro;
    // public Boolean administrador;
    public LocalDateTime createdAt;

    public UsuarioDTO(Usuario u) {
        this.id = u.getId();
        this.username = u.getUsername();
        this.email = u.getEmail();
        this.puntosLogro = u.getPuntosLogro();
        // this.administrador = u.getAdministrador();
        this.createdAt = u.getCreatedAt();
    }
}
