package com.company.api.application.use_case.task;

import com.company.api.application.port.out.TaskRepository;
import com.company.api.domain.model.Task;
import com.company.api.domain.model.TaskStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class SaveTaskUseCaseTest {

    private TaskRepository taskRepository;
    private SaveTaskUseCase getAllTaskUseCase;

    @BeforeEach
    public void setup() {
        taskRepository = Mockito.mock(TaskRepository.class);
        getAllTaskUseCase = new SaveTaskUseCase(taskRepository);
    }

    @Test
    public void saveTaskTest() {
        Task task = new Task(
                "doc-number-1",
                "Task 1",
                "Description 1",
                LocalDate.now().plusDays(1),
                List.of("java", "php"),
                TaskStatus.PENDING
        );
        when(taskRepository.save(any(Task.class))).thenReturn(task);
        var responseTask = getAllTaskUseCase.save(task);

        //Validations
        assert responseTask != null;
        assert responseTask.id().equals("doc-number-1");
        verify(taskRepository, times(1)).save(any(Task.class));
    }
}