package q1;

public interface Validator {
	
	public class ValidationException extends Exception {

		private static final long serialVersionUID = 1L;
		
	}

	void validate(Order order) throws ValidationException;

}
