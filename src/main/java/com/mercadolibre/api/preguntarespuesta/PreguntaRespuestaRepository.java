package com.mercadolibre.api.preguntarespuesta;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
// import com.mercadolibre.api.usuario.Usuario;

@Repository
public interface PreguntaRespuestaRepository extends JpaRepository<PreguntaRespuesta, Integer> {
    // Aquí puedes agregar métodos adicionales si necesitas realizar consultas
    // personalizadas
}
