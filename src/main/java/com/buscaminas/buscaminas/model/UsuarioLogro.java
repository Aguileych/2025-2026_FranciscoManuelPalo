package com.buscaminas.buscaminas.model;


import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "usuario_logros")
public class UsuarioLogro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "jugador_id", nullable = false)
    private Usuario jugador;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "logro_id", nullable = false)
    private Logro logro;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Usuario getJugador() { return jugador; }
    public void setJugador(Usuario jugador) { this.jugador = jugador; }

    public Logro getLogro() { return logro; }
    public void setLogro(Logro logro) { this.logro = logro; }

}