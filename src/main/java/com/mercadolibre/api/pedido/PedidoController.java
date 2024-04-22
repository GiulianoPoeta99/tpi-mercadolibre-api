package com.mercadolibre.api.pedido;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pedidos")
@Tag(name = "Pedido", description = "Operaciones relacionadas al pedido.")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    @Operation(summary = "Obtener todas las pedidos.")
    public ResponseEntity<List<Pedido>> obtenerTodosLosPedidos() {
        List<Pedido> pedidos = pedidoService.obtenerTodosLosPedidos();
        return ResponseEntity.ok(pedidos);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener pedido con ID pedido.")
    public ResponseEntity<Pedido> obtenerPedidoPorId(@PathVariable Integer id) {
        Optional<Pedido> pedido = pedidoService.obtenerPedidoPorId(id);
        return pedido.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Crear pedido.")
    public ResponseEntity<Pedido> crearPedido(@RequestBody Pedido pedido) {
        Pedido nuevoPedido = pedidoService.crearPedido(pedido);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoPedido);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar pedido con ID pedido.")
    public ResponseEntity<Pedido> actualizarPedido(@PathVariable Integer id,
            @RequestBody Pedido pedidoActualizado) {
        Pedido pedido = pedidoService.obtenerPedidoPorId(id)
                .orElse(null);

        if (pedido == null) {
            return ResponseEntity.notFound().build();
        }

        pedidoActualizado.setNumeroDePedido(pedido.getNumeroDePedido());
        Pedido pedidoActualizadoGuardado = pedidoService.actualizarPedido(pedidoActualizado);
        return ResponseEntity.ok(pedidoActualizadoGuardado);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar pedido con ID pedido.")
    public ResponseEntity<Void> eliminarPedido(@PathVariable Integer id) {
        pedidoService.eliminarPedido(id);
        return ResponseEntity.noContent().build();
    }
}
