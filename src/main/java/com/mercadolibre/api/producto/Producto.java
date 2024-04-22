package com.mercadolibre.api.producto;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "producto", schema = "public")
@Data
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numero_articulo")
    private long numeroArticulo;

    @Column(name = "es_nuevo", nullable = false)
    private boolean esNuevo;

    @Column(name = "precio_unitario", nullable = false)
    private double precioUnitario;

    @Column(name = "detalle")
    private String detalle;

    @Column(name = "descripcion_producto", columnDefinition = "TEXT")
    private String descripcionProducto;

    @Column(name = "nombre_producto", nullable = false)
    private String nombreProducto;

    @Column(name = "stock", nullable = false)
    private int stock;

    @Column(name = "calificacion", nullable = false)
    private int calificacion;

    public Producto() {
    }

    public Producto(boolean esNuevo, double precioUnitario, String detalle, String descripcionProducto,
            String nombreProducto, int stock, int calificacion) {
        this.esNuevo = esNuevo;
        this.precioUnitario = precioUnitario;
        this.detalle = detalle;
        this.descripcionProducto = descripcionProducto;
        this.nombreProducto = nombreProducto;
        this.stock = stock;
        this.calificacion = calificacion;
    }
}
