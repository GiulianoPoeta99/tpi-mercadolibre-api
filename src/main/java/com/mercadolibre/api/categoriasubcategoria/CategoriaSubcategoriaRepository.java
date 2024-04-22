package com.mercadolibre.api.categoriasubcategoria;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
// import com.mercadolibre.api.usuario.Usuario;

@Repository
public interface CategoriaSubcategoriaRepository extends JpaRepository<CategoriaSubcategoria, Integer> {
    // Aquí puedes agregar métodos adicionales si necesitas realizar consultas
    // personalizadas
}
