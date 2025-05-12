package com.Ebrahem.Taskes.Domain.Dto;

import com.Ebrahem.Taskes.Domain.entites.TaskPriority;
import com.Ebrahem.Taskes.Domain.entites.TaskStatues;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.UUID;

public record TaskDto(
        UUID id,
        @NotBlank(message = "Title cannot be empty")
        String title,
        String description,
        @NotNull(message = "Due date cannot be null")
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        LocalDateTime duoDate,
        @NotNull(message = "Status cannot be null")
        TaskStatues statues,
        @NotNull(message = "Priority cannot be null")
        TaskPriority priority
) {
   
}