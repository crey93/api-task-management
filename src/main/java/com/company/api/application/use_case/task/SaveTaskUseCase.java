package com.company.api.application.use_case.task;

import com.company.api.application.port.out.TaskRepository;
import com.company.api.domain.model.Task;
import org.springframework.stereotype.Service;

/**
 * Get all task use case
 */
@Service
public class SaveTaskUseCase {

    private final TaskRepository taskRepository;

    /**
     * Constructor
     *
     */
    public SaveTaskUseCase(
            TaskRepository taskRepository
    ) {
        this.taskRepository = taskRepository;
    }

    /**
     * Save tasks
     *
     * @param task
     * @return, the saved task
     */
    public Task save(Task task) {
        return taskRepository.save(task);
    }


}
