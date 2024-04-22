package com.mercadolibre.api.resenia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ReseniaService {

    @Autowired
    private ReseniaRepository reseniaRepository;

    public List<Resenia> obtenerTodosLosResenias() {
        return reseniaRepository.findAll();
    }

    public Optional<Resenia> obtenerReseniaPorId(Integer id) {
        return reseniaRepository.findById(id);
    }

    public Resenia crearResenia(Resenia resenia) {
        return reseniaRepository.save(resenia);
    }

    public Resenia actualizarResenia(Resenia resenia) {
        return reseniaRepository.save(resenia);
    }

    public void eliminarResenia(Integer id) {
        reseniaRepository.deleteById(id);
    }
}
