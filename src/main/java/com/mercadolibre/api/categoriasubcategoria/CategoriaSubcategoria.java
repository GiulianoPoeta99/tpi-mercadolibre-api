package com.mercadolibre.api.categoriasubcategoria;

import com.mercadolibre.api.categoria.Categoria;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "categoria_subcategoria", schema = "public")
@Data
public class CategoriaSubcategoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tiene_categoria", nullable = false)
    private Categoria tieneCategoria;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "es_subcategoria", nullable = false)
    private Categoria esSubcategoria;

    public CategoriaSubcategoria() {
    }

    public CategoriaSubcategoria(Categoria tieneCategoria, Categoria esSubcategoria) {
        this.tieneCategoria = tieneCategoria;
        this.esSubcategoria = esSubcategoria;
    }
}
