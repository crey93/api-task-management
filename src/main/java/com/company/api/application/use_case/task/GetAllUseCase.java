package com.company.api.application.use_case.task;

import com.company.api.application.port.out.TaskRepository;
import com.company.api.domain.model.Task;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * Get all task use case
 * */
@Service
public class GetAllUseCase {
    private final TaskRepository taskRepository;

    /**
     * Constructor
     */
    public GetAllUseCase(
            TaskRepository taskRepository
    ) {
        this.taskRepository = taskRepository;
    }


    /**
     * Get all tasks
     *
     * @return, the list of tasks
     */
    public List<Task> getAll() {
        return taskRepository.getAll();
    }
}
