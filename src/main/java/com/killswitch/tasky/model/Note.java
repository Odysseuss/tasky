package com.killswitch.tasky.model;

import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = "notes")
public class Note {

    @Id
    private String id;

    private Long taskId;
    private String content;
    private LocalDateTime createdAt;
}
