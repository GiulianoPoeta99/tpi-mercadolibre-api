package com.mercadolibre.api.ofertaproducto;

import com.mercadolibre.api.oferta.Oferta;
import com.mercadolibre.api.producto.Producto;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "oferta_producto", schema = "public")
@Data
public class OfertaProducto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "oferta", nullable = false)
    private Oferta oferta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "producto", nullable = false)
    private Producto producto;

    public OfertaProducto() {
    }

    public OfertaProducto(Oferta oferta, Producto producto) {
        this.oferta = oferta;
        this.producto = producto;
    }
}
