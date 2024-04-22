package com.mercadolibre.api.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/items")
@Tag(name = "Item", description = "Operaciones relacionadas al item.")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping
    @Operation(summary = "Obtener todas las items.")
    public ResponseEntity<List<Item>> obtenerTodosLosItems() {
        List<Item> items = itemService.obtenerTodosLosItems();
        return ResponseEntity.ok(items);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener item con ID item.")
    public ResponseEntity<Item> obtenerItemPorId(@PathVariable Integer id) {
        Optional<Item> item = itemService.obtenerItemPorId(id);
        return item.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Crear item.")
    public ResponseEntity<Item> crearItem(@RequestBody Item item) {
        Item nuevoItem = itemService.crearItem(item);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoItem);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar item con ID item.")
    public ResponseEntity<Item> actualizarItem(@PathVariable Integer id,
            @RequestBody Item itemActualizado) {
        Item item = itemService.obtenerItemPorId(id)
                .orElse(null);

        if (item == null) {
            return ResponseEntity.notFound().build();
        }

        itemActualizado.setIdItem(item.getIdItem());
        Item itemActualizadoGuardado = itemService.actualizarItem(itemActualizado);
        return ResponseEntity.ok(itemActualizadoGuardado);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar item con ID item.")
    public ResponseEntity<Void> eliminarItem(@PathVariable Integer id) {
        itemService.eliminarItem(id);
        return ResponseEntity.noContent().build();
    }
}
