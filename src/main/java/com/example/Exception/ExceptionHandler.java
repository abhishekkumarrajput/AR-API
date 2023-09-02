package com.example.Exception;

import java.util.List;

import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


@RestControllerAdvice
public class ExceptionHandler {
	
	@org.springframework.web.bind.annotation.ExceptionHandler( value=SsnWebException.class)
	public ResponseEntity<AppException>handlerSsnWebEx(SsnWebException ssnWebException){
		AppException appEx = new AppException();
		
		appEx.setExcode("EX001)");
		appEx.setExDesc(ssnWebException.getMessage());
		return new ResponseEntity<AppException>(appEx,HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
