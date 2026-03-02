package com.polizas.polizas_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.polizas.polizas_api.model.Riesgo;
import java.util.List;

public interface RiesgoRepository
        extends JpaRepository<Riesgo, Long> {

    List<Riesgo> findByPolizaId(Long polizaId);
}