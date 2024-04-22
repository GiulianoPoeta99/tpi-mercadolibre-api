package com.mercadolibre.api.oferta;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "oferta", schema = "public")
@Data
public class Oferta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_oferta")
    private long idOferta;

    @Column(name = "porcentaje", nullable = false)
    private double porcentaje;

    @Column(name = "fecha_desde", nullable = false)
    private Date fechaDesde;

    @Column(name = "fecha_hasta", nullable = false)
    private Date fechaHasta;

    public Oferta() {
    }

    public Oferta(double porcentaje, Date fechaDesde, Date fechaHasta) {
        this.porcentaje = porcentaje;
        this.fechaDesde = fechaDesde;
        this.fechaHasta = fechaHasta;
    }
}
