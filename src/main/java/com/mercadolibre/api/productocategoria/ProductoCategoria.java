package com.mercadolibre.api.productocategoria;

import com.mercadolibre.api.producto.Producto;
import com.mercadolibre.api.categoria.Categoria;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "producto_categoria", schema = "public")
@Data
public class ProductoCategoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "producto", nullable = false)
    private Producto producto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoria", nullable = false)
    private Categoria categoria;

    public ProductoCategoria() {
    }

    public ProductoCategoria(Producto producto, Categoria categoria) {
        this.producto = producto;
        this.categoria = categoria;
    }
}
