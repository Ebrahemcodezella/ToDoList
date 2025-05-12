package com.Ebrahem.Taskes.Mapper.impl;

import com.Ebrahem.Taskes.Domain.Dto.TaskDto;
import com.Ebrahem.Taskes.Domain.entites.Task;
import com.Ebrahem.Taskes.Domain.entites.TaskList;
import com.Ebrahem.Taskes.Domain.entites.TaskPriority;
import com.Ebrahem.Taskes.Domain.entites.TaskStatues;
import com.Ebrahem.Taskes.Mapper.TaskMapper;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class TaskMapperImpl implements TaskMapper {

    @Override
    public Task fromDtoToEntity(TaskDto taskDto) {
        if (taskDto == null) {
            return null;
        }

        LocalDateTime now = LocalDateTime.now();

        return new Task(
                taskDto.id(),
                taskDto.title(),
                taskDto.description(),
                taskDto.duoDate(),
                taskDto.statues(),
                taskDto.priority(),
                null, // taskList will be set by the service
                now,  // updated time
                now   // created time
        );
    }

    @Override
    public TaskDto toDtoFromEntity(Task task) {
        if (task==null) {
            return null;
        }
        return new TaskDto(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getDuoDate(),
                task.getStatues(),
                task.getPriority()
        );
    }
}
