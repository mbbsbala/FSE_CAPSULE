package com.capusule.fse.taskmanager.response;

import java.util.List;

import com.capusule.fse.taskmanager.models.APIResponse;
import com.capusule.fse.taskmanager.models.Task;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class ViewAllTaskResponse extends APIResponse {

	private List<Task> taskList;
	
	public ViewAllTaskResponse(){
		new APIResponse();
	}
	
}
