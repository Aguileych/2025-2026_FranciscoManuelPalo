package com.buscaminas.buscaminas.repository;

import com.buscaminas.buscaminas.model.UsuarioCosmetico;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface UsuarioCosmeticoRepository extends JpaRepository<UsuarioCosmetico, Long> {
    List<UsuarioCosmetico> findByJugadorId(Long jugadorId);
}