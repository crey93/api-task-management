package com.company.api.application.port.out;

import com.company.api.domain.model.Task;

import java.util.List;

public interface TaskRepository {
    public Task save(Task task);
    public List<Task> getAll();
}
