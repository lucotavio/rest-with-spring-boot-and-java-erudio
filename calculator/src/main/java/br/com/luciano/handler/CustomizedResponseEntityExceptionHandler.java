package br.com.luciano.handler;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import br.com.luciano.exception.ExceptionResponse;
import br.com.luciano.exception.UnsupportedMathOperationException;

@RestController
@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{

	public final ResponseEntity<ExceptionResponse> handleBadRequestExceptions(UnsupportedMathOperationException ex, WebRequest request){
		
		ExceptionResponse exceptionResponse = ExceptionResponse.builder()
				.timestamp(LocalDateTime.now())
				.message(ex.getMessage())
				.details(request.getDescription(false))
				.build();
		
		return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}
}
