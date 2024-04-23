package com.mercadolibre.api.itemenvio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ItemEnvioService {

    @Autowired
    private ItemEnvioRepository itemEnvioRepository;

    public List<ItemEnvio> obtenerTodosLosItemsEnvios() {
        return itemEnvioRepository.findAll();
    }

    public Optional<ItemEnvio> obtenerItemEnvioPorId(Integer id) {
        return itemEnvioRepository.findById(id);
    }

    public ItemEnvio crearItemEnvio(ItemEnvio itemEnvio) {
        return itemEnvioRepository.save(itemEnvio);
    }

    public ItemEnvio actualizarItemEnvio(ItemEnvio itemEnvio) {
        return itemEnvioRepository.save(itemEnvio);
    }

    public void eliminarItemEnvio(Integer id) {
        itemEnvioRepository.deleteById(id);
    }
}
