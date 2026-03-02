package com.polizas.polizas_api.controller;

import com.polizas.polizas_api.model.Poliza;
import com.polizas.polizas_api.service.PolizaService;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/polizas")
public class PolizaController {

    private final PolizaService service;

    public PolizaController(PolizaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Poliza> listar(
            @RequestParam String tipo,
            @RequestParam String estado) {

        return service.listar(tipo, estado);
    }

    @PostMapping("/{id}/renovar")
    public Poliza renovar(@PathVariable Long id) {
    return service.renovar(id);
    }

}
