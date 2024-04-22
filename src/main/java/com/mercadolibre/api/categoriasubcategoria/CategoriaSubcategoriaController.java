package com.mercadolibre.api.categoriasubcategoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categoria-subcategorias")
@Tag(name = "CategoriaSubcategoria", description = "Operaciones relacionadas al categorias y subcategoria.")
public class CategoriaSubcategoriaController {

    @Autowired
    private CategoriaSubcategoriaService categoriaSubcategoriaService;

    @GetMapping
    @Operation(summary = "Obtener todas las categoriaSubcategorias.")
    public ResponseEntity<List<CategoriaSubcategoria>> obtenerTodosLosCategoriaSubcategorias() {
        List<CategoriaSubcategoria> categoriaSubcategorias = categoriaSubcategoriaService
                .obtenerTodosLosCategoriaSubcategorias();
        return ResponseEntity.ok(categoriaSubcategorias);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener categoriaSubcategoria con ID categoriaSubcategoria.")
    public ResponseEntity<CategoriaSubcategoria> obtenerCategoriaSubcategoriaPorId(@PathVariable Integer id) {
        Optional<CategoriaSubcategoria> categoriaSubcategoria = categoriaSubcategoriaService
                .obtenerCategoriaSubcategoriaPorId(id);
        return categoriaSubcategoria.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Crear categoriaSubcategoria.")
    public ResponseEntity<CategoriaSubcategoria> crearCategoriaSubcategoria(
            @RequestBody CategoriaSubcategoria categoriaSubcategoria) {
        CategoriaSubcategoria nuevoCategoriaSubcategoria = categoriaSubcategoriaService
                .crearCategoriaSubcategoria(categoriaSubcategoria);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoCategoriaSubcategoria);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar categoriaSubcategoria con ID categoriaSubcategoria.")
    public ResponseEntity<CategoriaSubcategoria> actualizarCategoriaSubcategoria(@PathVariable Integer id,
            @RequestBody CategoriaSubcategoria categoriaSubcategoriaActualizado) {
        CategoriaSubcategoria categoriaSubcategoria = categoriaSubcategoriaService.obtenerCategoriaSubcategoriaPorId(id)
                .orElse(null);

        if (categoriaSubcategoria == null) {
            return ResponseEntity.notFound().build();
        }

        categoriaSubcategoriaActualizado.setId(categoriaSubcategoria.getId());
        CategoriaSubcategoria categoriaSubcategoriaActualizadoGuardado = categoriaSubcategoriaService
                .actualizarCategoriaSubcategoria(categoriaSubcategoriaActualizado);
        return ResponseEntity.ok(categoriaSubcategoriaActualizadoGuardado);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar categoriaSubcategoria con ID categoriaSubcategoria.")
    public ResponseEntity<Void> eliminarCategoriaSubcategoria(@PathVariable Integer id) {
        categoriaSubcategoriaService.eliminarCategoriaSubcategoria(id);
        return ResponseEntity.noContent().build();
    }
}
