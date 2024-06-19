package com.company.api.infrastructure.mapper;

import com.company.api.domain.model.Task;
import com.company.api.infrastructure.adapter.persistence.TaskEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TaskEntityMapper {
    Task toDomain(TaskEntity taskEntity);

    List<Task> toDomainList(List<TaskEntity> taskEntityList);

    TaskEntity toEntity(Task task);
}
