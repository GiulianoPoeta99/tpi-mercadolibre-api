package com.mercadolibre.api.metododepago;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;
import com.mercadolibre.api.usuario.*;

@Entity
@Table(name = "metodo_de_pago", schema = "public")
@Data
public class MetodoDePago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tarjeta")
    private long idTarjeta;

    @Column(name = "titular", nullable = false)
    private String titular;

    @Column(name = "numero_tarjeta", unique = true, nullable = false)
    private String numeroTarjeta;

    @Column(name = "clave_seguridad", nullable = false)
    private String claveSeguridad;

    @Column(name = "fecha_caducidad", nullable = false)
    private Date fechaCaducidad;

    @Column(name = "empresa_emisora", nullable = false)
    private String empresaEmisora;

    @Column(name = "tipo", nullable = false)
    private String tipo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario", nullable = false)
    private Usuario usuario;

    public MetodoDePago() {
    }

    public MetodoDePago(String titular, String numeroTarjeta, String claveSeguridad, Date fechaCaducidad,
            String empresaEmisora, String tipo, Usuario usuario) {
        this.titular = titular;
        this.numeroTarjeta = numeroTarjeta;
        this.claveSeguridad = claveSeguridad;
        this.fechaCaducidad = fechaCaducidad;
        this.empresaEmisora = empresaEmisora;
        this.tipo = tipo;
        this.usuario = usuario;
    }
}
