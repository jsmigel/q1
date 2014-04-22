package q1;

import java.util.*;

public class CompositeValidator implements Validator {

	private List<Validator> validators = new ArrayList<Validator>();

	public void registerValidator(Validator validator) {
		this.validators.add(validator);
	}

	public List<Validator> getValidators() {
		return validators;
	}

	public void validate(Order order) throws ValidationException {
		for(Validator validator : validators) {
			validator.validate(order);
		}
	}

}
