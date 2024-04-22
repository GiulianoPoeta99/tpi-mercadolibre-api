package com.mercadolibre.api.direccion;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "direccion", schema = "public")
@Data
public class Direccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_direccion")
    private long idDireccion;

    @Column(name = "codigo_postal", nullable = false)
    private String codigoPostal;

    @Column(name = "calle", nullable = false)
    private String calle;

    @Column(name = "altura", nullable = false)
    private int altura;

    public Direccion() {
    }

    public Direccion(String codigoPostal, String calle, int altura) {
        this.codigoPostal = codigoPostal;
        this.calle = calle;
        this.altura = altura;
    }
}
