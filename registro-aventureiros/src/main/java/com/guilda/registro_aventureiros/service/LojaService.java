package com.guilda.registro_aventureiros.service;

import co.elastic.clients.elasticsearch._types.aggregations.Aggregate;
import co.elastic.clients.elasticsearch._types.aggregations.Aggregation;
import com.guilda.registro_aventureiros.dto.ProdutoDTO;
import com.guilda.registro_aventureiros.model.elastic.ItemLoja;
import com.guilda.registro_aventureiros.repository.elastic.ItemLojaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchAggregations;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.client.elc.NativeQuery;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LojaService {

    private final ItemLojaRepository itemLojaRepository; // Repositório NoSQL Elastic
    private final ElasticsearchTemplate elasticsearchTemplate;

    // 1. BUSCA FUZZY: Tolera erros de digitação (ex: busca "Espada" se o usuário digitar "Espda")
    public List<ProdutoDTO> buscarComTolerancia(String termo) {
        NativeQuery query = NativeQuery.builder()
                .withQuery(q -> q.fuzzy(f -> f.field("nome").value(termo).fuzziness("AUTO")))
                .build();

        SearchHits<ItemLoja> hits = elasticsearchTemplate.search(query, ItemLoja.class);

        return hits.stream()
                .map(hit -> converterParaDto(hit.getContent()))
                .collect(Collectors.toList());
    }

    // 2. AGREGAÇÃO: Conta quantos itens existem por categoria (Diferencial para nota)
    public Map<String, Long> contarPorCategoria() {
        NativeQuery query = NativeQuery.builder()
                .withAggregation("por_categoria", Aggregation.of(a -> a.terms(t -> t.field("categoria").size(10))))
                .build();

        SearchHits<ItemLoja> hits = elasticsearchTemplate.search(query, ItemLoja.class);
        ElasticsearchAggregations aggregations = (ElasticsearchAggregations) hits.getAggregations();

        Aggregate aggregate = aggregations.aggregationsAsMap().get("por_categoria").aggregation().getAggregate();

        return aggregate.sterms().buckets().array().stream()
                .collect(Collectors.toMap(
                        bucket -> bucket.key().stringValue(),
                        bucket -> bucket.docCount()
                ));
    }

    // 3. MÉDIA DE PREÇOS: Usa o motor NoSQL para cálculos matemáticos rápidos
    public Double calcularMediaPrecos() {
        NativeQuery query = NativeQuery.builder()
                .withAggregation("media_preco", Aggregation.of(a -> a.avg(avg -> avg.field("preco"))))
                .build();

        SearchHits<ItemLoja> hits = elasticsearchTemplate.search(query, ItemLoja.class);
        ElasticsearchAggregations aggregations = (ElasticsearchAggregations) hits.getAggregations();

        Aggregate aggregate = aggregations.aggregationsAsMap().get("media_preco").aggregation().getAggregate();
        return aggregate.avg().value();
    }

    // Helper para converter a Entity NoSQL em DTO
    private ProdutoDTO converterParaDto(ItemLoja item) {
        return new ProdutoDTO(item.getId(), item.getNome(), item.getPreco(), item.getCategoria(), item.getRaridade());
    }
}