package com.mercadolibre.api.producto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> obtenerTodosLosProductos() {
        return productoRepository.findAll();
    }

    public Optional<Producto> obtenerProductoPorId(Integer id) {
        return productoRepository.findById(id);
    }

    public Producto crearProducto(Producto usuario) {
        return productoRepository.save(usuario);
    }

    public Producto actualizarProducto(Producto usuario) {
        return productoRepository.save(usuario);
    }

    public void eliminarProducto(Integer id) {
        productoRepository.deleteById(id);
    }
}
