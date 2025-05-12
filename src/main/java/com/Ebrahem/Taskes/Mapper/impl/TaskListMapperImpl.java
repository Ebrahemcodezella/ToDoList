package com.Ebrahem.Taskes.Mapper.impl;

import com.Ebrahem.Taskes.Domain.Dto.TaskListDto;
import com.Ebrahem.Taskes.Domain.entites.Task;
import com.Ebrahem.Taskes.Domain.entites.TaskList;
import com.Ebrahem.Taskes.Domain.entites.TaskStatues;
import com.Ebrahem.Taskes.Mapper.TaskListMapper;
import com.Ebrahem.Taskes.Mapper.TaskMapper;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
@Component
public class TaskListMapperImpl implements TaskListMapper {
    private final TaskMapper taskMapper;

    public TaskListMapperImpl(TaskMapper taskMapper) {
        this.taskMapper = taskMapper;
    }


    @Override
    public TaskList fromdto(TaskListDto taskListDto) {
        return new TaskList(
                taskListDto.id(),
                taskListDto.title(),
                taskListDto.description(),
                Optional.ofNullable(taskListDto.tasks())
                        .map(taskDtos -> taskDtos.stream()
                                .map(taskMapper::fromDtoToEntity)
                                .toList())
                        .orElse(null),
                LocalDateTime.now(),
                LocalDateTime.now()
        );
    }

    @Override
    public TaskListDto todto(TaskList taskList) {
        return new TaskListDto(
                taskList.getId(),
                taskList.getTitle(),
                taskList.getDescription(),
                Optional.ofNullable(taskList.getTasks())
                        .map(List::size)
                        .orElse(0),
                calculateTaskListProgress(taskList.getTasks()),
                Optional.ofNullable(taskList.getTasks())
                        .map(task->
                                task.stream().map(taskMapper::toDtoFromEntity).toList())
                        .orElse(null)
        );
    }


    private Double calculateTaskListProgress(List <Task> tasks)
    {
        if(null==tasks||tasks.isEmpty()) {
            return 0.0;
        }


        long closedTaskCount=tasks.stream().filter(
                task->
                        TaskStatues.CLOSED==task.getStatues()
        ).count();

        return (double) closedTaskCount/tasks.size();
    }
}
