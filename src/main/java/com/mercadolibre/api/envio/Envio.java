package com.mercadolibre.api.envio;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "envio", schema = "public")
@Data
public class Envio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_envio")
    private long idEnvio;

    @Column(name = "tipo_envio", nullable = false)
    private String tipoEnvio;

    public Envio() {
    }

    public Envio(String tipoEnvio) {
        this.tipoEnvio = tipoEnvio;
    }
}
