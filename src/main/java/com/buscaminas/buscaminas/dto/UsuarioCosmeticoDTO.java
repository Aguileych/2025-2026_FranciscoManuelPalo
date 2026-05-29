package com.buscaminas.buscaminas.dto;

import com.buscaminas.buscaminas.model.UsuarioCosmetico;

public class UsuarioCosmeticoDTO {

    public Long id;
    public Long jugadorId;
    public String jugadorUsername;
    public Long cosmeticoId;
    public String cosmeticoNombre;
    public Integer cosmeticoPrecio;
    public String cosmeticoEstilo;
    public Boolean equipado;

    public UsuarioCosmeticoDTO(UsuarioCosmetico uc) {
        this.id              = uc.getId();
        this.jugadorId       = uc.getJugador().getId();
        this.jugadorUsername = uc.getJugador().getUsername();
        this.cosmeticoId     = uc.getCosmetico().getId();
        this.cosmeticoNombre = uc.getCosmetico().getNombre();
        this.cosmeticoPrecio = uc.getCosmetico().getPrecioPuntos();
        this.cosmeticoEstilo = uc.getCosmetico().getEstilo();
        this.equipado        = uc.getEquipado();
    }
}