package mx.com.bluesky;

import java.awt.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.client.RestTemplate;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ComponentScan
@EnableSwagger2
public class BlueSkyApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlueSkyApplication.class, args);
	}
	
	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
	
	@ModelAttribute("cityId")
	public String cityId(String cityId) {
	    return cityId;
	}

}
