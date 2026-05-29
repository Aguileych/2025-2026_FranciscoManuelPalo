package com.buscaminas.buscaminas.controller;

import com.buscaminas.buscaminas.dto.UsuarioDTO;
import com.buscaminas.buscaminas.model.Usuario;
import com.buscaminas.buscaminas.repository.UsuarioRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthController(UsuarioRepository usuarioRepository,
                          PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder   = passwordEncoder;
    }

    @PostMapping("/login")
    public Object login(@RequestBody Map<String, String> body,
                        HttpServletResponse response) {
        String email    = body.get("email");
        String password = body.get("password");

        Usuario usuario = usuarioRepository.findByEmail(email);

        if (usuario == null || !passwordEncoder.matches(password, usuario.getPasswordHash())) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return Map.of("error", "registro.incorrecto");
        }

        return new UsuarioDTO(usuario);
    }

    @PostMapping("/registro")
    public Object registro(@RequestBody Map<String, String> body,
                           HttpServletResponse response) {
        String email    = body.get("email");
        String username = body.get("username");
        String password = body.get("password");

        if (usuarioRepository.findByEmail(email) != null) {
            response.setStatus(HttpServletResponse.SC_CONFLICT);
            return Map.of("error", "registro.registrado");
        }

        Usuario nuevo = new Usuario();
        nuevo.setEmail(email);
        nuevo.setUsername(username);
        nuevo.setPasswordHash(passwordEncoder.encode(password));
        nuevo.setPuntosLogro(0);
        nuevo.setCreatedAt(java.time.LocalDateTime.now());
        nuevo.setUltimoAcceso(java.time.LocalDateTime.now());

        usuarioRepository.save(nuevo);

        return new UsuarioDTO(nuevo);
    }


    // Para datos de prueba
    @GetMapping("/hash")
    public String hash(@RequestParam String password) {
        return passwordEncoder.encode(password);
    }
}