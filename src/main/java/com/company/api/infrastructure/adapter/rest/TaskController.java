package com.company.api.infrastructure.adapter.rest;

import com.company.api.application.use_case.task.GetAllUseCase;
import com.company.api.application.use_case.task.SaveTaskUseCase;
import com.company.api.infrastructure.adapter.rest.dto.TaskDto;
import com.company.api.infrastructure.mapper.TaskDtoMapper;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/task")
public class TaskController {

    private final SaveTaskUseCase saveTaskUseCase;
    private final GetAllUseCase getAllUseCase;

    private final TaskDtoMapper mapper;

    public TaskController(
            SaveTaskUseCase saveTaskUseCase,
            GetAllUseCase getAllUseCase,
            TaskDtoMapper mapper
    ) {
        this.saveTaskUseCase = saveTaskUseCase;
        this.getAllUseCase = getAllUseCase;
        this.mapper = mapper;
    }

    @PostMapping("/create")
    public ResponseEntity<TaskDto> createTask(@Valid @RequestBody TaskDto taskDto) {
        return ResponseEntity.ok(mapper.toDto(saveTaskUseCase.save(mapper.toDomain(taskDto))));
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<TaskDto>> getAll() {
        return ResponseEntity.ok(mapper.toDtoList(getAllUseCase.getAll()));
    }
}
