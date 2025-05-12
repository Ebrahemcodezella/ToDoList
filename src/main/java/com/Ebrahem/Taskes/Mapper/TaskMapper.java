package com.Ebrahem.Taskes.Mapper;

import com.Ebrahem.Taskes.Domain.Dto.TaskDto;
import com.Ebrahem.Taskes.Domain.entites.Task;

public interface TaskMapper {
    Task fromDtoToEntity(TaskDto taskDto);
    TaskDto toDtoFromEntity(Task task);
}
