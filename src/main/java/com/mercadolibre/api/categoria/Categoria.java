package com.mercadolibre.api.categoria;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "categoria", schema = "public")
@Data
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private long idCategoria;

    @Column(name = "nombre", nullable = false, unique = true)
    private String nombre;

    public Categoria() {
    }

    public Categoria(String nombre) {
        this.nombre = nombre;
    }
}
