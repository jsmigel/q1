package q1;

public class MockValidator implements Validator {

	private int validationCount = 0;
	private boolean exception;

	public void validate(Order order) throws ValidationException {
		validationCount ++;
		if(exception) {
			throw new ValidationException();
		}
	}

	public Object getValidationCount() {
		return validationCount;
	}

	public void setException() {
		this.exception = true;
	}

}
