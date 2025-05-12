package com.Ebrahem.Taskes.Repositories;

import com.Ebrahem.Taskes.Domain.entites.TaskList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TaskListRepository extends JpaRepository<TaskList, UUID> {

}
