package com.mercadolibre.api.pedido;

import com.mercadolibre.api.metododepago.MetodoDePago;
import com.mercadolibre.api.usuario.Usuario;
import com.mercadolibre.api.resenia.Resenia;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "pedido", schema = "public")
@Data
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numero_de_pedido")
    private long numeroDePedido;

    @Column(name = "fecha_pedido", nullable = false)
    private Date fechaPedido;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "metodo_pago", nullable = false)
    private MetodoDePago metodoPago;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "particular", nullable = false)
    private Usuario particular;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "resenia", nullable = false)
    private Resenia resenia;

    public Pedido() {
    }

    public Pedido(Date fechaPedido, MetodoDePago metodoPago, Usuario particular, Resenia resenia) {
        this.fechaPedido = fechaPedido;
        this.metodoPago = metodoPago;
        this.particular = particular;
        this.resenia = resenia;
    }
}
