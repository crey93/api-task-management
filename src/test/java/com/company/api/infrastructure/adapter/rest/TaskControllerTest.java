package com.company.api.infrastructure.adapter.rest;

import com.company.api.infrastructure.adapter.rest.dto.TaskDto;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Testcontainers
public class TaskControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Container
    private static final MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:latest");

    @BeforeEach
    public void setup() {
        System.setProperty("spring.data.mongodb.uri", mongoDBContainer.getReplicaSetUrl());
    }

    @Test
    public void testCreateTask() throws Exception {
        TaskDto taskDto = new TaskDto(
                null,
                "Task 1",
                "Description 1",
                "2022-12-31",
                null,
                null
        );


        mockMvc.perform(post("/api/v1/task/create")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(taskDto)))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void testGetAllTasks() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/api/v1/task/get-all"))
                .andDo(result -> System.out.println(result.getResponse().getContentAsString()))
                .andExpect(status().isOk())
                .andReturn();
        List<TaskDto> tasks = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), new TypeReference<List<TaskDto>>() {});
        assert !tasks.isEmpty();
    }
}