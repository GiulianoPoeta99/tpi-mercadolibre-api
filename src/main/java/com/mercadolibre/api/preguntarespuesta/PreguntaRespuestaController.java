package com.mercadolibre.api.preguntarespuesta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pregunta-respuestas")
@Tag(name = "Pregunta Respuesta", description = "Operaciones relacionadas al preguntaRespuesta.")
public class PreguntaRespuestaController {

    @Autowired
    private PreguntaRespuestaService preguntaRespuestaService;

    @GetMapping
    @Operation(summary = "Obtener todas las preguntaRespuestas.")
    public ResponseEntity<List<PreguntaRespuesta>> obtenerTodosLosPreguntaRespuestas() {
        List<PreguntaRespuesta> preguntaRespuestas = preguntaRespuestaService.obtenerTodosLosPreguntaRespuestas();
        return ResponseEntity.ok(preguntaRespuestas);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener preguntaRespuesta con ID preguntaRespuesta.")
    public ResponseEntity<PreguntaRespuesta> obtenerPreguntaRespuestaPorId(@PathVariable Integer id) {
        Optional<PreguntaRespuesta> preguntaRespuesta = preguntaRespuestaService.obtenerPreguntaRespuestaPorId(id);
        return preguntaRespuesta.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Crear preguntaRespuesta.")
    public ResponseEntity<PreguntaRespuesta> crearPreguntaRespuesta(@RequestBody PreguntaRespuesta preguntaRespuesta) {
        PreguntaRespuesta nuevoPreguntaRespuesta = preguntaRespuestaService.crearPreguntaRespuesta(preguntaRespuesta);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoPreguntaRespuesta);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar preguntaRespuesta con ID preguntaRespuesta.")
    public ResponseEntity<PreguntaRespuesta> actualizarPreguntaRespuesta(@PathVariable Integer id,
            @RequestBody PreguntaRespuesta preguntaRespuestaActualizado) {
        PreguntaRespuesta preguntaRespuesta = preguntaRespuestaService.obtenerPreguntaRespuestaPorId(id)
                .orElse(null);

        if (preguntaRespuesta == null) {
            return ResponseEntity.notFound().build();
        }

        preguntaRespuestaActualizado.setId(preguntaRespuesta.getId());
        PreguntaRespuesta preguntaRespuestaActualizadoGuardado = preguntaRespuestaService
                .actualizarPreguntaRespuesta(preguntaRespuestaActualizado);
        return ResponseEntity.ok(preguntaRespuestaActualizadoGuardado);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar preguntaRespuesta con ID preguntaRespuesta.")
    public ResponseEntity<Void> eliminarPreguntaRespuesta(@PathVariable Integer id) {
        preguntaRespuestaService.eliminarPreguntaRespuesta(id);
        return ResponseEntity.noContent().build();
    }
}
