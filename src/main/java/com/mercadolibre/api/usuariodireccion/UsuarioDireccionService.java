package com.mercadolibre.api.usuariodireccion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioDireccionService {

    @Autowired
    private UsuarioDireccionRepository usuarioDireccionRepository;

    public List<UsuarioDireccion> obtenerTodosLosUsuariosDirecciones() {
        return usuarioDireccionRepository.findAll();
    }

    public Optional<UsuarioDireccion> obtenerUsuarioDireccionPorId(Integer id) {
        return usuarioDireccionRepository.findById(id);
    }

    public UsuarioDireccion crearUsuarioDireccion(UsuarioDireccion usuarioDireccion) {
        return usuarioDireccionRepository.save(usuarioDireccion);
    }

    public UsuarioDireccion actualizarUsuarioDireccion(UsuarioDireccion usuarioDireccion) {
        return usuarioDireccionRepository.save(usuarioDireccion);
    }

    public void eliminarUsuarioDireccion(Integer id) {
        usuarioDireccionRepository.deleteById(id);
    }
}
