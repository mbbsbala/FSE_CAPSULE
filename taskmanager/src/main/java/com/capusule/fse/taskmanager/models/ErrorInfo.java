package com.capusule.fse.taskmanager.models;

import java.io.Serializable;

import lombok.Data;

@Data
public class ErrorInfo implements Serializable {
	private static final long serialVersionUID = -3506107965770628658L;
	private String code;
	private String desc;

	public ErrorInfo() {
		super();
	}
	
	public ErrorInfo(String code, String desc) {
		super();
		this.code = code;
		this.desc = desc;
	}
}