package com.mercadolibre.api.productocategoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoCategoriaService {

    @Autowired
    private ProductoCategoriaRepository productoCategoriaRepository;

    public List<ProductoCategoria> obtenerTodosLosProductosCategorias() {
        return productoCategoriaRepository.findAll();
    }

    public Optional<ProductoCategoria> obtenerProductoCategoriaPorId(Integer id) {
        return productoCategoriaRepository.findById(id);
    }

    public ProductoCategoria crearProductoCategoria(ProductoCategoria productoCategoria) {
        return productoCategoriaRepository.save(productoCategoria);
    }

    public ProductoCategoria actualizarProductoCategoria(ProductoCategoria productoCategoria) {
        return productoCategoriaRepository.save(productoCategoria);
    }

    public void eliminarProductoCategoria(Integer id) {
        productoCategoriaRepository.deleteById(id);
    }
}
