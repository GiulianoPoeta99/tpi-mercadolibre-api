package com.mercadolibre.api.particular;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ParticularService {

    @Autowired
    private ParticiularRepository particiularRepository;

    public List<Particular> obtenerTodosLosParticulares() {
        return particiularRepository.findAll();
    }

    public Optional<Particular> obtenerParticularPorId(Integer id) {
        return particiularRepository.findById(id);
    }

    public Particular crearParticular(Particular usuario) {
        return particiularRepository.save(usuario);
    }

    public Particular actualizarParticular(Particular usuario) {
        return particiularRepository.save(usuario);
    }

    public void eliminarParticular(Integer id) {
        particiularRepository.deleteById(id);
    }
}
