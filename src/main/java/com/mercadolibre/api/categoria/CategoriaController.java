package com.mercadolibre.api.categoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categorias")
@Tag(name = "Categoria", description = "Operaciones relacionadas al categoria.")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    @Operation(summary = "Obtener todos los categorias.")
    public ResponseEntity<List<Categoria>> obtenerTodosLosCategorias() {
        List<Categoria> categorias = categoriaService.obtenerTodasLasCategorias();
        return ResponseEntity.ok(categorias);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener categoria con numero de cliente.")
    public ResponseEntity<Categoria> obtenerCategoriaPorId(@PathVariable Integer id) {
        Optional<Categoria> categoria = categoriaService.obtenerCategoriaPorId(id);
        return categoria.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Crear categoria.")
    public ResponseEntity<Categoria> crearCategoria(@RequestBody Categoria categoria) {
        Categoria nuevoCategoria = categoriaService.crearCategoria(categoria);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoCategoria);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar categoria con numero de cliente.")
    public ResponseEntity<Categoria> actualizarCategoria(@PathVariable Integer id,
            @RequestBody Categoria categoriaActualizado) {
        Categoria categoria = categoriaService.obtenerCategoriaPorId(id)
                .orElse(null);

        if (categoria == null) {
            return ResponseEntity.notFound().build();
        }

        categoriaActualizado.setIdCategoria(categoria.getIdCategoria());
        Categoria categoriaActualizadoGuardado = categoriaService.actualizarCategoria(categoriaActualizado);
        return ResponseEntity.ok(categoriaActualizadoGuardado);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar categoria con numero de cliente.")
    public ResponseEntity<Void> eliminarCategoria(@PathVariable Integer id) {
        categoriaService.eliminarCategoria(id);
        return ResponseEntity.noContent().build();
    }
}
