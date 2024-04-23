package com.mercadolibre.api.imagen;

import com.mercadolibre.api.producto.Producto;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "imagen", schema = "public")
@Data
public class Imagen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "producto", nullable = false)
    private Producto producto;

    @Column(name = "imagen", nullable = false)
    private String imagen;

    public Imagen() {
    }

    public Imagen(Producto producto, String imagen) {
        this.producto = producto;
        this.imagen = imagen;
    }
}
