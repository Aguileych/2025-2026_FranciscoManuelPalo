package com.buscaminas.buscaminas.model;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDateTime;

@Entity
@Table(name = "partidas")
public class Partida {

    public enum Dificultad {
        FACIL, NORMAL, DIFICIL
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "jugador_id", nullable = false)
    private Usuario jugador;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Dificultad dificultad;

    @Column(nullable = false)
    private Integer tiempo;

    @Column(name = "numero_minas", nullable = false)
    private Integer numeroMinas;

    @Column(name = "minas_restantes", nullable = false)
    private Integer minasRestantes;

    @Column(name = "fecha_partida")
    private LocalDateTime fechaPartida;

    public LocalDateTime getFechaPartida() {
        return fechaPartida;
    }

    public void setFechaPartida(LocalDateTime fechaPartida) {
        this.fechaPartida = fechaPartida;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getJugador() {
        return jugador;
    }

    public void setJugador(Usuario jugador) {
        this.jugador = jugador;
    }

    public Dificultad getDificultad() {
        return dificultad;
    }

    public void setDificultad(Dificultad dificultad) {
        this.dificultad = dificultad;
    }

    public Integer getTiempo() {
        return tiempo;
    }

    public void setTiempo(Integer tiempo) {
        this.tiempo = tiempo;
    }

    public Integer getNumeroMinas() {
        return numeroMinas;
    }

    public void setNumeroMinas(Integer numeroMinas) {
        this.numeroMinas = numeroMinas;
    }

    public Integer getMinasRestantes() {
        return minasRestantes;
    }

    public void setMinasRestantes(Integer minasRestantes) {
        this.minasRestantes = minasRestantes;
    }
}