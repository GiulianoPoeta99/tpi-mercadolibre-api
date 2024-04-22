package com.mercadolibre.api.direccion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DireccionService {

    @Autowired
    private DireccionRepository direccionRepository;

    public List<Direccion> obtenerTodasLasDirecciones() {
        return direccionRepository.findAll();
    }

    public Optional<Direccion> obtenerDireccionPorId(Integer id) {
        return direccionRepository.findById(id);
    }

    public Direccion crearDireccion(Direccion direccion) {
        return direccionRepository.save(direccion);
    }

    public Direccion actualizarDireccion(Direccion direccion) {
        return direccionRepository.save(direccion);
    }

    public void eliminarDireccion(Integer id) {
        direccionRepository.deleteById(id);
    }
}
