package com.mercadolibre.api.preguntarespuesta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PreguntaRespuestaService {

    @Autowired
    private PreguntaRespuestaRepository preguntaRespuestaRepository;

    public List<PreguntaRespuesta> obtenerTodosLosPreguntaRespuestas() {
        return preguntaRespuestaRepository.findAll();
    }

    public Optional<PreguntaRespuesta> obtenerPreguntaRespuestaPorId(Integer id) {
        return preguntaRespuestaRepository.findById(id);
    }

    public PreguntaRespuesta crearPreguntaRespuesta(PreguntaRespuesta preguntaRespuesta) {
        return preguntaRespuestaRepository.save(preguntaRespuesta);
    }

    public PreguntaRespuesta actualizarPreguntaRespuesta(PreguntaRespuesta preguntaRespuesta) {
        return preguntaRespuestaRepository.save(preguntaRespuesta);
    }

    public void eliminarPreguntaRespuesta(Integer id) {
        preguntaRespuestaRepository.deleteById(id);
    }
}
