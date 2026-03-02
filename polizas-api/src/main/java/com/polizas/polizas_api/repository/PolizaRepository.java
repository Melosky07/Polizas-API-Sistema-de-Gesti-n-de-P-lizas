package com.polizas.polizas_api.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.polizas.polizas_api.model.Poliza;
import java.util.List;

public interface PolizaRepository
        extends JpaRepository<Poliza, Long> {

    List<Poliza> findByTipoAndEstado(String tipo, String estado);
}
