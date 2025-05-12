package com.Ebrahem.Taskes.Domain.entites;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(updatable = false,nullable = false)
    private UUID id;
    @Column(nullable = false)
    private String title;
    private String description;
    @Column(name = "duo_date")
    private LocalDateTime duoDate;
    @Column(name = "statues",nullable = false)
    private TaskStatues statues;
    @Column(name = "priority",nullable = false)
    private TaskPriority priority;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "task_list_id")
    private TaskList taskList;

    @Column(name = "updated",nullable = false)
    private LocalDateTime updated;
    @Column(name = "created",nullable = false)
    private LocalDateTime created;

    public Task() {
    }

    public Task(UUID id, String title, String description, LocalDateTime duoDate, TaskStatues statues, TaskPriority priority, TaskList tasksList, LocalDateTime updated, LocalDateTime created) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.duoDate = duoDate;
        this.statues = statues;
        this.priority = priority;
        this.taskList = tasksList;
        this.updated = updated;
        this.created = created;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDuoDate() {
        return duoDate;
    }

    public void setDuoDate(LocalDateTime duoDate) {
        this.duoDate = duoDate;
    }

    public TaskStatues getStatues() {
        return statues;
    }

    public void setStatues(TaskStatues statues) {
        this.statues = statues;
    }

    public TaskPriority getPriority() {
        return priority;
    }

    public void setPriority(TaskPriority priority) {
        this.priority = priority;
    }

    public TaskList getTasksList() {
        return taskList;
    }

    public void setTasksList(TaskList tasksList) {
        this.taskList = tasksList;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(id, task.id) && Objects.equals(title, task.title) && Objects.equals(description, task.description) && Objects.equals(duoDate, task.duoDate) && statues == task.statues && priority == task.priority && Objects.equals(taskList, task.taskList) && Objects.equals(updated, task.updated) && Objects.equals(created, task.created);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, duoDate, statues, priority, taskList, updated, created);
    }


    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", duoDate=" + duoDate +
                ", statues=" + statues +
                ", priority=" + priority +
                ", tasksList=" + taskList +
                ", updated=" + updated +
                ", created=" + created +
                '}';
    }
}