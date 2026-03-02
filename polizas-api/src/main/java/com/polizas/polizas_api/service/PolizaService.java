package com.polizas.polizas_api.service;

import com.polizas.polizas_api.model.Poliza;
import com.polizas.polizas_api.repository.PolizaRepository;
import org.springframework.stereotype.Service;
import com.polizas.polizas_api.adapter.CoreAdapter;

import java.util.List;

@Service
public class PolizaService {

    private final PolizaRepository repository;
    private final CoreAdapter coreAdapter;

    private static final double IPC = 0.10; 

    public PolizaService(PolizaRepository repository,
                     CoreAdapter coreAdapter) {
    this.repository = repository;
    this.coreAdapter = coreAdapter;
    }   

    public List<Poliza> listar(String estado, String tipo) {
    return repository.findAll();
    }

    public Poliza renovar(Long id) {

        Poliza poliza = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Poliza no encontrada"));

        // ✅ Regla 1
        if ("CANCELADA".equals(poliza.getEstado())) {
            throw new RuntimeException("No se puede renovar una póliza cancelada");
        }

        // ✅ Incremento IPC
        double nuevoCanon = poliza.getCanon() * (1 + IPC);
        double nuevaPrima = poliza.getPrima() * (1 + IPC);

        poliza.setCanon(nuevoCanon);
        poliza.setPrima(nuevaPrima);
        poliza.setEstado("RENOVADA");

        // Guardar cambios en DB
        poliza = repository.save(poliza);

        // Notificar CORE (AQUÍ VA)
        coreAdapter.enviarEvento("ACTUALIZACION", poliza.getId());

        // Respuesta
        return poliza;
    }
}
