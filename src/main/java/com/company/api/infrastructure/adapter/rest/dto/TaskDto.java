package com.company.api.infrastructure.adapter.rest.dto;

import com.company.api.domain.model.TaskStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Task DTO
 *
 * @param id
 * @param title
 * @param description
 * @param dueDate
 * @param tags
 * @param status
 */
@Data
@Getter
@Setter
@AllArgsConstructor
public class TaskDto {
    private String id;

    @NotBlank(message = "Title cannot be null")
    String title;

    @NotBlank(message = "Description cannot be null")
    String description;

    @NotBlank(message = "Due Date cannot be null")
    @JsonFormat(pattern = "YYYY-MM-dd")
    String dueDate;

    List<String> tags;

    String status = TaskStatus.PENDING.name();
}
