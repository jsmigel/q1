package q1;

import java.util.List;

import q1.Validator.ValidationException;

public interface OrderValidator {

	void registerValidator(Validator validator);

	List<Validator> getValidators();

	void validateOrder(Order order) throws ValidationException;

}
