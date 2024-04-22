package com.mercadolibre.api.resenia;

import com.mercadolibre.api.producto.Producto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "resenia", schema = "public")
@Data
public class Resenia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_resenia")
    private long idResenia;

    @Column(name = "resenia_producto", nullable = false, columnDefinition = "TEXT")
    private String reseniaProducto;

    @Column(name = "calificacion", nullable = false)
    private int calificacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "producto", nullable = false)
    private Producto producto;

    public Resenia() {
    }

    public Resenia(String reseniaProducto, int calificacion, Producto producto) {
        this.reseniaProducto = reseniaProducto;
        this.calificacion = calificacion;
        this.producto = producto;
    }
}
