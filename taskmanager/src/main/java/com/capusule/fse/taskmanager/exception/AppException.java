package com.capusule.fse.taskmanager.exception;

import com.capusule.fse.taskmanager.enums.ErrorCodes;

public class AppException extends RuntimeException {

	public AppException(ErrorCodes error) {
        super(error.name());
    }
}
