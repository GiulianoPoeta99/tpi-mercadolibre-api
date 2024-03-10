package com.mercadolibre.api.particular;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/particulares")
@Tag(name = "Particular", description = "Operaciones relacionadas al particular.")
public class ParticularController {

    @Autowired
    private ParticularService particularService;

    @GetMapping
    @Operation(summary = "Obtener todas los particulares.")
    public ResponseEntity<List<Particular>> obtenerTodasLasParticulars() {
        List<Particular> particulares = particularService.obtenerTodosLosParticulares();
        return ResponseEntity.ok(particulares);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener particular con numero de cliente.")
    public ResponseEntity<Particular> obtenerParticularPorId(@PathVariable Integer id) {
        Optional<Particular> particular = particularService.obtenerParticularPorId(id);
        return particular.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Crear particular.")
    public ResponseEntity<Particular> crearParticular(@RequestBody Particular particular) {
        Particular nuevaParticular = particularService.crearParticular(particular);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaParticular);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar particular con numero de cliente.")
    public ResponseEntity<Particular> actualizarParticular(@PathVariable Integer id,
            @RequestBody Particular particularActualizada) {
        Particular particular = particularService.obtenerParticularPorId(id)
                .orElse(null);

        if (particular == null) {
            return ResponseEntity.notFound().build();
        }

        particularActualizada.setUsuario(particular.getUsuario());
        Particular particularActualizadaGuardada = particularService.actualizarParticular(particularActualizada);
        return ResponseEntity.ok(particularActualizadaGuardada);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar particular con numero de cliente.")
    public ResponseEntity<Void> eliminarParticular(@PathVariable Integer id) {
        particularService.eliminarParticular(id);
        return ResponseEntity.noContent().build();
    }
}
