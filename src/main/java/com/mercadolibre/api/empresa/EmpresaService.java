package com.mercadolibre.api.empresa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    public List<Empresa> obtenerTodosLosEmpresas() {
        return empresaRepository.findAll();
    }

    public Optional<Empresa> obtenerEmpresaPorId(Integer id) {
        return empresaRepository.findById(id);
    }

    public Empresa crearEmpresa(Empresa usuario) {
        return empresaRepository.save(usuario);
    }

    public Empresa actualizarEmpresa(Empresa usuario) {
        return empresaRepository.save(usuario);
    }

    public void eliminarEmpresa(Integer id) {
        empresaRepository.deleteById(id);
    }
}
