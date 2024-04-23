package com.mercadolibre.api.usuariodireccion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
// import com.mercadolibre.api.usuario.Usuario;

@Repository
public interface UsuarioDireccionRepository extends JpaRepository<UsuarioDireccion, Integer> {
    // Aquí puedes agregar métodos adicionales si necesitas realizar consultas
    // personalizadas
}
