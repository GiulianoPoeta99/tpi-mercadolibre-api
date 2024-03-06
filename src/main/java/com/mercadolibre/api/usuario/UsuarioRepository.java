package com.mercadolibre.api.usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
// import com.mercadolibre.api.usuario.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    // Aquí puedes agregar métodos adicionales si necesitas realizar consultas
    // personalizadas
}
