package com.killswitch.tasky.model.dto;

import lombok.Builder;
import lombok.Data;


@Builder
@Data
public class TaskDTO {
    private String title;
    private String description;
    private String status;
}
