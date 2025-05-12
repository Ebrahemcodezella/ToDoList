package com.Ebrahem.Taskes.Repositories;

import com.Ebrahem.Taskes.Domain.entites.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Repository
public interface TaskRepository extends JpaRepository<Task, UUID> {
List<Task> findByTaskListId(UUID tasksListId);
Optional<Task>findByTaskListIdAndId( UUID tasksListId,UUID id);
void deleteByTaskListIdAndId(UUID tasksListId,UUID id);
}
