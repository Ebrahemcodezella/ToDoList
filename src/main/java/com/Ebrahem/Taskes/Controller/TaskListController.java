package com.Ebrahem.Taskes.Controller;

import com.Ebrahem.Taskes.Domain.Dto.TaskListDto;
import com.Ebrahem.Taskes.Domain.entites.TaskList;
import com.Ebrahem.Taskes.Mapper.impl.TaskListMapperImpl;
import com.Ebrahem.Taskes.Services.Impl.TaskListServicesImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/task-lists")
public class TaskListController {
    private final TaskListServicesImpl taskListServices;
    private final   TaskListMapperImpl taskListMapper;

    public TaskListController(TaskListServicesImpl taskListServices, TaskListMapperImpl taskListMapper) {
        this.taskListServices = taskListServices;
        this.taskListMapper = taskListMapper;
    }

    @GetMapping
    public List<TaskListDto> listTaskList(){
        return taskListServices.listTaskList().stream().map(
                taskListMapper::todto
        ).toList();
    }
    @PostMapping
    public TaskListDto CreateTaskList(@RequestBody TaskListDto taskListDto){
        TaskList created=taskListServices.CreateTaskList(taskListMapper.fromdto(taskListDto));
        return taskListMapper.todto(created);
    }

    @GetMapping(path = "{task_list_id}")
    public Optional<TaskListDto> getTaskList(@PathVariable ("task_list_id") UUID id){
    return  taskListServices.getTask(id).map(taskListMapper::todto);
    }


    @PutMapping(path="/{task_list_id}")
    public TaskListDto updateTaskList(
                        @PathVariable ("task_list_id") UUID taskListId
                        ,@RequestBody TaskListDto taskListDto
                )
    {

        TaskList taskList =taskListServices.updateTaskList(taskListId,taskListMapper.fromdto(taskListDto));

        return taskListMapper.todto(taskList);
    }
    @DeleteMapping(path = "/{task_list_id}")
    public void DeleteTaskList(@PathVariable("task_list_id") UUID uuid)
    {
        taskListServices.deleteTaskList(uuid);
    }


}
