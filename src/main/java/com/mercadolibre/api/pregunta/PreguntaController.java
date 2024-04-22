package com.mercadolibre.api.pregunta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/preguntas")
@Tag(name = "Pregunta", description = "Operaciones relacionadas al pregunta.")
public class PreguntaController {

    @Autowired
    private PreguntaService preguntaService;

    @GetMapping
    @Operation(summary = "Obtener todas las preguntas.")
    public ResponseEntity<List<Pregunta>> obtenerTodosLosPreguntas() {
        List<Pregunta> preguntas = preguntaService.obtenerTodosLosPreguntas();
        return ResponseEntity.ok(preguntas);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener pregunta con ID pregunta.")
    public ResponseEntity<Pregunta> obtenerPreguntaPorId(@PathVariable Integer id) {
        Optional<Pregunta> pregunta = preguntaService.obtenerPreguntaPorId(id);
        return pregunta.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Crear pregunta.")
    public ResponseEntity<Pregunta> crearPregunta(@RequestBody Pregunta pregunta) {
        Pregunta nuevoPregunta = preguntaService.crearPregunta(pregunta);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoPregunta);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar pregunta con ID pregunta.")
    public ResponseEntity<Pregunta> actualizarPregunta(@PathVariable Integer id,
            @RequestBody Pregunta preguntaActualizado) {
        Pregunta pregunta = preguntaService.obtenerPreguntaPorId(id)
                .orElse(null);

        if (pregunta == null) {
            return ResponseEntity.notFound().build();
        }

        preguntaActualizado.setIdPregunta(pregunta.getIdPregunta());
        Pregunta preguntaActualizadoGuardado = preguntaService.actualizarPregunta(preguntaActualizado);
        return ResponseEntity.ok(preguntaActualizadoGuardado);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar pregunta con ID pregunta.")
    public ResponseEntity<Void> eliminarPregunta(@PathVariable Integer id) {
        preguntaService.eliminarPregunta(id);
        return ResponseEntity.noContent().build();
    }
}
