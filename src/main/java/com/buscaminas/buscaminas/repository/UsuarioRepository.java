package com.buscaminas.buscaminas.repository;

import com.buscaminas.buscaminas.model.Usuario;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByUsername(String username);
    Usuario findByEmail(String email);

    List<Usuario> findAllByOrderByPuntosLogroDesc();
}