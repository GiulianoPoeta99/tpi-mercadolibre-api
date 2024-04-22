package com.mercadolibre.api.categoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository productoRepository;

    public List<Categoria> obtenerTodasLasCategorias() {
        return productoRepository.findAll();
    }

    public Optional<Categoria> obtenerCategoriaPorId(Integer id) {
        return productoRepository.findById(id);
    }

    public Categoria crearCategoria(Categoria usuario) {
        return productoRepository.save(usuario);
    }

    public Categoria actualizarCategoria(Categoria usuario) {
        return productoRepository.save(usuario);
    }

    public void eliminarCategoria(Integer id) {
        productoRepository.deleteById(id);
    }
}
