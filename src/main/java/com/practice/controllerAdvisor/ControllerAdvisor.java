package com.practice.controllerAdvisor;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.practice.model.ErrorResponceDTO;

import customException.MissingRequiredField;

@ControllerAdvice
public class ControllerAdvisor {
	
	@ExceptionHandler(MissingRequiredField.class)
	public ResponseEntity<Object> handleMissingRequiredField(MissingRequiredField ex, WebRequest request) {
		ErrorResponceDTO error = new ErrorResponceDTO();
		error.setError(ex.getMessage());
		
		List<String> details = new ArrayList<>();
		details.add("missing some essential fields");
		error.setDetails(details);
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
	
	@ExceptionHandler(SQLException.class)
	public ResponseEntity<Object> handleSQLException(SQLException ex, WebRequest request) {
		ErrorResponceDTO error = new ErrorResponceDTO();
		error.setError(ex.getMessage());
		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
