package com.polizas.polizas_api.adapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class CoreAdapter {

    private static final Logger log =
            LoggerFactory.getLogger(CoreAdapter.class);

    public void enviarEvento(String evento, Long polizaId) {

        // Simulación integración CORE
        log.info("Evento enviado al CORE -> {} | polizaId={}",
                evento, polizaId);
    }
}