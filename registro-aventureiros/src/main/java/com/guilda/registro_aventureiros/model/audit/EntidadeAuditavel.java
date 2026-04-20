package com.guilda.registro_aventureiros.model.audit;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDateTime;

@Data
@MappedSuperclass
public abstract class EntidadeAuditavel {

    @CreationTimestamp //framework gerencia as datas de criação e alteração garantindo a rastreabilidade
    @Column(name = "created_at", updatable = false)
    private LocalDateTime dataCriacao;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime dataAtualizacao;
}