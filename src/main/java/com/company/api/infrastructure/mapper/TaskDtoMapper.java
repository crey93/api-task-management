package com.company.api.infrastructure.mapper;

import com.company.api.domain.model.Task;
import com.company.api.infrastructure.adapter.rest.dto.TaskDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TaskDtoMapper {

    Task toDomain(TaskDto taskDto);

    TaskDto toDto(Task task);

    List<TaskDto> toDtoList(List<Task> taskList);
}
