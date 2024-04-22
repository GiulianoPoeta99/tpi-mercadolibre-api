package com.mercadolibre.api.oferta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class OfertaService {

    @Autowired
    private OfertaRepository productoRepository;

    public List<Oferta> obtenerTodosLosOfertas() {
        return productoRepository.findAll();
    }

    public Optional<Oferta> obtenerOfertaPorId(Integer id) {
        return productoRepository.findById(id);
    }

    public Oferta crearOferta(Oferta usuario) {
        return productoRepository.save(usuario);
    }

    public Oferta actualizarOferta(Oferta usuario) {
        return productoRepository.save(usuario);
    }

    public void eliminarOferta(Integer id) {
        productoRepository.deleteById(id);
    }
}
