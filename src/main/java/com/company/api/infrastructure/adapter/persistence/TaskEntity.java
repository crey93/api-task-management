package com.company.api.infrastructure.adapter.persistence;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

/**
 * Task entity
 */
@Document(collection = "tasks")
@Data
@Getter
@Setter
public class TaskEntity {

    @Id
    private String id;
    private String title;
    private String description;
    private LocalDate dueDate;
    private List<String> tags;
    private String status;


}
