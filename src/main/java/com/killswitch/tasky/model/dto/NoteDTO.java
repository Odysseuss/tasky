package com.killswitch.tasky.model.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
public class NoteDTO {
    private String content;
    private LocalDateTime createdAt;
}
