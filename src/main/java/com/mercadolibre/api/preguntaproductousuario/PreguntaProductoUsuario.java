package com.mercadolibre.api.preguntaproductousuario;

import com.mercadolibre.api.pregunta.Pregunta;
import com.mercadolibre.api.producto.Producto;
import com.mercadolibre.api.usuario.Usuario;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "pregunta_producto_usuario", schema = "public")
@Data
public class PreguntaProductoUsuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pregunta", nullable = false)
    private Pregunta pregunta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "producto", nullable = false)
    private Producto producto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario", nullable = false)
    private Usuario usuario;

    public PreguntaProductoUsuario() {
    }

    public PreguntaProductoUsuario(Pregunta pregunta, Producto producto, Usuario usuario) {
        this.pregunta = pregunta;
        this.producto = producto;
        this.usuario = usuario;
    }
}
