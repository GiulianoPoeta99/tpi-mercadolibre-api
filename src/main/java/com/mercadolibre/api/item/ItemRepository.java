package com.mercadolibre.api.item;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
// import com.mercadolibre.api.usuario.Usuario;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {
    // Aquí puedes agregar métodos adicionales si necesitas realizar consultas
    // personalizadas
}
