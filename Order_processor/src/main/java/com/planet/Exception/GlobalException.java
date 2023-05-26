package com.planet.Exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.planet.Error.OrderErrorResponse;



@ControllerAdvice
public class GlobalException extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(FilenotsavedException.class)
	public ResponseEntity<OrderErrorResponse> handelAdminError(FilenotsavedException filenotsavedException , WebRequest webRequest){
		
		OrderErrorResponse adminErrorResponse = new OrderErrorResponse(LocalDateTime.now(),filenotsavedException.getMessage(),
				webRequest.getDescription(false),HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(adminErrorResponse,HttpStatus.NOT_FOUND) ;
		}
	
	
	
	@ExceptionHandler(OrderNotavailable.class)
	public ResponseEntity<OrderErrorResponse> handelAdminError(OrderNotavailable orderNotavailable , WebRequest webRequest){
		
		OrderErrorResponse adminErrorResponse = new OrderErrorResponse(LocalDateTime.now(),orderNotavailable.getMessage(),
				webRequest.getDescription(false),HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(adminErrorResponse,HttpStatus.NOT_FOUND) ;
		}
	

}
