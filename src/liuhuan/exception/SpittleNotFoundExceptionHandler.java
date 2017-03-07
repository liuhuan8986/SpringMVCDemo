package liuhuan.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class SpittleNotFoundExceptionHandler {
	
	
	@ExceptionHandler(SpittleNotFoundException.class)
	public String handSpittleNotFoundException(){
		return "error";
	}
}
