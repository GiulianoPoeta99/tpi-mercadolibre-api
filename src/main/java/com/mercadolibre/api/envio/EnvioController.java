package com.mercadolibre.api.envio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/envios")
@Tag(name = "Envio", description = "Operaciones relacionadas al envio.")
public class EnvioController {

    @Autowired
    private EnvioService envioService;

    @GetMapping
    @Operation(summary = "Obtener todos los envios.")
    public ResponseEntity<List<Envio>> obtenerTodosLosEnvios() {
        List<Envio> envios = envioService.obtenerTodosLosEnvios();
        return ResponseEntity.ok(envios);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener envio con ID envio.")
    public ResponseEntity<Envio> obtenerEnvioPorId(@PathVariable Integer id) {
        Optional<Envio> envio = envioService.obtenerEnvioPorId(id);
        return envio.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Crear envio.")
    public ResponseEntity<Envio> crearEnvio(@RequestBody Envio envio) {
        Envio nuevoEnvio = envioService.crearEnvio(envio);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoEnvio);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar envio con ID envio.")
    public ResponseEntity<Envio> actualizarEnvio(@PathVariable Integer id,
            @RequestBody Envio envioActualizado) {
        Envio envio = envioService.obtenerEnvioPorId(id)
                .orElse(null);

        if (envio == null) {
            return ResponseEntity.notFound().build();
        }

        envioActualizado.setIdEnvio(envio.getIdEnvio());
        Envio envioActualizadoGuardado = envioService.actualizarEnvio(envioActualizado);
        return ResponseEntity.ok(envioActualizadoGuardado);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar envio con ID envio.")
    public ResponseEntity<Void> eliminarEnvio(@PathVariable Integer id) {
        envioService.eliminarEnvio(id);
        return ResponseEntity.noContent().build();
    }
}
