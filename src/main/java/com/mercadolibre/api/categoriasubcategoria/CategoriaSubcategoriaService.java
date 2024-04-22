package com.mercadolibre.api.categoriasubcategoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CategoriaSubcategoriaService {

    @Autowired
    private CategoriaSubcategoriaRepository categoriaSubcategoriaRepository;

    public List<CategoriaSubcategoria> obtenerTodosLosCategoriaSubcategorias() {
        return categoriaSubcategoriaRepository.findAll();
    }

    public Optional<CategoriaSubcategoria> obtenerCategoriaSubcategoriaPorId(Integer id) {
        return categoriaSubcategoriaRepository.findById(id);
    }

    public CategoriaSubcategoria crearCategoriaSubcategoria(CategoriaSubcategoria categoriaSubcategoria) {
        return categoriaSubcategoriaRepository.save(categoriaSubcategoria);
    }

    public CategoriaSubcategoria actualizarCategoriaSubcategoria(CategoriaSubcategoria categoriaSubcategoria) {
        return categoriaSubcategoriaRepository.save(categoriaSubcategoria);
    }

    public void eliminarCategoriaSubcategoria(Integer id) {
        categoriaSubcategoriaRepository.deleteById(id);
    }
}
