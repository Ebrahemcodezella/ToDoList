package com.Ebrahem.Taskes.Services.Impl;

import com.Ebrahem.Taskes.Domain.Dto.TaskListDto;
import com.Ebrahem.Taskes.Domain.entites.TaskList;
import com.Ebrahem.Taskes.Repositories.TaskListRepository;
import com.Ebrahem.Taskes.Services.TaskListServices;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TaskListServicesImpl implements TaskListServices {
    private final TaskListRepository taskListRepository;


    public TaskListServicesImpl(TaskListRepository taskListRepository) {
        this.taskListRepository = taskListRepository;
    }

    @Override
    public List<TaskList> listTaskList() {
        return taskListRepository.findAll();
    }

    @Override
    public TaskList CreateTaskList(TaskList taskList) {

        if (taskList.getId()!=null){
            throw new IllegalArgumentException("Task list already exist !");
        }
        if (taskList.getTitle()==null||taskList.getTitle().isBlank())
        {
            throw new IllegalArgumentException("Task list Must be present!");
        }
        LocalDateTime now =LocalDateTime.now();
        return taskListRepository.save(new TaskList(
                null,
                taskList.getTitle(),
                taskList.getDescription(),
                null,
                now,
                now
        ));
    }

    @Override
    public Optional<TaskList> getTask(UUID id) {
        return taskListRepository.findById(id);
    }

    @Override
    public TaskList updateTaskList(UUID taskListId, TaskList taskList) {
        if(taskList.getId()==null){
            throw new IllegalArgumentException("Task list Must have Id");
        }

        if (!taskListId.equals(taskList.getId())){
            throw new IllegalArgumentException("Attempting to change Task id");
        }

//        if(taskList.getUpdated()==null){
////            System.out.println(taskList.getUpdated());
//            throw new IllegalArgumentException("Date not be Null");
//
//        }


     TaskList ExistTaskList=   taskListRepository.findById(taskListId).orElseThrow(()->
        new IllegalArgumentException("Task List Not Found")
        );

    ExistTaskList.setTitle(taskList.getTitle());
    ExistTaskList.setDescription(taskList.getDescription());
    ExistTaskList.setUpdated(taskList.getUpdated());
    return taskListRepository.save(ExistTaskList);

    }

    @Override
    public void deleteTaskList(UUID taskListID) {
    taskListRepository.deleteById(taskListID);
    }

}
