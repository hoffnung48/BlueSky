package mx.com.bluesky.commons.validator;

import org.springframework.stereotype.Component;

import mx.com.bluesky.commons.constant.EnumError;
import mx.com.bluesky.commons.exception.BusinessServiceException;

@Component
public class Validator {

	public void isEmptyOrNull(String string) {
		if (string == null || string.trim().isEmpty()) {
			this.throwWrongParameters();
		}
	}

	public void isNull(Object object) {
		if (object == null) {
			this.throwWrongParameters();
		}
	}
	
	public void throwWrongParameters () {
		throw new BusinessServiceException(EnumError.WRONG_PARAMETERS.name());
	}

}
