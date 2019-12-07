package com.capusule.fse.taskmanager.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capusule.fse.taskmanager.entity.ParentTaskEntity;

@Repository
public interface ParentTaskRepository extends JpaRepository<ParentTaskEntity, Long>{

}
