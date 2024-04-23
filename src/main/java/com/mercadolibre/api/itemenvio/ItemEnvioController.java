package com.mercadolibre.api.itemenvio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/item-envios")
@Tag(name = "Item Envio", description = "Operaciones relacionadas al itemEnvio.")
public class ItemEnvioController {

    @Autowired
    private ItemEnvioService itemEnvioService;

    @GetMapping
    @Operation(summary = "Obtener todas las itemEnvios.")
    public ResponseEntity<List<ItemEnvio>> obtenerTodosLosItemsEnvios() {
        List<ItemEnvio> itemEnvios = itemEnvioService.obtenerTodosLosItemsEnvios();
        return ResponseEntity.ok(itemEnvios);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener itemEnvio con ID itemEnvio.")
    public ResponseEntity<ItemEnvio> obtenerItemEnvioPorId(@PathVariable Integer id) {
        Optional<ItemEnvio> itemEnvio = itemEnvioService.obtenerItemEnvioPorId(id);
        return itemEnvio.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Crear itemEnvio.")
    public ResponseEntity<ItemEnvio> crearItemEnvio(@RequestBody ItemEnvio itemEnvio) {
        ItemEnvio nuevoItemEnvio = itemEnvioService.crearItemEnvio(itemEnvio);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoItemEnvio);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar itemEnvio con ID itemEnvio.")
    public ResponseEntity<ItemEnvio> actualizarItemEnvio(@PathVariable Integer id,
            @RequestBody ItemEnvio itemEnvioActualizado) {
        ItemEnvio itemEnvio = itemEnvioService.obtenerItemEnvioPorId(id)
                .orElse(null);

        if (itemEnvio == null) {
            return ResponseEntity.notFound().build();
        }

        itemEnvioActualizado.setId(itemEnvio.getId());
        ItemEnvio itemEnvioActualizadoGuardado = itemEnvioService.actualizarItemEnvio(itemEnvioActualizado);
        return ResponseEntity.ok(itemEnvioActualizadoGuardado);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar itemEnvio con ID itemEnvio.")
    public ResponseEntity<Void> eliminarItemEnvio(@PathVariable Integer id) {
        itemEnvioService.eliminarItemEnvio(id);
        return ResponseEntity.noContent().build();
    }
}
