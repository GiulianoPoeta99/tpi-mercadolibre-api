package com.mercadolibre.api.preguntaproductousuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
// import com.mercadolibre.api.usuario.Usuario;

@Repository
public interface PreguntaProductoUsuarioRepository extends JpaRepository<PreguntaProductoUsuario, Integer> {
    // Aquí puedes agregar métodos adicionales si necesitas realizar consultas
    // personalizadas
}
