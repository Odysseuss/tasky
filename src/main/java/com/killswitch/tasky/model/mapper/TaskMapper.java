package com.killswitch.tasky.model.mapper;

import com.killswitch.tasky.model.dto.TaskDTO;
import com.killswitch.tasky.model.entity.Task;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface TaskMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "version", ignore = true)
    Task toEntity(TaskDTO taskDto);

    TaskDTO toDto(Task task);
}
