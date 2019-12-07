package com.capusule.fse.taskmanager.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "parent_task")
@Data
public class ParentTaskEntity {

	@Id
	@Column(name = "parenttask_id", length = 50)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long parentId;
	
	@Column(name = "parent_task", length = 50)
	private String parentTask;
}
