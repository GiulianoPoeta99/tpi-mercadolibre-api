package com.mercadolibre.api.usuario;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "usuario", schema = "public")
@Data
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numero_cliente")
    private Integer numeroCliente;

    @Column(name = "correo_electronico", unique = true, nullable = false)
    private String correoElectronico;

    @Column(name = "telefono", unique = true, nullable = false)
    private String telefono;

    @Column(name = "contrasenia", nullable = false)
    private String contrasenia;

    public Usuario() {
    }

    public Usuario(Integer numeroCliente, String correoElectronico, String telefono, String contrasenia) {
        this.numeroCliente = numeroCliente;
        this.correoElectronico = correoElectronico;
        this.telefono = telefono;
        this.contrasenia = contrasenia;
    }
}