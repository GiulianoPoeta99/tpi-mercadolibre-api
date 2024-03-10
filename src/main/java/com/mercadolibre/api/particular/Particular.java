package com.mercadolibre.api.particular;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name = "particular")
@Data
public class Particular {
    @Id
    @Column(name = "usuario")
    private long usuario;

    @Column(name = "DNI", unique = true, nullable = false)
    private String dni;

    @Column(name = "fecha_nacimiento", nullable = false)
    private Date fechaNacimiento;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "apellido", nullable = false)
    private String apellido;

    public Particular() {
    }

    public Particular(long usuario, String dni, Date fechaNacimiento, String nombre, String apellido) {
        this.usuario = usuario;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
        this.nombre = nombre;
        this.nombre = apellido;
    }
}
