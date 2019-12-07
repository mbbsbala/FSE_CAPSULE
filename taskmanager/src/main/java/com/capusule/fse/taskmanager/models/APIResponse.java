package com.capusule.fse.taskmanager.models;

import lombok.Data;

@Data
public class APIResponse {

	private InvocationResult result;
	
	public APIResponse() {
		setSuccess();
	}
	
	public void setSuccess() {
		InvocationResult result = new InvocationResult();
		result.setStatus("SUCCESS");
	}
	
	public void setError() {
		InvocationResult result = new InvocationResult();
		result.setStatus("ERROR");
	}
}
