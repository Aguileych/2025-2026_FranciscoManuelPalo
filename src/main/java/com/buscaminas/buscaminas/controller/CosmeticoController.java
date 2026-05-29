package com.buscaminas.buscaminas.controller;

import com.buscaminas.buscaminas.dto.CosmeticoDTO;
import com.buscaminas.buscaminas.repository.CosmeticoRepository;
import com.buscaminas.buscaminas.util.CosmeticoConstants;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/cosmeticos")
public class CosmeticoController {

    private final CosmeticoRepository cosmeticoRepository;

    public CosmeticoController(CosmeticoRepository cosmeticoRepository) {
        this.cosmeticoRepository = cosmeticoRepository;
    }

    @GetMapping
    public List<CosmeticoDTO> listar() {
        return cosmeticoRepository.findAll()
                .stream()
                .filter(c -> !CosmeticoConstants.esClassic(c.getEstilo()))
                .map(CosmeticoDTO::new)
                .toList();
    }

    @GetMapping("/estilo/{estilo}")
    public List<CosmeticoDTO> porEstilo(@PathVariable String estilo) {
        if (CosmeticoConstants.esClassic(estilo)) {
            return List.of();
        }
        return cosmeticoRepository.findByEstilo(estilo)
                .stream()
                .filter(c -> !CosmeticoConstants.esClassic(c.getEstilo()))
                .map(CosmeticoDTO::new)
                .toList();
    }
}