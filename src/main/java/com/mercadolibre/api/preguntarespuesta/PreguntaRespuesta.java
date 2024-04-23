package com.mercadolibre.api.preguntarespuesta;

import com.mercadolibre.api.pregunta.Pregunta;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "pregunta_respuesta", schema = "public")
@Data
public class PreguntaRespuesta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pregunta", nullable = false)
    private Pregunta pregunta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "respuesta", nullable = false)
    private Pregunta respuesta;

    public PreguntaRespuesta() {
    }

    public PreguntaRespuesta(Pregunta pregunta, Pregunta respuesta) {
        this.pregunta = pregunta;
        this.respuesta = respuesta;
    }
}
