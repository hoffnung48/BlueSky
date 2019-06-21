package mx.com.bluesky.controller.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import mx.com.bluesky.commons.exception.BusinessServiceException;
import mx.com.bluesky.commons.validator.Validator;
import mx.com.bluesky.model.dto.WeatherDto;
import mx.com.bluesky.service.WeatherService;

@Controller
public class WeatherControllerImpl {

	private static final String DATE_PARAMETER = "date";
	private static final String CITY_NAME_PARAMETER = "cityName";
	private static final String WEATHER_PARAMETER = "weather";
	private static final String FAHRENHEIT_PARAMETER = "tempFahrenheit";
	private static final String CELSIUS_PARAMETER = "tempCelsius";
	private static final String SUNRISE_PARAMETER = "sunrise";
	private static final String SUNSET_PARAMETER = "sunset";
	private static final String SELECTED_OPTION = "selectedOption";
	private static final String SHOW_RESULT = "showResult";
	private static final String WEATHER_VIEW = "weatherView";
	private static final String ERROR_VIEW = "errorView";
	private static final String ERROR = "error";

	@Autowired
	private WeatherService service;

	@Autowired
	private Validator validator;

	@RequestMapping("/")
	public String getWeatherView(Model model) {
		model.addAttribute(SHOW_RESULT, false);
		model.addAttribute(SELECTED_OPTION, "London");
		return WEATHER_VIEW;
	}

	@ApiOperation(value = "get the weather", notes = "This endpoint gets the weather from a city", response = HttpStatus.class, tags = {
			"Wheater" })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "The confirmation code.", response = WeatherDto.class),
			@ApiResponse(code = 400, message = "service not found"),
			@ApiResponse(code = 500, message = "Bussines service ERROR", response = BusinessServiceException.class) })
	@PostMapping("/weather/city")
	public String getWeather(@RequestParam String cityId, Model model, HttpSession session,
			HttpServletRequest request) {
		validator.isEmptyOrNull(cityId);

		WeatherDto responseModel = service.getWeather(cityId);
		model.addAttribute(DATE_PARAMETER, responseModel.getDate());
		model.addAttribute(CITY_NAME_PARAMETER, responseModel.getCity());
		model.addAttribute(WEATHER_PARAMETER, responseModel.getDescription());
		model.addAttribute(FAHRENHEIT_PARAMETER, responseModel.getTempFarenheit());
		model.addAttribute(CELSIUS_PARAMETER, responseModel.getTempCelsius());
		model.addAttribute(SUNRISE_PARAMETER, responseModel.getSunrise());
		model.addAttribute(SUNSET_PARAMETER, responseModel.getSunset());

		model.addAttribute(SELECTED_OPTION, cityId);
		model.addAttribute(SHOW_RESULT, true);

		return WEATHER_VIEW;
	}

}
