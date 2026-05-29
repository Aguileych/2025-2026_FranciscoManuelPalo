package com.buscaminas.buscaminas.controller;

import com.buscaminas.buscaminas.dto.UsuarioLogroDTO;
import com.buscaminas.buscaminas.model.Logro;
import com.buscaminas.buscaminas.model.Usuario;
import com.buscaminas.buscaminas.model.UsuarioLogro;
import com.buscaminas.buscaminas.repository.LogroRepository;
import com.buscaminas.buscaminas.repository.UsuarioLogroRepository;
import com.buscaminas.buscaminas.repository.UsuarioRepository;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/usuario-logros")
public class UsuarioLogroController {

    private final UsuarioLogroRepository usuarioLogroRepository;
    private final UsuarioRepository usuarioRepository;
    private final LogroRepository logroRepository;

    public UsuarioLogroController(UsuarioLogroRepository usuarioLogroRepository,
            UsuarioRepository usuarioRepository,
            LogroRepository logroRepository) {
        this.usuarioLogroRepository = usuarioLogroRepository;
        this.usuarioRepository = usuarioRepository;
        this.logroRepository = logroRepository;
    }

    @GetMapping
    public List<UsuarioLogroDTO> listar() {
        return usuarioLogroRepository.findAll()
                .stream()
                .map(UsuarioLogroDTO::new)
                .toList();
    }

    @GetMapping("/jugador/{id}")
    public List<UsuarioLogroDTO> porJugador(@PathVariable Long id) {
        return usuarioLogroRepository.findByJugadorId(id)
                .stream()
                .map(UsuarioLogroDTO::new)
                .toList();
    }

    /**
     * Registra un logro obtenido (fila en usuario_logros) y suma puntos.
     */
    @PostMapping
    public Object crear(@RequestBody Map<String, Object> body,
            HttpServletResponse response) {

        Long jugadorId = toLong(body.get("jugadorId"));
        Long logroId = toLong(body.get("logroId"));

        return registrarLogroObtenido(jugadorId, logroId, response);
    }

    /**
     * Registra el logro si el jugador aún no lo tiene en usuario_logros.
     * Body JSON: { "jugadorId": 1, "logroId": 2 }
     */
    @PostMapping("/obtener")
    public Object obtener(@RequestBody Map<String, Long> body,
            HttpServletResponse response) {

        Long jugadorId = body.get("jugadorId");
        Long logroId = body.get("logroId");

        if (jugadorId == null || logroId == null) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return Map.of("error", "jugadorId y logroId son obligatorios");
        }

        return registrarLogroObtenido(jugadorId, logroId, response);
    }

    private Object registrarLogroObtenido(Long jugadorId, Long logroId,
            HttpServletResponse response) {

        Usuario usuario = usuarioRepository.findById(jugadorId).orElse(null);
        Logro logro = logroRepository.findById(logroId).orElse(null);

        if (usuarioLogroRepository.existsByJugadorIdAndLogroId(jugadorId, logroId)) {
            response.setStatus(HttpServletResponse.SC_CONFLICT);
            return Map.of("error", "Logro ya obtenido");
        }

        UsuarioLogro ul = new UsuarioLogro();
        ul.setJugador(usuario);
        ul.setLogro(logro);
        usuarioLogroRepository.save(ul);

        usuario.setPuntosLogro(usuario.getPuntosLogro() + logro.getPuntos());
        usuarioRepository.save(usuario);

        return Map.of(
                "ok", "Logro obtenido",
                "logro", new UsuarioLogroDTO(ul),
                "puntosLogro", usuario.getPuntosLogro());
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
