package com.killswitch.tasky.model.mapper;

import com.killswitch.tasky.model.dto.NoteDTO;
import com.killswitch.tasky.model.entity.Note;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface NoteMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "taskId", ignore = true)
    Note toEntity(NoteDTO noteDTO);

    NoteDTO toDto(Note note);
}
