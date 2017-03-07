package liuhuan.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND,reason="Spittle not found")
public class SpittleNotFoundExceptio extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SpittleNotFoundExceptio(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public SpittleNotFoundExceptio(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public SpittleNotFoundExceptio(){
		super();
	}

	public SpittleNotFoundExceptio(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}
	
}
