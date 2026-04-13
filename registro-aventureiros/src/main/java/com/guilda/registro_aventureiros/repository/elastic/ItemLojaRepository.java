package com.guilda.registro_aventureiros.repository.elastic;

import com.guilda.registro_aventureiros.model.elastic.ItemLoja;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ItemLojaRepository extends ElasticsearchRepository<ItemLoja, String> {

    // Busca itens pelo nome ou descrição (Busca textual avançada)
    List<ItemLoja> findByNomeContainingOrDescricaoContaining(String nome, String descricao);

    // Busca itens de uma categoria específica com preço abaixo de X
    List<ItemLoja> findByCategoriaAndPrecoLessThan(String categoria, Double precoMaximo);

    // Busca por categoria exata
    List<ItemLoja> findByCategoriaIgnoreCase(String categoria);
}