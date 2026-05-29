package com.buscaminas.buscaminas.controller;

import com.buscaminas.buscaminas.dto.PartidaDTO;
import com.buscaminas.buscaminas.model.Partida;
import com.buscaminas.buscaminas.model.Partida.Dificultad;
import com.buscaminas.buscaminas.model.Usuario;
import com.buscaminas.buscaminas.repository.PartidaRepository;
import com.buscaminas.buscaminas.repository.UsuarioRepository;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/partidas")
public class PartidaController {

    private final PartidaRepository partidaRepository;
    private final UsuarioRepository usuarioRepository;

    public PartidaController(PartidaRepository partidaRepository,
                              UsuarioRepository usuarioRepository) {
        this.partidaRepository = partidaRepository;
        this.usuarioRepository = usuarioRepository;
    }

    /**
     * Registra una partida terminada.
     * Body JSON: { "jugadorId": 1, "dificultad": "FACIL", "tiempo": 120,
     *              "numeroMinas": 10, "minasRestantes": 0 }
     * minasRestantes = 0 indica victoria; &gt; 0 indica derrota.
     */
    @PostMapping
    public Object crear(@RequestBody Map<String, Object> body,
                        HttpServletResponse response) {

        Long jugadorId = toLong(body.get("jugadorId"));
        Dificultad dificultad = parseDificultad(body.get("dificultad"));
        Integer tiempo = toInt(body.get("tiempo"));
        Integer numeroMinas = toInt(body.get("numeroMinas"));
        Integer minasRestantes = toInt(body.get("minasRestantes"));

        Usuario jugador = usuarioRepository.findById(jugadorId).orElse(null);
        if (jugador == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return Map.of("error", "Usuario no encontrado");
        }

        Partida partida = new Partida();
        partida.setJugador(jugador);
        partida.setDificultad(dificultad);
        partida.setTiempo(tiempo);
        partida.setNumeroMinas(numeroMinas);
        partida.setMinasRestantes(minasRestantes);

        Partida guardada = partidaRepository.guardarNuevaPartida(partida);
        return new PartidaDTO(guardada);
    }

    @GetMapping
    public List<PartidaDTO> listar() {
        return partidaRepository.findAll()
                .stream()
                .map(PartidaDTO::new)
                .toList();
    }

    @GetMapping("/jugador/{id}")
    public List<PartidaDTO> porJugador(@PathVariable Long id) {
        return partidaRepository.findByJugadorId(id)
                .stream()
                .map(PartidaDTO::new)
                .toList();
    }

    @GetMapping("/jugador/{id}/historial")
public List<PartidaDTO> historialJugador(@PathVariable Long id) {
    return partidaRepository.findByJugadorIdOrderByIdDesc(id)
            .stream()
            .map(PartidaDTO::new)
            .toList();
}

    @GetMapping("/dificultad/facil")
    public List<PartidaDTO> porDificultadFacil() {
        return partidaRepository
                .findTop10ByDificultadAndMinasRestantesEqualsOrderByTiempo(Dificultad.FACIL, 0)
                .stream()
                .map(PartidaDTO::new)
                .toList();
    }

    @GetMapping("/dificultad/normal")
    public List<PartidaDTO> porDificultadNormal() {
        return partidaRepository
                .findTop10ByDificultadAndMinasRestantesEqualsOrderByTiempo(Dificultad.NORMAL, 0)
                .stream()
                .map(PartidaDTO::new)
                .toList();
    }

    @GetMapping("/dificultad/dificil")
    public List<PartidaDTO> porDificultadDificil() {
        return partidaRepository
                .findTop10ByDificultadAndMinasRestantesEqualsOrderByTiempo(Dificultad.DIFICIL, 0)
                .stream()
                .map(PartidaDTO::new)
                .toList();
    }

    private static Dificultad parseDificultad(Object value) {
        if (value == null) return null;
        return switch (value.toString().trim().toUpperCase()) {
            case "FACIL", "EASY", "D1" -> Dificultad.FACIL;
            case "NORMAL", "D2" -> Dificultad.NORMAL;
            case "DIFICIL", "HARD", "D3" -> Dificultad.DIFICIL;
            default -> null;
        };
    }

    private static Long toLong(Object value) {
        if (value == null) return null;
        if (value instanceof Number n) return n.longValue();
        try {
            return Long.parseLong(value.toString());
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private static Integer toInt(Object value) {
        if (value == null) return null;
        if (value instanceof Number n) return n.intValue();
        try {
            return Integer.parseInt(value.toString());
        } catch (NumberFormatException e) {
            return null;
        }
    }
}