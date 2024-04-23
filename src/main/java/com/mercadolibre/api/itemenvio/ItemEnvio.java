package com.mercadolibre.api.itemenvio;

import com.mercadolibre.api.item.Item;
import com.mercadolibre.api.envio.Envio;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "item_envio", schema = "public")
@Data
public class ItemEnvio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item", nullable = false)
    private Item item;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "envio", nullable = false)
    private Envio envio;

    public ItemEnvio() {
    }

    public ItemEnvio(Item item, Envio envio) {
        this.item = item;
        this.envio = envio;
    }
}
