package com.mercadolibre.api.empresa;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name = "empresa")
@Data
public class Empresa {
    @Id
    @Column(name = "usuario")
    private Integer usuario;

    @Column(name = "cuit", unique = true, nullable = false)
    private String cuit;

    @Column(name = "nombre_fantasia", unique = true, nullable = false)
    private String nombreFantasia;

    @Column(name = "fecha_creacion", nullable = false)
    private Date fechaCreacion;

    public Empresa() {
    }

    public Empresa(Integer usuario, String cuit, String nombreFantasia, Date fechaCreacion) {
        this.usuario = usuario;
        this.cuit = cuit;
        this.nombreFantasia = nombreFantasia;
        this.fechaCreacion = fechaCreacion;
    }
}
