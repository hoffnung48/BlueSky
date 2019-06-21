package mx.com.bluesky.commons.validator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import mx.com.bluesky.commons.constant.EnumError;
import mx.com.bluesky.commons.exception.BusinessServiceException;
import mx.com.bluesky.commons.validator.Validator;

@RunWith(MockitoJUnitRunner.class)
public class ValidatorTest {
	
	@InjectMocks
	private Validator validator;

	@Test
	public void isEmptyOrNullTest() {
		validator.isEmptyOrNull("val");
	}
	
	@Test(expected=BusinessServiceException.class)
	public void isEmptyOrNullTestNull() {
		validator.isEmptyOrNull(null);
	}
	
	@Test(expected=BusinessServiceException.class)
	public void isEmptyOrNullTestEmpty() {
		validator.isEmptyOrNull("");
	}

	@Test()
	public void isNullTest() {
		validator.isNull("val");
	}
	
	@Test(expected=BusinessServiceException.class)
	public void isNullTestNull() {
		validator.isNull(null);
	}
	
	@Test(expected=BusinessServiceException.class)
	public void throwWrongParametersTest() {
		throw new BusinessServiceException(EnumError.WRONG_PARAMETERS.name());
	}

}
