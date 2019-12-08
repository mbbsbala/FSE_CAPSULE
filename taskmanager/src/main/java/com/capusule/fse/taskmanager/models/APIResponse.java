package com.capusule.fse.taskmanager.models;

import java.io.Serializable;

import com.capusule.fse.taskmanager.enums.ErrorCodes;

import lombok.Data;

@Data
public  class APIResponse implements Serializable {

	private static final long serialVersionUID = -3174514298897132826L;

	private InvocationResult result;

	public APIResponse() {
		super();
		result = new InvocationResult();
		result.setSuccess();
	}

	public void setError(ErrorCodes errorCode){
		this.result.setFailure(errorCode);
	}
	
	public void setError(ErrorCodes errorCode, Object... args){
		this.result.setMsgArgs(args);
		this.result.setFailure(errorCode, (String)args[0]);
	}
	
	public void setError(final String code, final String desc) {
		this.result.setFailure(code, desc); 
	}
}
