package com.capusule.fse.taskmanager.enums;

public enum ErrorCodes {

	SYS_DEFAULT_ERROR("Sorry We are unable to process the request right now. Please try again later."),
	SYS_INVALID_REQUEST("Request is not valid"),
	SYS_DB_ERROR("Sorry We are unable to process the request right now. Please try again later.");

	private String code;
	private String desc;

	private ErrorCodes(String desc) {
		this.code = name();
		this.desc = desc;
	}

	public String getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	};
}
