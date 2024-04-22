package com.mercadolibre.api.pregunta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PreguntaService {

    @Autowired
    private PreguntaRepository preguntaRepository;

    public List<Pregunta> obtenerTodosLosPreguntas() {
        return preguntaRepository.findAll();
    }

    public Optional<Pregunta> obtenerPreguntaPorId(Integer id) {
        return preguntaRepository.findById(id);
    }

    public Pregunta crearPregunta(Pregunta pregunta) {
        return preguntaRepository.save(pregunta);
    }

    public Pregunta actualizarPregunta(Pregunta pregunta) {
        return preguntaRepository.save(pregunta);
    }

    public void eliminarPregunta(Integer id) {
        preguntaRepository.deleteById(id);
    }
}
