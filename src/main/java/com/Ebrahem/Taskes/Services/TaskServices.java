package com.Ebrahem.Taskes.Services;

import com.Ebrahem.Taskes.Domain.entites.Task;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TaskServices {
    List<Task> TaskOfList(UUID TaskListId);
    Task CreateTask(UUID taskListId,Task task);
    Optional<Task> getTask(UUID taskListId,UUID taskId);
    Task updateTask(UUID taskListId,UUID taskId,Task task );
    void deleteTask(UUID taskListId,UUID taskId );
}
