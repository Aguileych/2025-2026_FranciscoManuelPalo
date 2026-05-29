package com.buscaminas.buscaminas.dto;

import com.buscaminas.buscaminas.model.Partida;
import java.time.LocalDateTime;

public class PartidaDTO {

    public Long id;
    public Long jugadorId;
    public String jugadorUsername;
    public String dificultad;
    public Integer tiempo;
    public Integer numeroMinas;
    public Integer minasRestantes;
    public String resultado;
    public LocalDateTime fechaPartida;

    public PartidaDTO(Partida p) {
        this.id = p.getId();
        this.jugadorId = p.getJugador().getId();
        this.jugadorUsername = p.getJugador().getUsername();
        this.dificultad = mapDificultad(p.getDificultad());
        this.tiempo = p.getTiempo();
        this.numeroMinas = p.getNumeroMinas();
        this.minasRestantes = p.getMinasRestantes();
        this.resultado = p.getMinasRestantes() == 0 ? "win" : "loss";
        this.fechaPartida = p.getFechaPartida();
    }

    private static String mapDificultad(Partida.Dificultad d) {
        switch (d) {
            case FACIL:
                return "easy";
            case NORMAL:
                return "normal";
            case DIFICIL:
                return "hard";
            default:
                return d.name().toLowerCase();
        }
    }
}