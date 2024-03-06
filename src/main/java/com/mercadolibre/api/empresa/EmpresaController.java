package com.mercadolibre.api.empresa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    @GetMapping
    public ResponseEntity<List<Empresa>> obtenerTodasLasEmpresas() {
        List<Empresa> empresas = empresaService.obtenerTodosLosEmpresas();
        return ResponseEntity.ok(empresas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empresa> obtenerEmpresaPorId(@PathVariable Integer id) {
        Optional<Empresa> empresa = empresaService.obtenerEmpresaPorId(id);
        return empresa.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Empresa> crearEmpresa(@RequestBody Empresa empresa) {
        Empresa nuevaEmpresa = empresaService.crearEmpresa(empresa);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaEmpresa);
    }

    @PutMapping("/{id}")
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
    public ResponseEntity<Void> eliminarEmpresa(@PathVariable Integer id) {
        empresaService.eliminarEmpresa(id);
        return ResponseEntity.noContent().build();
    }
}
