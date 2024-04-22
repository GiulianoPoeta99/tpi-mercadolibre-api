package com.mercadolibre.api.direccion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/direcciones")
@Tag(name = "Dirección", description = "Operaciones relacionadas a las direcciones.")
public class DireccionController {

    @Autowired
    private DireccionService direccionService;

    @GetMapping
    @Operation(summary = "Obtener todas las direcciones.")
    public ResponseEntity<List<Direccion>> obtenerTodosLosDirecciones() {
        List<Direccion> direcciones = direccionService.obtenerTodasLasDirecciones();
        return ResponseEntity.ok(direcciones);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener direccion con ID dirección.")
    public ResponseEntity<Direccion> obtenerDireccionPorId(@PathVariable Integer id) {
        Optional<Direccion> direccion = direccionService.obtenerDireccionPorId(id);
        return direccion.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Crear direccion.")
    public ResponseEntity<Direccion> crearDireccion(@RequestBody Direccion direccion) {
        Direccion nuevoDireccion = direccionService.crearDireccion(direccion);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoDireccion);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar direccion con ID dirección.")
    public ResponseEntity<Direccion> actualizarDireccion(@PathVariable Integer id,
            @RequestBody Direccion direccionActualizado) {
        Direccion direccion = direccionService.obtenerDireccionPorId(id)
                .orElse(null);

        if (direccion == null) {
            return ResponseEntity.notFound().build();
        }

        direccionActualizado.setIdDireccion(direccion.getIdDireccion());
        Direccion direccionActualizadoGuardado = direccionService.actualizarDireccion(direccionActualizado);
        return ResponseEntity.ok(direccionActualizadoGuardado);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar direccion con ID dirección.")
    public ResponseEntity<Void> eliminarDireccion(@PathVariable Integer id) {
        direccionService.eliminarDireccion(id);
        return ResponseEntity.noContent().build();
    }
}
