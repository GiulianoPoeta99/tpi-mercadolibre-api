package com.mercadolibre.api.metododepago;

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
public class MetodoDePagoController {

    @Autowired
    private MetodoDePagoService metodoDePagoService;

    @GetMapping
    @Operation(summary = "Obtener todas las direcciones.")
    public ResponseEntity<List<MetodoDePago>> obtenerTodosLosMetodoDePago() {
        List<MetodoDePago> direcciones = metodoDePagoService.obtenerTodosLosMetodoDePago();
        return ResponseEntity.ok(direcciones);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener direccion con ID dirección.")
    public ResponseEntity<MetodoDePago> obtenerMetodoDePagoPorId(@PathVariable Integer id) {
        Optional<MetodoDePago> direccion = metodoDePagoService.obtenerMetodoDePagoPorId(id);
        return direccion.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Crear direccion.")
    public ResponseEntity<MetodoDePago> crearMetodoDePago(@RequestBody MetodoDePago direccion) {
        MetodoDePago nuevoMetodoDePago = metodoDePagoService.crearMetodoDePago(direccion);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoMetodoDePago);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar direccion con ID dirección.")
    public ResponseEntity<MetodoDePago> actualizarMetodoDePago(@PathVariable Integer id,
            @RequestBody MetodoDePago direccionActualizado) {
        MetodoDePago direccion = metodoDePagoService.obtenerMetodoDePagoPorId(id)
                .orElse(null);

        if (direccion == null) {
            return ResponseEntity.notFound().build();
        }

        direccionActualizado.setIdTarjeta(direccion.getIdTarjeta());
        MetodoDePago direccionActualizadoGuardado = metodoDePagoService.actualizarMetodoDePago(direccionActualizado);
        return ResponseEntity.ok(direccionActualizadoGuardado);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar direccion con ID dirección.")
    public ResponseEntity<Void> eliminarMetodoDePago(@PathVariable Integer id) {
        metodoDePagoService.eliminarMetodoDePago(id);
        return ResponseEntity.noContent().build();
    }
}
