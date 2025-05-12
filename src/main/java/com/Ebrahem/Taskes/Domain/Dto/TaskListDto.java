package com.Ebrahem.Taskes.Domain.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Min;

// import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record TaskListDto(
        UUID id,
        @NotBlank(message = "Title cannot be empty")
        String title,
        String description,
        @Min(value = 0, message = "Count cannot be negative")
        Integer count,
        @Min(value = 0, message = "Progress cannot be negative")
        double progress,
        List<TaskDto> tasks
) {
}
