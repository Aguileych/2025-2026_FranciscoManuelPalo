package com.buscaminas.buscaminas.controller;

import com.buscaminas.buscaminas.dto.UsuarioDTO;
import com.buscaminas.buscaminas.model.Usuario;
import com.buscaminas.buscaminas.repository.UsuarioRepository;

import jakarta.servlet.http.HttpServletResponse;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public UsuarioController(UsuarioRepository usuarioRepository,
            PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping
    public List<UsuarioDTO> listar() {
        return usuarioRepository.findAll()
                .stream()
                .map(UsuarioDTO::new)
                .toList();
    }

    @GetMapping("/{id}")
    public UsuarioDTO obtener(@PathVariable Long id) {
        return usuarioRepository.findById(id)
                .map(UsuarioDTO::new)
                .orElse(null);
    }

    @GetMapping("/ranking")
    public List<UsuarioDTO> ranking() {
        return usuarioRepository.findAllByOrderByPuntosLogroDesc()
                .stream()
                .map(UsuarioDTO::new)
                .toList();
    }

    @PutMapping("/{id}/username")
    public Object cambiarUsername(@PathVariable Long id,
            @RequestBody Map<String, String> body,
            HttpServletResponse response) {
        Usuario usuario = usuarioRepository.findById(id).orElse(null);
        if (usuario == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return Map.of("error", "Usuario no encontrado");
        }

        String nuevoUsername = body.get("username");

        usuario.setUsername(nuevoUsername);
        usuarioRepository.save(usuario);
        return new UsuarioDTO(usuario);
    }

    @PutMapping("/{id}/password")
    public Object cambiarPassword(@PathVariable Long id,
            @RequestBody Map<String, String> body,
            HttpServletResponse response) {
        Usuario usuario = usuarioRepository.findById(id).orElse(null);

        String passwordActual = body.get("passwordActual");
        String passwordNueva = body.get("passwordNueva");

        if (!passwordEncoder.matches(passwordActual, usuario.getPasswordHash())) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return Map.of("error", "Contraseña actual incorrecta");
        }

        usuario.setPasswordHash(passwordEncoder.encode(passwordNueva));
        usuarioRepository.save(usuario);
        return Map.of("ok", "Contraseña actualizada");
    }

    @DeleteMapping("/{id}")
    public Object eliminarCuenta(@PathVariable Long id,
            @RequestBody Map<String, String> body,
            HttpServletResponse response) {
        Usuario usuario = usuarioRepository.findById(id).orElse(null);

        String password = body.get("password");
        if (!passwordEncoder.matches(password, usuario.getPasswordHash())) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return Map.of("error", "Contraseña incorrecta");
        }

        usuarioRepository.deleteById(id);
        return Map.of("ok", "Cuenta eliminada");
    }
}