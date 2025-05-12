package com.Ebrahem.Taskes.Domain.entites;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
public class TaskList {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(updatable = false,nullable = false)
    private UUID id;
    @Column(nullable = false)
    private String title;
    private String description;
    @OneToMany(mappedBy = "taskList",cascade = {CascadeType.REMOVE,CascadeType.PERSIST})
    private List<Task> tasks;
    @Column(nullable = false)
    private LocalDateTime updated;
    @Column(nullable = false)
    private LocalDateTime created;

    public TaskList() {
    }

    public TaskList(UUID id, String title, String description, List<Task> tasks, LocalDateTime updated, LocalDateTime created) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.tasks = tasks;
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

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
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
        TaskList taskList = (TaskList) o;
        return Objects.equals(id, taskList.id) && Objects.equals(title, taskList.title) && Objects.equals(description, taskList.description) && Objects.equals(tasks, taskList.tasks) && Objects.equals(updated, taskList.updated) && Objects.equals(created, taskList.created);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, tasks, updated, created);
    }

    @Override
    public String toString() {
        return "TaskList{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", tasks=" + tasks +
                ", updated=" + updated +
                ", created=" + created +
                '}';
    }
}
