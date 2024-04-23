package com.mercadolibre.api.preguntaproductousuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PreguntaProductoUsuarioService {

    @Autowired
    private PreguntaProductoUsuarioRepository preguntaRepository;

    public List<PreguntaProductoUsuario> obtenerTodosLosPreguntasProductosUsuarios() {
        return preguntaRepository.findAll();
    }

    public Optional<PreguntaProductoUsuario> obtenerPreguntaProductoUsuarioPorId(Integer id) {
        return preguntaRepository.findById(id);
    }

    public PreguntaProductoUsuario crearPreguntaProductoUsuario(PreguntaProductoUsuario pregunta) {
        return preguntaRepository.save(pregunta);
    }

    public PreguntaProductoUsuario actualizarPreguntaProductoUsuario(PreguntaProductoUsuario pregunta) {
        return preguntaRepository.save(pregunta);
    }

    public void eliminarPreguntaProductoUsuario(Integer id) {
        preguntaRepository.deleteById(id);
    }
}
