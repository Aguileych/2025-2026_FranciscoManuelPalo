package com.buscaminas.buscaminas.repository;

import com.buscaminas.buscaminas.model.UsuarioLogro;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface UsuarioLogroRepository extends JpaRepository<UsuarioLogro, Long> {

    List<UsuarioLogro> findByJugadorId(Long jugadorId);

    Optional<UsuarioLogro> findByJugadorIdAndLogroId(Long jugadorId, Long logroId);

    boolean existsByJugadorIdAndLogroId(Long jugadorId, Long logroId);
}
