package com.buscaminas.buscaminas.repository;

import com.buscaminas.buscaminas.model.Cosmetico;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CosmeticoRepository extends JpaRepository<Cosmetico, Long> {
    List<Cosmetico> findByEstilo(String estilo);
}