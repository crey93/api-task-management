package com.company.api.infrastructure.adapter.persistence;

import com.company.api.application.port.out.TaskRepository;
import com.company.api.domain.model.Task;
import com.company.api.infrastructure.mapper.TaskEntityMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TaskRepositoryImpl implements TaskRepository {

    private final TaskEntityMapper mapper;
    private final TaskJPARepository taskJPARepository;

    public TaskRepositoryImpl(
            TaskEntityMapper mapper,
            TaskJPARepository taskJPARepository
    ) {
        this.mapper = mapper;
        this.taskJPARepository = taskJPARepository;
    }

    @Override
    public Task save(Task task) {
        var entityToSave = mapper.toEntity(task);
        entityToSave.setStatus("PENDING");
        return mapper.toDomain(taskJPARepository.save(entityToSave));
    }

    @Override
    public List<Task> getAll() {
        return mapper.toDomainList(taskJPARepository.findAll());
    }
}
