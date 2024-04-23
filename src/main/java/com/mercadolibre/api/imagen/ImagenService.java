package com.mercadolibre.api.imagen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ImagenService {

    @Autowired
    private ImagenRepository imagenRepository;

    public List<Imagen> obtenerTodosLosImagenes() {
        return imagenRepository.findAll();
    }

    public Optional<Imagen> obtenerImagenPorId(Integer id) {
        return imagenRepository.findById(id);
    }

    public Imagen crearImagen(Imagen imagen) {
        return imagenRepository.save(imagen);
    }

    public Imagen actualizarImagen(Imagen imagen) {
        return imagenRepository.save(imagen);
    }

    public void eliminarImagen(Integer id) {
        imagenRepository.deleteById(id);
    }
}
