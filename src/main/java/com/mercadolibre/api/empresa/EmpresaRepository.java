package com.mercadolibre.api.empresa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
// import com.mercadolibre.api.usuario.Usuario;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Integer> {
    // Aquí puedes agregar métodos adicionales si necesitas realizar consultas
    // personalizadas
}
