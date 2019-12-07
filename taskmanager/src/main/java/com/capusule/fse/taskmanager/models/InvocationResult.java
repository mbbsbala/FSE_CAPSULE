package com.capusule.fse.taskmanager.models;

import lombok.Data;

@Data
public class InvocationResult {

	private String status;
	private ErrorInfo error;
	
	public InvocationResult() {
		this.status = "SUCCESS";
	}
}
