package com.mercadolibre.api.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public List<Item> obtenerTodosLosItems() {
        return itemRepository.findAll();
    }

    public Optional<Item> obtenerItemPorId(Integer id) {
        return itemRepository.findById(id);
    }

    public Item crearItem(Item item) {
        return itemRepository.save(item);
    }

    public Item actualizarItem(Item item) {
        return itemRepository.save(item);
    }

    public void eliminarItem(Integer id) {
        itemRepository.deleteById(id);
    }
}
