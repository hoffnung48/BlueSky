package mx.com.bluesky.integrationtest;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.util.NestedServletException;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Ignore
public class WeatherIntegrationTest {

	 @Autowired
	 private MockMvc mockMvc;
	 

	    @Test
	    public void getWeatherTest() throws Exception {
	        this.mockMvc.perform(get("/weather/city/London")).andDo(print()).andExpect(status().isOk())
	          .andExpect(content().string(containsString("London")));
	    }
	    
	    @Test(expected=NestedServletException.class)
	    public void getWeatherExceptionTest() throws Exception {
	        this.mockMvc.perform(get("/weather/city/x")).andDo(print()).andExpect(status().is5xxServerError())
	          .andExpect(content().string(containsString("404")));
	    }
}
