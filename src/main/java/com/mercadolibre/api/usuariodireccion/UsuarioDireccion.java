package com.mercadolibre.api.usuariodireccion;

import com.mercadolibre.api.usuario.Usuario;
import com.mercadolibre.api.direccion.Direccion;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "usuario_direccion", schema = "public")
@Data
public class UsuarioDireccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario", nullable = false)
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "direccion", nullable = false)
    private Direccion direccion;

    public UsuarioDireccion() {
    }

    public UsuarioDireccion(Usuario usuario, Direccion direccion) {
        this.usuario = usuario;
        this.direccion = direccion;
    }
}
