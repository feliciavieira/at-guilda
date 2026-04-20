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

    @Field(type = FieldType.Text, name = "nome") //tokenização das palavras
    private String nome;

    @Field(type = FieldType.Text, name = "descricao")// tokenização das palavras
    private String descricao;

    @Field(type = FieldType.Double, name = "preco") // tratar esse dado como um valor numérico de dupla precisã
    private Double preco;

    @Field(type = FieldType.Keyword, name = "categoria") //filtragem
    private String categoria;

    @Field(type = FieldType.Keyword, name = "raridade")
    private String raridade;
}