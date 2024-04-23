package com.mercadolibre.api.imagen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/imagenes")
@Tag(name = "Imagen", description = "Operaciones relacionadas al imagen.")
public class ImagenController {

    @Autowired
    private ImagenService imagenService;

    @GetMapping
    @Operation(summary = "Obtener todas las imagenes.")
    public ResponseEntity<List<Imagen>> obtenerTodosLosImagens() {
        List<Imagen> imagens = imagenService.obtenerTodosLosImagenes();
        return ResponseEntity.ok(imagens);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener imagen con ID imagen.")
    public ResponseEntity<Imagen> obtenerImagenPorId(@PathVariable Integer id) {
        Optional<Imagen> imagen = imagenService.obtenerImagenPorId(id);
        return imagen.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Crear imagen.")
    public ResponseEntity<Imagen> crearImagen(@RequestBody Imagen imagen) {
        Imagen nuevoImagen = imagenService.crearImagen(imagen);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoImagen);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar imagen con ID imagen.")
    public ResponseEntity<Imagen> actualizarImagen(@PathVariable Integer id,
            @RequestBody Imagen imagenActualizado) {
        Imagen imagen = imagenService.obtenerImagenPorId(id)
                .orElse(null);

        if (imagen == null) {
            return ResponseEntity.notFound().build();
        }

        imagenActualizado.setId(imagen.getId());
        Imagen imagenActualizadoGuardado = imagenService.actualizarImagen(imagenActualizado);
        return ResponseEntity.ok(imagenActualizadoGuardado);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar imagen con ID imagen.")
    public ResponseEntity<Void> eliminarImagen(@PathVariable Integer id) {
        imagenService.eliminarImagen(id);
        return ResponseEntity.noContent().build();
    }
}
