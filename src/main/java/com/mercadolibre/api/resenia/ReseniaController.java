package com.mercadolibre.api.resenia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/resenias")
@Tag(name = "Resenia", description = "Operaciones relacionadas al resenia.")
public class ReseniaController {

    @Autowired
    private ReseniaService reseniaService;

    @GetMapping
    @Operation(summary = "Obtener todas las resenias.")
    public ResponseEntity<List<Resenia>> obtenerTodosLosResenias() {
        List<Resenia> resenias = reseniaService.obtenerTodosLosResenias();
        return ResponseEntity.ok(resenias);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener resenia con ID resenia.")
    public ResponseEntity<Resenia> obtenerReseniaPorId(@PathVariable Integer id) {
        Optional<Resenia> resenia = reseniaService.obtenerReseniaPorId(id);
        return resenia.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Crear resenia.")
    public ResponseEntity<Resenia> crearResenia(@RequestBody Resenia resenia) {
        Resenia nuevoResenia = reseniaService.crearResenia(resenia);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoResenia);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar resenia con ID resenia.")
    public ResponseEntity<Resenia> actualizarResenia(@PathVariable Integer id,
            @RequestBody Resenia reseniaActualizado) {
        Resenia resenia = reseniaService.obtenerReseniaPorId(id)
                .orElse(null);

        if (resenia == null) {
            return ResponseEntity.notFound().build();
        }

        reseniaActualizado.setIdResenia(resenia.getIdResenia());
        Resenia reseniaActualizadoGuardado = reseniaService.actualizarResenia(reseniaActualizado);
        return ResponseEntity.ok(reseniaActualizadoGuardado);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar resenia con ID resenia.")
    public ResponseEntity<Void> eliminarResenia(@PathVariable Integer id) {
        reseniaService.eliminarResenia(id);
        return ResponseEntity.noContent().build();
    }
}
