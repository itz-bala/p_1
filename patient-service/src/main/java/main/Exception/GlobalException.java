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
	public ResponseEntity<Map<String,String>>validation_Handling(MethodArgumentNotValidException ex){
		
		
		Map<String,String>errors=new HashMap<>();
		
		
		ex.getBindingResult().getFieldErrors() 
		 .forEach(e->errors.put(e.getField(),e.getDefaultMessage()));
		
		
		return new ResponseEntity<>(errors,HttpStatus.BAD_REQUEST);
		
		
		
	}
	
	@ExceptionHandler(EmailNotFoundException.class)
	
	public ResponseEntity<String>email_not_found(EmailNotFoundException ex){
		
		
		
		return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
		
	}
	
	
	@ExceptionHandler(EmailExistsException.class)
	public ResponseEntity<String>email_exists(EmailExistsException ex){
		
		
		return new ResponseEntity<>(ex.getMessage(),HttpStatus.CONFLICT);
	}
		
		
	

}
