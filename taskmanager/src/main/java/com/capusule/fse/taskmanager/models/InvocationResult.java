package com.capusule.fse.taskmanager.models;

import java.io.Serializable;

import com.capusule.fse.taskmanager.enums.ErrorCodes;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class InvocationResult implements Serializable {
	
	private static final long serialVersionUID = -1241891850592877729L;

	private String status;
	private ErrorInfo errorInfo;
	private Object[] msgArgs;
	
	public void setFailure(String code, String desc){
		this.status = "ERROR";
		this.errorInfo = new ErrorInfo(code, desc);
	}

	public void setFailure(ErrorCodes errorCodes){
		this.status = "ERROR";
		this.errorInfo = new ErrorInfo(errorCodes.getCode(), errorCodes.getDesc());
	}

	public void setFailure(ErrorCodes errorCodes, String errorMessage){
		this.status = "ERROR";
		this.errorInfo = new ErrorInfo(errorCodes.getCode(), errorMessage);
	}
	
	@JsonIgnore
	public boolean isSuccess(){
		return "SUCCESS".equalsIgnoreCase(status);
	}
	
	@JsonIgnore
	public void setSuccess(){
		this.status = "SUCCESS";
		this.errorInfo = null;
	}


}
