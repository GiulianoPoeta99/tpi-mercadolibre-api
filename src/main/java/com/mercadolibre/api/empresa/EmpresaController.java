package com.mercadolibre.api.empresa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/empresas")
@Tag(name = "Empresa", description = "Operaciones relacionadas a la empresa.")
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    @GetMapping
    @Operation(summary = "Obtener todas los empresas.")
    public ResponseEntity<List<Empresa>> obtenerTodasLasEmpresas() {
        List<Empresa> empresas = empresaService.obtenerTodosLosEmpresas();
        return ResponseEntity.ok(empresas);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener empresa con numero de cliente.")
    public ResponseEntity<Empresa> obtenerEmpresaPorId(@PathVariable Integer id) {
        Optional<Empresa> empresa = empresaService.obtenerEmpresaPorId(id);
        return empresa.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Crear empresa.")
    public ResponseEntity<Empresa> crearEmpresa(@RequestBody Empresa empresa) {
        Empresa nuevaEmpresa = empresaService.crearEmpresa(empresa);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaEmpresa);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar empresa con numero de cliente.")
    public ResponseEntity<Empresa> actualizarEmpresa(@PathVariable Integer id,
            @RequestBody Empresa empresaActualizada) {
        Empresa empresa = empresaService.obtenerEmpresaPorId(id)
                .orElse(null);

        if (empresa == null) {
            return ResponseEntity.notFound().build();
        }

        empresaActualizada.setUsuario(empresa.getUsuario());
        Empresa empresaActualizadaGuardada = empresaService.actualizarEmpresa(empresaActualizada);
        return ResponseEntity.ok(empresaActualizadaGuardada);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar empresa con numero de cliente.")
    public ResponseEntity<Void> eliminarEmpresa(@PathVariable Integer id) {
        empresaService.eliminarEmpresa(id);
        return ResponseEntity.noContent().build();
    }
}
