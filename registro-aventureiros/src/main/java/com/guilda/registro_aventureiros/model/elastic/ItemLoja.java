package com.guilda.registro_aventureiros.model.elastic;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
@Document(indexName = "itens_loja") // Nome do "índice" no Elastic
public class ItemLoja {

    @Id
    private String id; // ID é String

    @Field(type = FieldType.Text, name = "nome")
    private String nome;

    @Field(type = FieldType.Text, name = "descricao")
    private String descricao;

    @Field(type = FieldType.Double, name = "preco")
    private Double preco;

    @Field(type = FieldType.Keyword, name = "categoria")
    private String categoria;

    @Field(type = FieldType.Keyword, name = "raridade")
    private String raridade;
}