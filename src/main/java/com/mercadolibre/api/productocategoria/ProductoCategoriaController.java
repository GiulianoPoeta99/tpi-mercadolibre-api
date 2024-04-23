package com.mercadolibre.api.productocategoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/productos-categorias")
@Tag(name = "Producto Categoria", description = "Operaciones relacionadas al productoCategoria.")
public class ProductoCategoriaController {

    @Autowired
    private ProductoCategoriaService productoCategoriaService;

    @GetMapping
    @Operation(summary = "Obtener todas las productoCategorias.")
    public ResponseEntity<List<ProductoCategoria>> obtenerTodosLosProductoCategorias() {
        List<ProductoCategoria> productoCategorias = productoCategoriaService.obtenerTodosLosProductosCategorias();
        return ResponseEntity.ok(productoCategorias);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener productoCategoria con ID productoCategoria.")
    public ResponseEntity<ProductoCategoria> obtenerProductoCategoriaPorId(@PathVariable Integer id) {
        Optional<ProductoCategoria> productoCategoria = productoCategoriaService.obtenerProductoCategoriaPorId(id);
        return productoCategoria.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Crear productoCategoria.")
    public ResponseEntity<ProductoCategoria> crearProductoCategoria(@RequestBody ProductoCategoria productoCategoria) {
        ProductoCategoria nuevoProductoCategoria = productoCategoriaService.crearProductoCategoria(productoCategoria);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoProductoCategoria);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar productoCategoria con ID productoCategoria.")
    public ResponseEntity<ProductoCategoria> actualizarProductoCategoria(@PathVariable Integer id,
            @RequestBody ProductoCategoria productoCategoriaActualizado) {
        ProductoCategoria productoCategoria = productoCategoriaService.obtenerProductoCategoriaPorId(id)
                .orElse(null);

        if (productoCategoria == null) {
            return ResponseEntity.notFound().build();
        }

        productoCategoriaActualizado.setId(productoCategoria.getId());
        ProductoCategoria productoCategoriaActualizadoGuardado = productoCategoriaService
                .actualizarProductoCategoria(productoCategoriaActualizado);
        return ResponseEntity.ok(productoCategoriaActualizadoGuardado);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar productoCategoria con ID productoCategoria.")
    public ResponseEntity<Void> eliminarProductoCategoria(@PathVariable Integer id) {
        productoCategoriaService.eliminarProductoCategoria(id);
        return ResponseEntity.noContent().build();
    }
}
