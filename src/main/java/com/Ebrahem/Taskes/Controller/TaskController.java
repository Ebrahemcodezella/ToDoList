package com.Ebrahem.Taskes.Controller;

import com.Ebrahem.Taskes.Domain.Dto.TaskDto;
import com.Ebrahem.Taskes.Domain.entites.Task;
import com.Ebrahem.Taskes.Mapper.TaskMapper;
import com.Ebrahem.Taskes.Mapper.impl.TaskMapperImpl;
import com.Ebrahem.Taskes.Services.Impl.TaskServicesImpl;
import com.Ebrahem.Taskes.Services.TaskServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/task-lists/{task_list_id}/tasks")
public class TaskController {

    private final TaskServicesImpl taskServices;
    private final TaskMapperImpl taskMapper;

    public TaskController(TaskServicesImpl taskServices, TaskMapperImpl taskMapper) {
        this.taskServices = taskServices;
        this.taskMapper = taskMapper;
    }


    @GetMapping
    public List<TaskDto> GetAllTasks    (@PathVariable("task_list_id")UUID taskListId){
        return taskServices.TaskOfList(taskListId).stream().map(taskMapper::toDtoFromEntity).toList();
    }
    @PostMapping
    public TaskDto createTask(
            @PathVariable("task_list_id") UUID taskListId,
            @RequestBody TaskDto taskDto
    ) {
        Task create = taskServices.CreateTask(taskListId, taskMapper.fromDtoToEntity(taskDto));

        return taskMapper.toDtoFromEntity(create);
    }
    @GetMapping(path = "/{task_id}")
    public Optional<TaskDto>getTask(
            @PathVariable("task_list_id")UUID taskListId,
            @PathVariable("task_id") UUID taskId
    ){
        return  taskServices.getTask(taskListId,taskId).map(taskMapper::toDtoFromEntity);
    }
    @PutMapping(path = "/{task_id}")
    public TaskDto updateTask(@PathVariable("task_list_id") UUID tasklistId,
                           @PathVariable("task_id") UUID taskId,
                           @RequestBody TaskDto task
                            ){

        Task task4=  taskServices.updateTask(tasklistId,
                taskId,
                taskMapper.fromDtoToEntity(task));

        return taskMapper.toDtoFromEntity(task4);
    }
@DeleteMapping(path = "/{task_id}")
    public void deleteTask(@PathVariable("task_list_id") UUID tasklistId,
                           @PathVariable("task_id") UUID taskId)
{
taskServices.deleteTask(tasklistId,taskId);
}
}
