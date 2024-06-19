package com.company.api.domain.model;


import java.time.LocalDate;
import java.util.List;

/**
 * Task entity
 *
 * @param id
 * @param title
 * @param description
 * @param dueDate
 * @param tags
 * @param status
 */
public record Task(

        String id,
        String title,
        String description,
        LocalDate dueDate,
        List<String> tags,
        TaskStatus status
) {
}
