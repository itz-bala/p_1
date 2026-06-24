package main.Exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String,String>>validation_handling(MethodArgumentNotValidException ex){
		
		
		Map<String,String>errors=new HashMap<>();
		
		
		ex.getBindingResult().getFieldErrors() 
		  .forEach(e->errors.put(e.getField(), e.getDefaultMessage()));
		
		
		return new ResponseEntity<>(errors,HttpStatus.BAD_REQUEST);
		
		
		
	}
	
	@ExceptionHandler(PatientNotFoundException.class)
	public ResponseEntity<String>not_found(PatientNotFoundException ex){
		
		
		return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
		
	}

}
