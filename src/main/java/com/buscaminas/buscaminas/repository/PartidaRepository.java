package com.buscaminas.buscaminas.repository;

import com.buscaminas.buscaminas.model.Partida;
import com.buscaminas.buscaminas.model.Partida.Dificultad;

import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDateTime;
import java.util.List;

public interface PartidaRepository extends JpaRepository<Partida, Long> {
    List<Partida> findByJugadorId(Long jugadorId);

    List<Partida> findTop10ByDificultadAndMinasRestantesEqualsOrderByTiempo(Dificultad dificultad,int minas_restantes);

    List<Partida> findByJugadorIdOrderByIdDesc(Long jugadorId);

    default Partida guardarNuevaPartida(Partida partida) {
        partida.setFechaPartida(LocalDateTime.now());
        return save(partida);
    }
}