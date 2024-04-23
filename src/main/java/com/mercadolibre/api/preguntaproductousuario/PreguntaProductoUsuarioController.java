package com.mercadolibre.api.preguntaproductousuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/preguntas-productos-usuarios")
@Tag(name = "Pregunta Producto Usuario", description = "Operaciones relacionadas al preguntaProductoUsuario.")
public class PreguntaProductoUsuarioController {

    @Autowired
    private PreguntaProductoUsuarioService preguntaProductoUsuarioService;

    @GetMapping
    @Operation(summary = "Obtener todas las preguntaProductoUsuarios.")
    public ResponseEntity<List<PreguntaProductoUsuario>> obtenerTodosLosPreguntaProductoUsuarios() {
        List<PreguntaProductoUsuario> preguntaProductoUsuarios = preguntaProductoUsuarioService
                .obtenerTodosLosPreguntasProductosUsuarios();
        return ResponseEntity.ok(preguntaProductoUsuarios);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener preguntaProductoUsuario con ID preguntaProductoUsuario.")
    public ResponseEntity<PreguntaProductoUsuario> obtenerPreguntaProductoUsuarioPorId(@PathVariable Integer id) {
        Optional<PreguntaProductoUsuario> preguntaProductoUsuario = preguntaProductoUsuarioService
                .obtenerPreguntaProductoUsuarioPorId(id);
        return preguntaProductoUsuario.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Crear preguntaProductoUsuario.")
    public ResponseEntity<PreguntaProductoUsuario> crearPreguntaProductoUsuario(
            @RequestBody PreguntaProductoUsuario preguntaProductoUsuario) {
        PreguntaProductoUsuario nuevoPreguntaProductoUsuario = preguntaProductoUsuarioService
                .crearPreguntaProductoUsuario(preguntaProductoUsuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoPreguntaProductoUsuario);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar preguntaProductoUsuario con ID preguntaProductoUsuario.")
    public ResponseEntity<PreguntaProductoUsuario> actualizarPreguntaProductoUsuario(@PathVariable Integer id,
            @RequestBody PreguntaProductoUsuario preguntaProductoUsuarioActualizado) {
        PreguntaProductoUsuario preguntaProductoUsuario = preguntaProductoUsuarioService
                .obtenerPreguntaProductoUsuarioPorId(id)
                .orElse(null);

        if (preguntaProductoUsuario == null) {
            return ResponseEntity.notFound().build();
        }

        preguntaProductoUsuarioActualizado.setId(preguntaProductoUsuario.getId());
        PreguntaProductoUsuario preguntaProductoUsuarioActualizadoGuardado = preguntaProductoUsuarioService
                .actualizarPreguntaProductoUsuario(preguntaProductoUsuarioActualizado);
        return ResponseEntity.ok(preguntaProductoUsuarioActualizadoGuardado);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar preguntaProductoUsuario con ID preguntaProductoUsuario.")
    public ResponseEntity<Void> eliminarPreguntaProductoUsuario(@PathVariable Integer id) {
        preguntaProductoUsuarioService.eliminarPreguntaProductoUsuario(id);
        return ResponseEntity.noContent().build();
    }
}
