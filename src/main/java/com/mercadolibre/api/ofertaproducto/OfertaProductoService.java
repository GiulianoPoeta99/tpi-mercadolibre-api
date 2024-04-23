package com.mercadolibre.api.ofertaproducto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class OfertaProductoService {

    @Autowired
    private OfertaProductoRepository ofertaProductoRepository;

    public List<OfertaProducto> obtenerTodosLosOfertasProductos() {
        return ofertaProductoRepository.findAll();
    }

    public Optional<OfertaProducto> obtenerOfertaProductoPorId(Integer id) {
        return ofertaProductoRepository.findById(id);
    }

    public OfertaProducto crearOfertaProducto(OfertaProducto ofertaProducto) {
        return ofertaProductoRepository.save(ofertaProducto);
    }

    public OfertaProducto actualizarOfertaProducto(OfertaProducto ofertaProducto) {
        return ofertaProductoRepository.save(ofertaProducto);
    }

    public void eliminarOfertaProducto(Integer id) {
        ofertaProductoRepository.deleteById(id);
    }
}
