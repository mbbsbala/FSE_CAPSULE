package com.capusule.fse.taskmanager.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.capusule.fse.taskmanager.enums.ErrorCodes;
import com.capusule.fse.taskmanager.models.APIResponse;
import com.capusule.fse.taskmanager.models.ErrorInfo;
import com.capusule.fse.taskmanager.models.InvocationResult;

@ControllerAdvice
public class TaskManagerExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = { AppException.class })
	protected ResponseEntity<Object> handleConflict(AppException ex, WebRequest request) {
		APIResponse response = new APIResponse();
		InvocationResult result = new InvocationResult();
		result.setStatus("ERROR");
		ErrorInfo error = new ErrorInfo();
		ErrorCodes errorCode = ErrorCodes.valueOf(ex.getMessage());
		error.setDesc(errorCode.getDesc());
		error.setCode(errorCode.name());
		result.setErrorInfo(error);
		response.setResult(result);
		return handleExceptionInternal(ex, response, new HttpHeaders(), HttpStatus.OK, request);
	}

}
