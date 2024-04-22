package com.mercadolibre.api.item;

import com.mercadolibre.api.usuario.Usuario;
import com.mercadolibre.api.producto.Producto;
import com.mercadolibre.api.direccion.Direccion;
import com.mercadolibre.api.pedido.Pedido;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "item", schema = "public")
@Data
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_item")
    private long idItem;

    @Column(name = "cantidad", nullable = false)
    private int cantidad;

    @Column(name = "estado", nullable = false)
    private String estado;

    @Column(name = "tipo_entrega", nullable = false)
    private String tipoEntrega;

    @Column(name = "envio_domicilio", nullable = false)
    private boolean envioDomicilio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario", nullable = false)
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "producto", nullable = false)
    private Producto producto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "direccion", nullable = false)
    private Direccion direccion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pedido", nullable = false)
    private Pedido pedido;

    public Item() {
    }

    public Item(int cantidad, String estado, String tipoEntrega, boolean envioDomicilio, Usuario usuario,
            Producto producto, Direccion direccion, Pedido pedido) {
        this.cantidad = cantidad;
        this.estado = estado;
        this.tipoEntrega = tipoEntrega;
        this.envioDomicilio = envioDomicilio;
        this.usuario = usuario;
        this.producto = producto;
        this.direccion = direccion;
        this.pedido = pedido;
    }
}
