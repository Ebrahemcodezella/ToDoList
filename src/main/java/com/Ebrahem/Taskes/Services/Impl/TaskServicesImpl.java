package com.Ebrahem.Taskes.Services.Impl;

import com.Ebrahem.Taskes.Domain.entites.Task;
import com.Ebrahem.Taskes.Domain.entites.TaskList;
import com.Ebrahem.Taskes.Domain.entites.TaskPriority;
import com.Ebrahem.Taskes.Domain.entites.TaskStatues;

import com.Ebrahem.Taskes.Repositories.TaskListRepository;
import com.Ebrahem.Taskes.Repositories.TaskRepository;

import com.Ebrahem.Taskes.Services.TaskServices;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.Objects;

@Service
public class TaskServicesImpl implements TaskServices {

    private final TaskListRepository taskListRepository;
    private final TaskRepository taskRepository;

    public TaskServicesImpl(TaskListRepository taskListRepository, TaskRepository taskRepository) {
        this.taskListRepository = taskListRepository;
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Task> TaskOfList(UUID TaskListId) {
        return taskRepository.findByTaskListId(TaskListId);
    }

    @Override
    public Task CreateTask(UUID taskListId, Task task) {
        if(task.getTitle()==null||task.getTitle().isBlank()){
            throw new IllegalArgumentException(" Title Is Empty ");
        }
        TaskList taskList=taskListRepository.findById(taskListId).orElseThrow(()->new IllegalArgumentException("Invalid Task Id"));
        LocalDateTime time =LocalDateTime.now();
        Task  SaveTask=new Task(
                null,
                task.getTitle(),
                task.getDescription(),
                task.getDuoDate(),
                TaskStatues.OPEN,
                task.getPriority(),
                taskList,
                time,
                time
        );
        return taskRepository.save(SaveTask);
    }

    @Override
    public Optional<Task> getTask(UUID taskListId, UUID taskId) {
        return taskRepository.findByTaskListIdAndId(taskListId,taskId);
    }

    @Override
    public Task updateTask(UUID taskListId, UUID taskId, Task task) {
        if (!Objects.equals(taskId,task.getId())){
            throw new IllegalArgumentException("Ids not equals");
        }

        Task task1 = taskRepository.findByTaskListIdAndId(taskListId,taskId)
                .orElseThrow(()->new IllegalArgumentException("Task not found"));
        
        task1.setTitle(task.getTitle());
        task1.setDescription(task.getDescription());
        task1.setDuoDate(task.getDuoDate());
        task1.setStatues(task.getStatues());
        task1.setPriority(task.getPriority());
        task1.setUpdated(LocalDateTime.now());

        return taskRepository.save(task1);
    }
    @Transactional
    @Override
    public void deleteTask(UUID taskListId, UUID taskId) {

        taskRepository.deleteByTaskListIdAndId(taskListId,taskId);
    }


}
