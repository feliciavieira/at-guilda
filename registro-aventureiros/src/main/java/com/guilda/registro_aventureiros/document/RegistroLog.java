package com.guilda.registro_aventureiros.document;

import org.springframework.data.mongodb.core.mapping.Document;
import jakarta.persistence.Id;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Document(collection = "logs")
public class RegistroLog {
    @Id
    private String id;
    private String mensagem;
    private LocalDateTime dataHora;
}