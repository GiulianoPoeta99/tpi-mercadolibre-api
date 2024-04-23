package com.mercadolibre.api.ofertaproducto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ofertas-productos")
@Tag(name = "Oferta Producto", description = "Operaciones relacionadas al ofertaProducto.")
public class OfertaProductoController {

    @Autowired
    private OfertaProductoService ofertaProductoService;

    @GetMapping
    @Operation(summary = "Obtener todas las ofertaProductos.")
    public ResponseEntity<List<OfertaProducto>> obtenerTodosLosOfertaProductos() {
        List<OfertaProducto> ofertaProductos = ofertaProductoService.obtenerTodosLosOfertasProductos();
        return ResponseEntity.ok(ofertaProductos);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener ofertaProducto con ID ofertaProducto.")
    public ResponseEntity<OfertaProducto> obtenerOfertaProductoPorId(@PathVariable Integer id) {
        Optional<OfertaProducto> ofertaProducto = ofertaProductoService.obtenerOfertaProductoPorId(id);
        return ofertaProducto.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Crear ofertaProducto.")
    public ResponseEntity<OfertaProducto> crearOfertaProducto(@RequestBody OfertaProducto ofertaProducto) {
        OfertaProducto nuevoOfertaProducto = ofertaProductoService.crearOfertaProducto(ofertaProducto);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoOfertaProducto);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar ofertaProducto con ID ofertaProducto.")
    public ResponseEntity<OfertaProducto> actualizarOfertaProducto(@PathVariable Integer id,
            @RequestBody OfertaProducto ofertaProductoActualizado) {
        OfertaProducto ofertaProducto = ofertaProductoService.obtenerOfertaProductoPorId(id)
                .orElse(null);

        if (ofertaProducto == null) {
            return ResponseEntity.notFound().build();
        }

        ofertaProductoActualizado.setId(ofertaProducto.getId());
        OfertaProducto ofertaProductoActualizadoGuardado = ofertaProductoService
                .actualizarOfertaProducto(ofertaProductoActualizado);
        return ResponseEntity.ok(ofertaProductoActualizadoGuardado);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar ofertaProducto con ID ofertaProducto.")
    public ResponseEntity<Void> eliminarOfertaProducto(@PathVariable Integer id) {
        ofertaProductoService.eliminarOfertaProducto(id);
        return ResponseEntity.noContent().build();
    }
}
