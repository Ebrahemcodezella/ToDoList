package com.Ebrahem.Taskes.Services;

import com.Ebrahem.Taskes.Domain.Dto.TaskListDto;
import com.Ebrahem.Taskes.Domain.entites.TaskList;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TaskListServices {
    List<TaskList> listTaskList();
    TaskList CreateTaskList(TaskList taskList);
    Optional <TaskList>  getTask(UUID id);
    TaskList updateTaskList(UUID taskListId,TaskList taskList);
    void deleteTaskList(UUID taskListID);
}
