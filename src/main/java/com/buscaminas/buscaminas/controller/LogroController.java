package com.buscaminas.buscaminas.controller;

import com.buscaminas.buscaminas.dto.LogroDTO;
import com.buscaminas.buscaminas.repository.LogroRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/logros")
public class LogroController {

    private final LogroRepository logroRepository;

    public LogroController(LogroRepository logroRepository) {
        this.logroRepository = logroRepository;
    }

    @GetMapping
    public List<LogroDTO> listar() {
        return logroRepository.findAll()
                .stream()
                .map(LogroDTO::new)
                .toList();
    }
}