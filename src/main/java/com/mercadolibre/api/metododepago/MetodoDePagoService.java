package com.mercadolibre.api.metododepago;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MetodoDePagoService {

    @Autowired
    private MetodoDePagoRepository metodoDePagoRepository;

    public List<MetodoDePago> obtenerTodosLosMetodoDePago() {
        return metodoDePagoRepository.findAll();
    }

    public Optional<MetodoDePago> obtenerMetodoDePagoPorId(Integer id) {
        return metodoDePagoRepository.findById(id);
    }

    public MetodoDePago crearMetodoDePago(MetodoDePago direccion) {
        return metodoDePagoRepository.save(direccion);
    }

    public MetodoDePago actualizarMetodoDePago(MetodoDePago direccion) {
        return metodoDePagoRepository.save(direccion);
    }

    public void eliminarMetodoDePago(Integer id) {
        metodoDePagoRepository.deleteById(id);
    }
}
