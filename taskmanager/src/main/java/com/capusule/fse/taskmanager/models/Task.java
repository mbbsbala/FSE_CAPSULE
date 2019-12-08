package com.capusule.fse.taskmanager.models;


import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class Task {

	@NonNull
	private String task;
	
	private String parentTask;
	
	@NonNull
	private int priority;
	
	@NonNull
	private String startDate;
	
	@NonNull
	private String endDate;
	
	private String taskId;
	
	private String parentTaskId;
	
	private boolean editable;
}
