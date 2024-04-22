package com.mercadolibre.api.pregunta;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "pregunta", schema = "public")
@Data
public class Pregunta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pregunta")
    private long idPregunta;

    @Column(name = "preguntas_del_producto", nullable = false, columnDefinition = "TEXT")
    private String preguntasDelProducto;

    @Column(name = "fecha_de_la_pregunta", nullable = false)
    private Date fechaDeLaPregunta;

    public Pregunta() {
    }

    public Pregunta(String preguntasDelProducto, Date fechaDeLaPregunta) {
        this.preguntasDelProducto = preguntasDelProducto;
        this.fechaDeLaPregunta = fechaDeLaPregunta;
    }
}
