package q1;

import static org.junit.Assert.*;

import org.junit.Test;

import q1.Validator.ValidationException;

public class CompositeValidatorTest {

	@Test
	public void testRegisterValidator() {
		Validator validator1 = new MockValidator();
		
		CompositeValidator validator = new CompositeValidator();
		
		validator.registerValidator (validator1);
		
		assertTrue(validator.getValidators().contains(validator1));
		assertEquals(validator1, validator.getValidators().get(0));
	}

	@Test
	public void testRegisterMultiplerValidators() {
		Validator validator1 = new MockValidator();
		Validator validator2 = new MockValidator();
		
		CompositeValidator validator = new CompositeValidator();
		
		validator.registerValidator (validator1);
		validator.registerValidator (validator2);
		
		assertEquals(2, validator.getValidators().size());
		assertTrue(validator.getValidators().contains(validator1));
		assertTrue(validator.getValidators().contains(validator2));
	}
	
	@Test
	public void testValidateOrder() throws ValidationException {
		MockValidator validator1 = new MockValidator();
		MockValidator validator2 = new MockValidator();
		
		CompositeValidator validator = new CompositeValidator();
		validator.registerValidator(validator1);
		validator.registerValidator(validator2);
		
		Order order = new MockOrder();
		
		validator.validate ( order );
		
		assertEquals(1, validator1.getValidationCount());
		assertEquals(1, validator2.getValidationCount());
	}

	@Test
	public void testValidateOrderFails() {
		MockValidator validator1 = new MockValidator();
		validator1.setException();
		
		CompositeValidator validator = new CompositeValidator();
		validator.registerValidator(validator1);
		
		Order order = new MockOrder();
		
		try {
			validator.validate ( order );
			fail("Expected Exception");
		} catch (ValidationException e) {
			assertEquals(1, validator1.getValidationCount());
		}
		
		
	}

}
