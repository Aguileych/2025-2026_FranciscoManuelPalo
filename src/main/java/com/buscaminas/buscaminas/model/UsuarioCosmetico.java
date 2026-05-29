package com.buscaminas.buscaminas.model;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "usuario_cosmeticos")
public class UsuarioCosmetico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "jugador_id", nullable = false)
    private Usuario jugador;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "cosmetico_id", nullable = false)
    private Cosmetico cosmetico;

    @Column(nullable = false)
    private Boolean equipado = false;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Usuario getJugador() { return jugador; }
    public void setJugador(Usuario jugador) { this.jugador = jugador; }

    public Cosmetico getCosmetico() { return cosmetico; }
    public void setCosmetico(Cosmetico cosmetico) { this.cosmetico = cosmetico; }

    public Boolean getEquipado() { return equipado; }
    public void setEquipado(Boolean equipado) { this.equipado = equipado; }
}