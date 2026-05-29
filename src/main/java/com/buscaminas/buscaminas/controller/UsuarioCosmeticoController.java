package com.buscaminas.buscaminas.controller;

import com.buscaminas.buscaminas.dto.UsuarioCosmeticoDTO;
import com.buscaminas.buscaminas.model.Cosmetico;
import com.buscaminas.buscaminas.model.Usuario;
import com.buscaminas.buscaminas.model.UsuarioCosmetico;
import com.buscaminas.buscaminas.repository.CosmeticoRepository;
import com.buscaminas.buscaminas.repository.UsuarioCosmeticoRepository;
import com.buscaminas.buscaminas.repository.UsuarioRepository;
import com.buscaminas.buscaminas.util.CosmeticoConstants;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/usuario-cosmeticos")
public class UsuarioCosmeticoController {

    private final UsuarioCosmeticoRepository usuarioCosmeticoRepository;
    private final UsuarioRepository usuarioRepository;
    private final CosmeticoRepository cosmeticoRepository;

    public UsuarioCosmeticoController(UsuarioCosmeticoRepository usuarioCosmeticoRepository,
            UsuarioRepository usuarioRepository,
            CosmeticoRepository cosmeticoRepository) {
        this.usuarioCosmeticoRepository = usuarioCosmeticoRepository;
        this.usuarioRepository = usuarioRepository;
        this.cosmeticoRepository = cosmeticoRepository;
    }

    @GetMapping
    public List<UsuarioCosmeticoDTO> listar() {
        return usuarioCosmeticoRepository.findAll()
                .stream()
                .map(UsuarioCosmeticoDTO::new)
                .toList();
    }

    @GetMapping("/jugador/{id}")
    public List<UsuarioCosmeticoDTO> porJugador(@PathVariable Long id) {
        return usuarioCosmeticoRepository.findByJugadorId(id)
                .stream()
                .map(UsuarioCosmeticoDTO::new)
                .toList();
    }

    @PostMapping("/comprar")
    public Object comprar(@RequestBody Map<String, Long> body,
            HttpServletResponse response) {

        Long jugadorId = body.get("jugadorId");
        Long cosmeticoId = body.get("cosmeticoId");

        Usuario usuario = usuarioRepository.findById(jugadorId).orElse(null);
        Cosmetico cosmetico = cosmeticoRepository.findById(cosmeticoId).orElse(null);

        if (CosmeticoConstants.esClassic(cosmetico.getEstilo())) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return Map.of("error", "El tema Classic no se compra");
        }

        boolean yaComprado = usuarioCosmeticoRepository
                .findByJugadorId(jugadorId)
                .stream()
                .anyMatch(uc -> uc.getCosmetico().getId().equals(cosmeticoId));

        if (yaComprado) {
            response.setStatus(HttpServletResponse.SC_CONFLICT);
            return Map.of("error", "Ya tienes este cosmético");
        }

        if (usuario.getPuntosLogro() < cosmetico.getPrecioPuntos()) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return Map.of("error", "Puntos insuficientes");
        }

        // Descuenta puntos
        usuario.setPuntosLogro(usuario.getPuntosLogro() - cosmetico.getPrecioPuntos());
        usuarioRepository.save(usuario);

        // Crea el registro
        UsuarioCosmetico uc = new UsuarioCosmetico();
        uc.setJugador(usuario);
        uc.setCosmetico(cosmetico);
        uc.setEquipado(false);
        usuarioCosmeticoRepository.save(uc);

        return Map.of(
                "ok", "Cosmético comprado",
                "puntosLogro", usuario.getPuntosLogro());
    }

    @PutMapping("/equipar")
    public Object equipar(@RequestBody Map<String, Object> body,
            HttpServletResponse response) {

        Long jugadorId = toLong(body.get("jugadorId"));

        List<UsuarioCosmetico> todos = usuarioCosmeticoRepository.findByJugadorId(jugadorId);

        String estilo = body.get("estilo") != null ? body.get("estilo").toString() : null;
        if (CosmeticoConstants.esClassic(estilo)) {
            desequiparTodos(todos);
            return Map.of(
                    "ok", "Cosmético equipado",
                    "estilo", CosmeticoConstants.ESTILO_CLASSIC);
        }

        Long cosmeticoId = toLong(body.get("cosmeticoId"));
        if (cosmeticoId == null) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return Map.of("error", "cosmeticoId o estilo classic son obligatorios");
        }

        UsuarioCosmetico objetivo = todos.stream()
                .filter(uc -> uc.getCosmetico().getId().equals(cosmeticoId))
                .findFirst().orElse(null);

        if (objetivo == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return Map.of("error", "No tienes ese cosmético");
        }

        desequiparTodos(todos);
        objetivo.setEquipado(true);
        usuarioCosmeticoRepository.save(objetivo);

        return Map.of(
                "ok", "Cosmético equipado",
                "estilo", objetivo.getCosmetico().getEstilo());
    }

    private void desequiparTodos(List<UsuarioCosmetico> todos) {
        todos.forEach(uc -> uc.setEquipado(false));
        if (!todos.isEmpty()) {
            usuarioCosmeticoRepository.saveAll(todos);
        }
    }

    private static Long toLong(Object value) {
        if (value == null)
            return null;
        if (value instanceof Number n)
            return n.longValue();
        try {
            return Long.parseLong(value.toString());
        } catch (NumberFormatException e) {
            return null;
        }
    }
}