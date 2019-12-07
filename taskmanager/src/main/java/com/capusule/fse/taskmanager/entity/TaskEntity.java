package com.capusule.fse.taskmanager.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "task")
@Data
@ToString
public class TaskEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "task_id", length = 50)
	private Long taskId;
	
	@ManyToOne
	@JoinColumn(name = "parenttask_id" , nullable = true)
	private ParentTaskEntity parentTask;
	
	@Column(name = "task", length = 50, nullable = false)
	private String task;
	
	@Column(name = "start_date", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date startDate;
	
	@Column(name = "end_date", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date endDate;
	
	@Column(nullable = false)
	private int priority;

}
