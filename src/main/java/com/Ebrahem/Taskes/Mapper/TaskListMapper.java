package com.Ebrahem.Taskes.Mapper;

import com.Ebrahem.Taskes.Domain.Dto.TaskListDto;
import com.Ebrahem.Taskes.Domain.entites.TaskList;

public interface TaskListMapper {

    TaskList fromdto(TaskListDto taskListDto);

    TaskListDto todto(TaskList taskList);
}
