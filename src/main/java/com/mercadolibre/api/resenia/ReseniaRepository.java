package com.mercadolibre.api.resenia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
// import com.mercadolibre.api.usuario.Usuario;

@Repository
public interface ReseniaRepository extends JpaRepository<Resenia, Integer> {
    // Aquí puedes agregar métodos adicionales si necesitas realizar consultas
    // personalizadas
}
