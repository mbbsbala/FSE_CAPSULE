package com.capusule.fse.taskmanager.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capusule.fse.taskmanager.entity.ParentTaskEntity;
import com.capusule.fse.taskmanager.entity.TaskEntity;

@Repository
public interface TaskRepository extends JpaRepository<TaskEntity, Long>{

	List<TaskEntity> findByParentTask(ParentTaskEntity parentTask);
}
