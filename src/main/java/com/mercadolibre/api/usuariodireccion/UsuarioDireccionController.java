package com.mercadolibre.api.usuariodireccion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios-direcciones")
@Tag(name = "Usuario Direcciones", description = "Operaciones relacionadas al usuarioDireccion.")
public class UsuarioDireccionController {

    @Autowired
    private UsuarioDireccionService usuarioDireccionService;

    @GetMapping
    @Operation(summary = "Obtener todas las usuarioDireccions.")
    public ResponseEntity<List<UsuarioDireccion>> obtenerTodosLosUsuariosDirecciones() {
        List<UsuarioDireccion> usuarioDireccions = usuarioDireccionService.obtenerTodosLosUsuariosDirecciones();
        return ResponseEntity.ok(usuarioDireccions);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener usuarioDireccion con ID usuarioDireccion.")
    public ResponseEntity<UsuarioDireccion> obtenerUsuarioDireccionPorId(@PathVariable Integer id) {
        Optional<UsuarioDireccion> usuarioDireccion = usuarioDireccionService.obtenerUsuarioDireccionPorId(id);
        return usuarioDireccion.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Crear usuarioDireccion.")
    public ResponseEntity<UsuarioDireccion> crearUsuarioDireccion(@RequestBody UsuarioDireccion usuarioDireccion) {
        UsuarioDireccion nuevoUsuarioDireccion = usuarioDireccionService.crearUsuarioDireccion(usuarioDireccion);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoUsuarioDireccion);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar usuarioDireccion con ID usuarioDireccion.")
    public ResponseEntity<UsuarioDireccion> actualizarUsuarioDireccion(@PathVariable Integer id,
            @RequestBody UsuarioDireccion usuarioDireccionActualizado) {
        UsuarioDireccion usuarioDireccion = usuarioDireccionService.obtenerUsuarioDireccionPorId(id)
                .orElse(null);

        if (usuarioDireccion == null) {
            return ResponseEntity.notFound().build();
        }

        usuarioDireccionActualizado.setId(usuarioDireccion.getId());
        UsuarioDireccion usuarioDireccionActualizadoGuardado = usuarioDireccionService
                .actualizarUsuarioDireccion(usuarioDireccionActualizado);
        return ResponseEntity.ok(usuarioDireccionActualizadoGuardado);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar usuarioDireccion con ID usuarioDireccion.")
    public ResponseEntity<Void> eliminarUsuarioDireccion(@PathVariable Integer id) {
        usuarioDireccionService.eliminarUsuarioDireccion(id);
        return ResponseEntity.noContent().build();
    }
}
