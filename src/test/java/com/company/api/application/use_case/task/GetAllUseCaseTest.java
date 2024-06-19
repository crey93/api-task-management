package com.company.api.application.use_case.task;

import com.company.api.application.port.out.TaskRepository;
import com.company.api.domain.model.Task;
import com.company.api.domain.model.TaskStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class GetAllUseCaseTest {

    private TaskRepository taskRepository;
    private GetAllUseCase getAllUseCase;

    @BeforeEach
    public void setup() {
        taskRepository = Mockito.mock(TaskRepository.class);
        getAllUseCase = new GetAllUseCase(taskRepository);
    }

    @Test
    public void getAllTasksTest() {
        List<Task> mockTasks = List.of(new Task(
                        "doc-number-1",
                        "Task 1",
                        "Description 1",
                        LocalDate.now().plusDays(1),
                        List.of("java", "php"),
                        TaskStatus.PENDING
                ),
                new Task(
                        "doc-number-2",
                        "Task 2",
                        "Description 2",
                        LocalDate.now().plusDays(2),
                        List.of("java", "php"),
                        TaskStatus.PENDING
                ));
        when(taskRepository.getAll()).thenReturn(mockTasks);

        var tasks = getAllUseCase.getAll();

        //Validations
        assertNotNull(tasks);
        assertEquals(2, tasks.size());
        verify(taskRepository, times(1)).getAll();
    }
}