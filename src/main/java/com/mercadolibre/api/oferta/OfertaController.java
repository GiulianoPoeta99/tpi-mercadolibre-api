package com.mercadolibre.api.oferta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ofertas")
@Tag(name = "Oferta", description = "Operaciones relacionadas al oferta.")
public class OfertaController {

    @Autowired
    private OfertaService productoService;

    @GetMapping
    @Operation(summary = "Obtener todos los ofertas.")
    public ResponseEntity<List<Oferta>> obtenerTodosLosOfertas() {
        List<Oferta> ofertas = productoService.obtenerTodosLosOfertas();
        return ResponseEntity.ok(ofertas);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener oferta con numero de cliente.")
    public ResponseEntity<Oferta> obtenerOfertaPorId(@PathVariable Integer id) {
        Optional<Oferta> oferta = productoService.obtenerOfertaPorId(id);
        return oferta.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Crear oferta.")
    public ResponseEntity<Oferta> crearOferta(@RequestBody Oferta oferta) {
        Oferta nuevoOferta = productoService.crearOferta(oferta);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoOferta);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar oferta con numero de cliente.")
    public ResponseEntity<Oferta> actualizarOferta(@PathVariable Integer id,
            @RequestBody Oferta productoActualizado) {
        Oferta oferta = productoService.obtenerOfertaPorId(id)
                .orElse(null);

        if (oferta == null) {
            return ResponseEntity.notFound().build();
        }

        productoActualizado.setIdOferta(oferta.getIdOferta());
        Oferta productoActualizadoGuardado = productoService.actualizarOferta(productoActualizado);
        return ResponseEntity.ok(productoActualizadoGuardado);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar oferta con numero de cliente.")
    public ResponseEntity<Void> eliminarOferta(@PathVariable Integer id) {
        productoService.eliminarOferta(id);
        return ResponseEntity.noContent().build();
    }
}
