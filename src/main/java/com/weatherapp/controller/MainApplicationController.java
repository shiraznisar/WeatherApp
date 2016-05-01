package com.weatherapp.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author shiraz
 *
 *	This is the main application controller which displays the weatherView.jsp
 */
@Controller
public class MainApplicationController{
	
	@Value("#{citiesMap}")
	private Map<String, String> cities;

	@RequestMapping("/weather")
	public ModelAndView main(HttpServletRequest req) throws Exception {
		ModelAndView mv = new ModelAndView("weatherView");
		mv.addObject("cities", cities);
		return mv;
	}

}
