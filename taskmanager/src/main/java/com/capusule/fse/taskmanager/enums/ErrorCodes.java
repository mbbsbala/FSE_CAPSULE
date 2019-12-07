package com.capusule.fse.taskmanager.enums;

public enum ErrorCodes {

	SYS_DEFAULT_ERROR("Sorry We are unable to process the request right now. Please try again later."),
	SYS_INVALID_REQUEST("Request is not valid"),
	SYS_DB_ERROR("Sorry We are unable to process the request right now. Please try again later.");

	ErrorCodes(String errordesc) {
		this.setErrorDesc(errordesc);
	}

	public String getErrorDesc() {
		return errorDesc;
	}

	public void setErrorDesc(String errorDesc) {
		this.errorDesc = errorDesc;
	}

	private String errorDesc;
}
