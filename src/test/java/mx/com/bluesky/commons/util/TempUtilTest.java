package mx.com.bluesky.commons.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TempUtilTest {
	 
	@InjectMocks
	private TempUtil util;
	
	@Test
	public void fromkelvinToCelsius(){
		float result = util.fromkelvinToCelsius(280);
		
		assertNotNull(result);
		assertTrue(result == (280-273.15f));
	}
	
	@Test
	public void fromkelvinToFarenheit(){
		
		float result = util.fromkelvinToFarenheit(280);
		assertNotNull(result);
		assertTrue(result == ((280*1.8f) - 459.67f));
	}	

}
